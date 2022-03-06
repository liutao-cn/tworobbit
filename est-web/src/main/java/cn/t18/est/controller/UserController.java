package cn.t18.est.controller;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.t18.est.config.QQproperties;
import cn.t18.est.dto.Result;
import cn.t18.est.dto.UsersDTO;
import cn.t18.est.pojo.Users;
import cn.t18.est.service.SmsService;
import cn.t18.est.service.UserService;
import cn.t18.est.service.impl.SmsServiceImpl;
import cn.t18.est.service.impl.TestSmsServiceImpl;
import cn.t18.est.utils.RandNum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 *用户控制层
 */
@Api(tags = {"这是一个发送短接口API"})
@RestController
public class UserController {

    @Autowired
    private SmsService smsService;
    @Autowired
    private UserService userService;

    @Autowired
    private QQproperties qQproperties;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 发送短信的方法
     * @param phone
     * @param
     * @return
     * @throws Exception
     */
    @ApiOperation("发送短信测试方法")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phone",value = "电话"),
                    @ApiImplicitParam(name = "codeType",value = "验证码类型<br />0：注册、登录验证码<br />1：修改密码<br />2：订单状态通知信息")}
    )
    @PostMapping("/api/sms/verifyCode")
    public Result getSmsInfo(String phone,Integer codeType) throws Exception {
        System.out.println("类型为"+codeType);
        smsService.getSms(phone,codeType);
       return Result.success("0","成功");
    }



    /**
     * 手机号与验证码登录
     * @param phone
     * @param sms
     * @return
     * @throws Exception
     */
    @ApiOperation("手机号与验证码的登录")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "phone",value = "电话"),
                    @ApiImplicitParam(name = "sms",value = "验证码")}
    )
    @PostMapping("/api/user/login/sms")
    public Result phone_SmsLogin(String phone,String sms) throws Exception {
        String token = userService.phoneSms_Login(phone, sms);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("token",token);
        return Result.success("0","成功",map);
    }



    /**
     * 获取用户信息
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation("获取用户信息的方法")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "request",value = "请求头"),
                   }
    )
    @GetMapping("/api/user/info")
    public Result userInfo(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        UsersDTO userInfo = userService.getUserInfo(token);
        userInfo.setToken(token);
        return Result.success("0","成功",userInfo);
    }


    /**
     * 退出登录方法
     * @param request
     * @return
     * @throws Exception
     */
    @ApiOperation("退出登录的方法")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "request",value = "请求头"),
            }
    )
    @PostMapping("/api/user/logout")
    public Result loginOut(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        userService.loginOut(token);
        return Result.success("0","成功");
    }

    /**
     * 登录授权的方法
     * @param response
     */
    @ApiOperation("qq登录的方法")
    @RequestMapping("/api/user/login/wechat")
    public void qq_login(HttpServletResponse response,HttpServletRequest request) throws IOException {
         request.setCharacterEncoding("utf-8");
        //为防止别人更改浏览器中的url地址栏中的code进行请求,需在地址栏中加入一个状态验证码(随机数+当前的毫秒数)
        int random = RandNum.creatRandom(6);//得到随机数
        long second = new Date().getTime();//得到当前的毫秒数
       long state= random+second;   //生成一个状态码
        String url_location = StrUtil.format(qQproperties.getLogin_url(),qQproperties.getClient_id(),qQproperties.getRedirect_uri(),state);

        //将状态码存入redis中设置时间10分钟
        redisTemplate.opsForValue().set(state,"记录状态码",10, TimeUnit.MINUTES);

        //重定向url地址栏
        response.sendRedirect(url_location);
    }

    /**
     * 登录的方法
     * @param code
     */
    @GetMapping("/api/login")
    public void goLogin(HttpServletRequest request,String code,Long state,HttpServletResponse response) throws Exception {
        response.setContentType("html/text;charset=utf-8");
        String stat =(String) redisTemplate.opsForValue().get(state);
        //判断state是否为空
        if (stat!=null){
            //不为空时将state删除
            redisTemplate.delete(stat);
            //获取请求的网址
            String access_tokenUrl = StrUtil.format(qQproperties.getGet_accesstoken()
                    , qQproperties.getClient_id()
                    , qQproperties.getClient_secret()
                    , code
                    , qQproperties.getRedirect_uri());
            //使用工具类发送请求获得一个用户的真实token和token的失效时间
            String access_tokenParams = HttpUtil.get(access_tokenUrl);
            //System.out.println("用户真实token信息和失效时间"+access_tokenParams);

            //解析url字符串并截取
            UrlBuilder urlBuilder = UrlBuilder.ofHttp("?"+access_tokenParams);
            //取出用户真实token保存到字符串中
            String access_token =urlBuilder.getQuery().get("access_token").toString();
            //System.out.println("用户的真实token"+access_token);

            //拼接获取用户openId的请求url
            String openIdUrl = StrUtil.format(qQproperties.getOpenid_url(),access_token);
            String openid = HttpUtil.get(openIdUrl);

            //将openId截取出来
            String open_Ids = openid.substring(openid.indexOf("{"), openid.indexOf("}") + 1);
            //System.out.println("用户openId为"+open_Ids);
            //将字符串转换成Map集合
            ObjectMapper om = new ObjectMapper();
            Map map = om.readValue(open_Ids, Map.class);
            //将openId取出
            String open_Id = map.get("openid").toString();


            //拼接获取用户信息的url
            String getUserInfoUrl = StrUtil.format(qQproperties.getUser_infoUrl(), access_token, qQproperties.getClient_id(), open_Id);
            //发送请求获取用户信息
            String userInfo = HttpUtil.get(getUserInfoUrl);
            //将字符串转换为map集合
            Map userInfoMap = om.readValue(userInfo, Map.class);
            //System.out.println("用户信息为"+userInfo);

            Users users = userService.queryUserByopenId(open_Id);
            System.out.println("========"+users);
            if (users == null){
                users = new Users();
                users.setSex(userInfoMap.get("gender").equals("男")?1:0);
                users.setUserName(userInfoMap.get("nickname").toString());
                users.setIsDelete(0);
                users.setCreatdTime(new Date());
                users.setOpenId(open_Id);
                users.setFaceUrl(userInfoMap.get("figureurl_qq_2").toString());
                users.setBindStatus(1);
                users.setIsAuthentication(0);
                //插入一个用户
                userService.register(users);
                System.out.println("johioh"+users);
            }
            //登录后返回的token
            String token = userService.login(users);
            //System.out.println("token的值"+token);


            //因前端接收的参数为一个token对象,将参数存入到map中
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("token",token);
            map1.put("userInfo",users.getUserName());


            //URLDecoder.decode() 将url的字符乱码转换成字符串
            //将字符串转换成url可解析的字符重定向
            String encode = URLEncoder.encode(om.writeValueAsString(map1), "utf-8");

            //登录成功重定向的地址
            String successUrl = StrUtil.format(qQproperties.getSuccess_url(),encode);
            //重定向界面
            response.sendRedirect(successUrl);
        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>alert('非法操作！')</script>");
        }
    }
}
