package cn.t18.est.service.impl;

import cn.t18.est.constants.SMSConstants;
import cn.t18.est.dto.UsersDTO;
import cn.t18.est.exception.BusinessException;
import cn.t18.est.mapper.UsersMapper;
import cn.t18.est.pojo.Users;
import cn.t18.est.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 实现用户业务接口
 */
@Service
public class UserServiceImpl implements UserService {

    //redis模板类
    @Autowired
    private StringRedisTemplate redisTemplate;
    //注入userMapper
    @Resource
    private UsersMapper usersMapper;

    //手机短信验证码登录
    @Override
    public String phoneSms_Login(String phone, String sms) throws Exception {
        String checkPhone= SMSConstants.CHECK_LOGIN +phone;

        String sms_Info = redisTemplate.opsForValue().get(checkPhone);  //获取redis中的验证码
        if (!sms.equals(sms_Info)){   //当redis中存储的验证码与用户所输入的验证码是否相同
            throw new BusinessException("1003","验证码错误！");   //不相同时生成一个业务异常
        }else if (sms_Info == null){
            throw new BusinessException("1003","验证码为空,请重新输入！");
        }
        //存在时，删除redis中的验证码
        redisTemplate.delete(checkPhone);

        //根据手机号查询一个用户的信息
        Users users = usersMapper.selectByPhone(phone);
        //判断该对象是否为空,为空时则添加一个对象到数据库中
        if (users==null){
            users=new Users();

            users.setAccount(phone);
            users.setUserName(phone);
            users.setIsAuthentication(0);
            users.setCreatdTime(new Date());
            users.setIsDelete(0);
            usersMapper.insert(users);   //将该对象插入数据表中
        }
        String token = login(users);
        return token;
    }


    /**
     * 取出用户信息生成一个新的用户响应给前端
     * @param token  前端传进的token
     * @return
     * @throws Exception
     */
    @Override
    public UsersDTO getUserInfo(String token) throws Exception {
        String userJson = redisTemplate.opsForValue().get(token);
        ObjectMapper mapper = new ObjectMapper();
        //将redis中的字符串转换成用户对象
        Users users = mapper.readValue(userJson, Users.class);
        //构建响应给前端的用户
        UsersDTO userDto = new UsersDTO();
        userDto.setToken(token);
        //复制属性
        BeanUtils.copyProperties(users,userDto);
        return userDto;
    }

    /**
     * 生成token的方法
     * @param users  用户对象
     * @return
     * @throws Exception
     */
    @Override
    public String login(Users users) throws Exception {
        String token = UUID.randomUUID().toString().replace("-", "");
        ObjectMapper objectMapper=new ObjectMapper();
        String usersJson = objectMapper.writeValueAsString(users);
        //将token作为键，users作为值存入redis中
        redisTemplate.opsForValue().set(token,usersJson,30, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 退出登录
     * @param token
     * @throws Exception
     */
    @Override
    public void loginOut(String token) throws Exception {
        redisTemplate.delete(token);
    }

    //根据openid查询是否存在用户
    @Override
    public Users queryUserByopenId(String openId) throws Exception {
        return usersMapper.queryUserByOpenid(openId);
    }

    //注册一个用户
    @Override
    public int register(Users users) throws Exception {
        return usersMapper.insertSelective(users);
    }


}
