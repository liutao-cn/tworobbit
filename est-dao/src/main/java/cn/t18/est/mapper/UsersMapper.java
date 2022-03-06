package cn.t18.est.mapper;

import cn.t18.est.pojo.Users;

/**
 * @Entity cn.t18.est.pojo.Users
 */
public interface UsersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByPhone(String account)throws Exception;

    /**
     * 根据用户opneid查询用户
     * @param openId
     * @return
     * @throws Exception
     */
    Users queryUserByOpenid(String openId)throws Exception;

}
