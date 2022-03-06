package cn.t18.est.service;

import cn.t18.est.pojo.Evaluate;

/**
 * 评估信息详情业务接口
 */
public interface Evaluate_detailService {

    //评估信息详情方法
    Evaluate getAssessInfo(Long id)throws Exception;
}
