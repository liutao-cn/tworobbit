package cn.t18.est.service;

import cn.t18.est.dto.Result;
import cn.t18.est.dto.UsersDTO;
import cn.t18.est.pojo.Users;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 短信验证码登录
     * @param phone
     * @param sms
     * @return
     * @throws Exception
     */
    String phoneSms_Login(String phone,String sms)throws Exception;

    /**
     * 获取用户信息
     * @param token  前端传进的token
     * @return
     * @throws Exception
     */
    UsersDTO getUserInfo(String token)throws Exception;

    /**
     * 生成token的方法
     * @param users  用户对象
     * @return
     * @throws Exception
     */
    String login(Users users)throws Exception;


    /**
     * 退出登录的方法
     * @param token
     * @throws Exception
     */
    void loginOut(String token)throws Exception;

    //根据openid查询用户
    Users queryUserByopenId(String openId)throws Exception;

    /**
     * 注册一个用户
     * @param users
     * @return
     * @throws Exception
     */
    int register(Users users)throws Exception;
}
