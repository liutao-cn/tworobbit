package cn.t18.est.mapper;

import cn.t18.est.pojo.SysUsers;

/**
 * @Entity cn.t18.est.pojo.SysUsers
 */
public interface SysUsersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    SysUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

}
