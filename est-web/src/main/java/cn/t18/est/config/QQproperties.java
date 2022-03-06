package cn.t18.est.config;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * qq登录配置类
 */
@Component
@ConfigurationProperties(prefix ="qq")
@Data
public class QQproperties {

    private String login_url;  //登录的url
    private String client_id;   //网站引用id
    private String redirect_uri;  //重定向的网址
    private String get_accesstoken; //获取accesstoken的地址栏
    private String client_secret;    //应用程序的密码
    private String openid_url;   //获取openId的地址栏
    private String user_infoUrl;    //获取用户信息的url
    private String success_url;   //登录成功，重定向的url


}
