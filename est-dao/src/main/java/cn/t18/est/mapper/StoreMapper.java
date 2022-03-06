package cn.t18.est.mapper;

import cn.t18.est.pojo.Store;

/**
 * @Entity cn.t18.est.pojo.Store
 */
public interface StoreMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

}
