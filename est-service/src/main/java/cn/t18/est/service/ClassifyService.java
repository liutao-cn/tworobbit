package cn.t18.est.service;

import cn.t18.est.dto.ClassifyDTO;

import java.util.List;

/**
 * 商品业务接口
 */
public interface ClassifyService {


    //获取商品列表方法
    List<ClassifyDTO> selectClassifyList()throws Exception;
}
