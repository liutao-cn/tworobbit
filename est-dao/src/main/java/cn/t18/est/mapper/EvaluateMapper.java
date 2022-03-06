package cn.t18.est.mapper;

import cn.t18.est.pojo.Evaluate;
import cn.t18.est.pojo.Model;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.Evaluate
 */
public interface EvaluateMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    //根据id查询出评估信息
    Evaluate selectById(Long id)throws Exception;



}
