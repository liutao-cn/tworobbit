package cn.t18.est.service.impl;

import cn.t18.est.mapper.EvaluateDetailMapper;
import cn.t18.est.mapper.EvaluateMapper;
import cn.t18.est.mapper.ModelMapper;
import cn.t18.est.pojo.Evaluate;
import cn.t18.est.pojo.EvaluateDetail;
import cn.t18.est.pojo.Model;
import cn.t18.est.service.EvaluateService;
import cn.t18.est.service.Evaluate_detailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 详细业务接口实现类
 */
@Service
public class Evaluate_detailServiceImpl implements Evaluate_detailService {

    @Resource
    private EvaluateMapper evaluateMapper;
    @Resource
    private EvaluateDetailMapper evaluateDetailMapper;
    @Resource
    private ModelMapper modelMapper;
    @Value("${oss.ossWebUrl}")
    private String imgUrl;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Evaluate getAssessInfo(Long id) throws Exception {
        Evaluate evaluate = evaluateMapper.selectById(id);
        Long modelId = evaluate.getModelId();
        Model model = modelMapper.selectModelById(modelId);
        model.setContentImg(imgUrl+model.getContentImg());
        model.setFaceImg(imgUrl+model.getFaceImg());
        evaluate.setModel(model);
        List<EvaluateDetail> evaluateDetails = evaluateDetailMapper.selectByIdEvaluateDetails(evaluate.getId());
        evaluate.setDetailList(evaluateDetails);
        return evaluate;
    }
}
