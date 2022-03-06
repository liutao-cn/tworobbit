package cn.t18.est.service;

import cn.t18.est.pojo.Evaluate;
import cn.t18.est.pojo.Malfunction;
import cn.t18.est.pojo.Users;

import java.util.List;

/**
 * 评估业务接口
 */
public interface EvaluateService {

    /**
     * 根据商品分类查询出商品维度信息
     * @param modelId
     * @return
     * @throws Exception
     */
    List<Malfunction> getSpecList(Long modelId)throws Exception;

    /**
     * 查询评估信息
     * @param modelId
     * @param ids
     * @param users
     * @return
     * @throws Exception
     */
    Evaluate getAssess(Long modelId, Long[] ids, Users users)throws Exception;
}
