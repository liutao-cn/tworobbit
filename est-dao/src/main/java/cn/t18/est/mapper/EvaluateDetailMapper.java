package cn.t18.est.mapper;

import cn.t18.est.pojo.Evaluate;
import cn.t18.est.pojo.EvaluateDetail;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.EvaluateDetail
 */
public interface EvaluateDetailMapper {

    int deleteByPrimaryKey(Long id);

    int insert(EvaluateDetail record);

    int insertSelective(EvaluateDetail record);

    EvaluateDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EvaluateDetail record);

    int updateByPrimaryKey(EvaluateDetail record);

    /**
     * 添加多条明细记录
     * @param es
     * @return
     * @throws Exception
     */
    int addAll(List<EvaluateDetail> es)throws Exception;

    //根据评估id查询出详细信息
    List<EvaluateDetail> selectByIdEvaluateDetails(Long id)throws Exception;


}
