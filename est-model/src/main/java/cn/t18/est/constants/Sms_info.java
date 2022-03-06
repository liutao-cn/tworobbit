package cn.t18.est.constants;

import org.springframework.stereotype.Component;

/**
 * 短信业务常量类
 */
@Component
public class Sms_info {
    //发送短信的账号
    public static final String ACCESSKEY_ID = "LTAI5tGdFZ4GKFfrTdzqXik3";
    //发送短信的秘钥
    public static final String ACCESSKEY_SECRET = "iKBr9ovhnCgXkNeg01mOdsoxWTMvx5";
    //短信签名
    public static final String SIGN_NAME = "金码二手兔";
    //短信模块
    public static final String TEMPLATE_CODE = "SMS_192541436";
    //访问的域名
    public static final String ENDPOINT = "dysmsapi.aliyuncs.com";

}
