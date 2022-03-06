package cn.t18.est.mapper;

import cn.t18.est.pojo.BrandClassifyRelation;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.BrandClassifyRelation
 */
public interface BrandClassifyRelationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BrandClassifyRelation record);

    int insertSelective(BrandClassifyRelation record);

    BrandClassifyRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BrandClassifyRelation record);

    int updateByPrimaryKey(BrandClassifyRelation record);

    /**
     * 获取商品与品牌列表的关联
     */
    List<BrandClassifyRelation> getBrandIds(Long id)throws Exception;
}
