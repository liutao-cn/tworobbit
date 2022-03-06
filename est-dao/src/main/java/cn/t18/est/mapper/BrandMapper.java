package cn.t18.est.mapper;

import cn.t18.est.pojo.Brand;
import cn.t18.est.pojo.BrandClassifyRelation;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.Brand
 */
public interface BrandMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    /**
     * 获取每个类型的品牌
     * @param list
     * @return
     * @throws Exception
     */
    List<Brand> getBrandList(List<BrandClassifyRelation> list)throws Exception;

}
