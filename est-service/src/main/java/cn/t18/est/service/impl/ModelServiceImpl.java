package cn.t18.est.service.impl;

import cn.t18.est.constants.Result_CodeInfo;
import cn.t18.est.dto.ModelDTO;
import cn.t18.est.exception.BusinessException;
import cn.t18.est.mapper.ModelMapper;
import cn.t18.est.pojo.Model;
import cn.t18.est.service.ModelService;
import cn.t18.est.utils.PageBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 型号业务接口实现类
 */
@Service
public class ModelServiceImpl implements ModelService {

    @Resource
    private ModelMapper modelMapper;

    @Value("${oss.ossWebUrl}")
    private String imgUrl;

    //商品型号分页查询
    @Override
    public PageBean<ModelDTO> getPag(Model model, Integer pageNo, Integer pagSize) throws Exception {
        PageBean<ModelDTO> pagBean = new PageBean<>();
        //获取商品总条数
        int count = modelMapper.getCount(model);
        if (pageNo!=null){
            //赋值当前页
            pagBean.setPagNo(pageNo);
        }else {
            pagBean.setPagNo(1);
        }

        //System.out.println("总条数"+count);
        if (pagSize!=null){
            pagBean.setPagSize(pagSize);
        }else {
            pagBean.setPagSize(20);
        }
        //赋值分页类中的总条数
        pagBean.setTotalCount(count);

        //赋值页面显示数据量
        //计算起始下标
        Integer index=(pagBean.getPagNo()-1)*pagBean.getPagSize();
        //获取查询数据
        List<ModelDTO> modelPag = modelMapper.getModelPag(model, index, pagBean.getPagSize());
        for (ModelDTO modelDTO : modelPag) {
            modelDTO.setFaceImg(imgUrl+modelDTO.getFaceImg());
        }
        //赋值pagBean中的数据量
        pagBean.setList(modelPag);
        if (pagBean!=null){
            return pagBean;
        }
        throw new BusinessException(Result_CodeInfo.SUCCESS_CODE,Result_CodeInfo.ERROR_MSG);

    }

    /**
     * 根据id获取商品详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ModelDTO queryModelById(Long id) throws Exception {
        Model model = modelMapper.selectByPrimaryKey(id);
        if (model!=null){
            ModelDTO modelDTO = new ModelDTO();
            BeanUtils.copyProperties(model,modelDTO);
            modelDTO.setFaceImg(imgUrl+modelDTO.getFaceImg());
            return modelDTO;
        }
        throw new BusinessException(Result_CodeInfo.SUCCESS_CODE,Result_CodeInfo.ERROR_MSG);
    }
}
