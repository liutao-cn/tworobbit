package cn.t18.est.mapper;

import cn.t18.est.pojo.Menus;

/**
 * @Entity cn.t18.est.pojo.Menus
 */
public interface MenusMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Menus record);

    int insertSelective(Menus record);

    Menus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menus record);

    int updateByPrimaryKey(Menus record);

}
