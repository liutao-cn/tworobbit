package cn.t18.est.service.impl;

import cn.t18.est.mapper.EvaluateDetailMapper;
import cn.t18.est.mapper.EvaluateMapper;
import cn.t18.est.mapper.MalfunctionMapper;
import cn.t18.est.mapper.MalfunctionOptionsMapper;
import cn.t18.est.pojo.*;
import cn.t18.est.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评估业务接口实现类
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Resource
    private MalfunctionMapper malfunctionMapper;  //注入评估异常
    @Resource
    private MalfunctionOptionsMapper optionsMapper;  //注入异常对象
    @Resource
    private EvaluateMapper evaluateMapper;
    @Resource
    private EvaluateDetailMapper detailMapper;

    //获取评估异常和异常对象
    @Override
    public List<Malfunction> getSpecList(Long modelId) throws Exception {
        List<Malfunction> malfunctions = malfunctionMapper.queryMalfunctionByModelId(modelId);
        for (Malfunction malfunction : malfunctions) {
            List<MalfunctionOptions> options = optionsMapper.queryOptionBymalfId(malfunction.getId());
            malfunction.setOptionsList(options);
        }
        return malfunctions;
    }

    //评估信息
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Evaluate getAssess(Long modelId, Long[] ids, Users users) throws Exception {
        //根据故障id数组获取故障选项字典表
        List<MalfunctionOptions> malfunctionOptions = optionsMapper.selectByids(ids);
        //用于存放维修估价的总价格
        BigDecimal total=BigDecimal.ZERO;
        //用于临时存放评估详细数据的集合
        List<EvaluateDetail> eva=new ArrayList<EvaluateDetail>();
        //遍历故障选项字典表
        for (MalfunctionOptions options : malfunctionOptions) {
             //通过故障选项字典表的故障id取到对应的故障表
            Malfunction malfunction = malfunctionMapper.selectByPrimaryKey(options.getMalfId());
            //计算维修价格=最高维修价格*比例
            BigDecimal ratio = new BigDecimal(options.getRatio().toString());   //拿到比列转换成BigDecimal类型
            BigDecimal mainTotal = new BigDecimal(malfunction.getMaintainTopPrice().toString());   //将最高维修价格转换成bigDecimal类型
            ratio=ratio.divide(new BigDecimal("100"));    //将比列除100得到比例值
            BigDecimal smallTotal = mainTotal.multiply(ratio);   //计算维修价格(小计) 最高维修价格*比例

            total=total.add(smallTotal);             //计算总价格

            // 4.每一个故障选项计算后，添加一个估计详细数据(先存放到集合中)
            EvaluateDetail evaluateDetail=new EvaluateDetail();
            evaluateDetail.setCreatdTime(new Date());
            evaluateDetail.setCreatedUserId(users.getId());
            evaluateDetail.setMalfId(malfunction.getId());
            evaluateDetail.setOptionId(options.getId());
            evaluateDetail.setOptionName(options.getOptionName());
            eva.add(evaluateDetail);
        }
        // 5.添加一个估价信息（生成id后）
        Evaluate evaluate=new Evaluate();
        evaluate.setSubscription(total.multiply(new BigDecimal("0.1")));
        evaluate.setPrice(total);
        evaluate.setModelId(modelId);
        evaluate.setCreatedUserId(users.getId());
        evaluate.setCreatdTime(new Date());
        evaluateMapper.insertSelective(evaluate);

        //遍历明细表中的集合获取明细表的id,将id传入到评估表中
        for (EvaluateDetail evaluateDetail : eva) {
            evaluateDetail.setEvaluateId(evaluate.getId());
        }
        //将明细表集合插入到明细表中
        detailMapper.addAll(eva);
        return evaluate;
    }
}
