package cn.t18.est.mapper;

import cn.t18.est.pojo.Malfunction;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.Malfunction
 */
public interface MalfunctionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Malfunction record);

    int insertSelective(Malfunction record);

    Malfunction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Malfunction record);

    int updateByPrimaryKey(Malfunction record);

    /**`
     * 根据型号id查询出评估维度信息
     * @param modelId
     * @return
     * @throws Exception
     */
    List<Malfunction> queryMalfunctionByModelId(Long modelId)throws Exception;

}
