package cn.t18.est.service;

import cn.t18.est.dto.ModelDTO;
import cn.t18.est.pojo.Model;
import cn.t18.est.utils.PageBean;
import io.swagger.models.auth.In;

/**
 * 型号业务类接口
 */
public interface ModelService {

    /**
     * 分页查询,获取
     * @param model
     * @param
     * @param pagSize
     * @return
     * @throws Exception
     */
    PageBean<ModelDTO> getPag(Model model,Integer pagNo,Integer pagSize)throws Exception;

    /**
     * 根据商品型号id获取详细信息
     * @param id
     * @return
     * @throws Exception
     */
    ModelDTO queryModelById(Long id)throws Exception;
}
