package cn.t18.est.dto;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

import java.util.List;

/**
 * 短信服务类
 */
public class SmsInfoServer {


    //短信发送的服务方法
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        //配置
        Config config = new Config()
                // 您的AccessKey ID 账号
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret  秘钥
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }

    public static void main(String[] args_) throws Exception {
        List<String> args = java.util.Arrays.asList(args_);
        Client client =createClient("LTAI5tGdFZ4GKFfrTdzqXik3", "iKBr9ovhnCgXkNeg01mOdsoxWTMvx5");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("金码二手兔") // 短信签名
                .setTemplateCode("SMS_192541436") // 短信模块
                .setPhoneNumbers("15526387253") // 要发送的手机号
                .setTemplateParam("{\"code\":\"666666\"}"); // 验证码
        // 复制代码运行请自行打印 API 的返回值
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = sendSmsResponse.getBody(); // 主体内容
        System.out.println("返回信息的编码：" + body.getCode());
        System.out.println("短信发送结果信息：" + body.getMessage());
        // 复制代码运行请自行打印 API 的返回值
    }

}
