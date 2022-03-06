package cn.t18.est.mapper;

import cn.t18.est.pojo.Classify;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.Classify
 */
public interface ClassifyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);

    /**
     * 获取商品类别
     * @return
     * @throws Exception
     */
    List<Classify> getAllClassify()throws Exception;

}
