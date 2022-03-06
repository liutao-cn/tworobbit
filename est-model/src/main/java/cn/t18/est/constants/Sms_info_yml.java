package cn.t18.est.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 短信业务常量值，注入在yml中
 */
@Component
@Data
public class Sms_info_yml {
    //发送短信的账号
    @Value("${Sms_info_yml.accesskey_id}")
    private String accesskey_id;
    //发送短信的秘钥
    @Value("${Sms_info_yml.accesskey_secret}")
    private String accesskey_secret;
    //短信签名
    @Value("${Sms_info_yml.sign_name}")
    private String sign_name;
    //短信模块
    @Value("${Sms_info_yml.template_code}")
    private String template_code;
    //访问的域名
    @Value("${Sms_info_yml.endpoint}")
    private String endpoint;

}
