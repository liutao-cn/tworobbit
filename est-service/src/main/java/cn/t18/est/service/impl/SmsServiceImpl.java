package cn.t18.est.service.impl;

import cn.t18.est.constants.SMSConstants;
import cn.t18.est.constants.Sms_info;
import cn.t18.est.constants.Sms_info_yml;
import cn.t18.est.mapper.SmsLogMapper;
import cn.t18.est.pojo.SmsLog;
import cn.t18.est.service.SmsService;
import cn.t18.est.utils.RandNum;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;

import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *短信业务接口实现注册
 */
@Service
public class SmsServiceImpl implements SmsService {

    //注入redis模板
    @Autowired
    private StringRedisTemplate redisTemplate;

    //短信日志接口
    @Resource
    private SmsLogMapper smsLogMapper;

    //引入短信配置类
    @Resource
    private Sms_info_yml sms_info_yml;

    /**
     * 日志对象
     */
    Logger logger=LoggerFactory.getLogger(SmsServiceImpl.class);

    @Override
    public void getSms(String phone, Integer codeType) throws Exception {
        String loginPhone=null;
        switch (codeType){
            case 0:
                loginPhone= SMSConstants.CHECK_LOGIN +phone;
                break;
            case 3:
                loginPhone= SMSConstants.APPOINTMENT+phone;
                break;
        }
        //判断redis中是否存在验证码
        String code = redisTemplate.opsForValue().get(loginPhone);
        if (code!=null){    //表名redis中以存在验证码
            return;
        }
        //System.out.println("手机号码"+phone+"状态码"+codeType);
        int randNum = RandNum.creatRandom(6);   //获得随机数验证码

        //配置短信的公共配置
        Config config = new Config();
        config.setAccessKeyId(sms_info_yml.getAccesskey_id());               //配置发送短信的账户
        config.setAccessKeySecret(sms_info_yml.getAccesskey_secret());     //配置发送短信账户的秘钥
        config.endpoint=sms_info_yml.getEndpoint();                          //配置域名


        //发送信息的对象
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setSignName(sms_info_yml.getSign_name());            //设置短信签名
        sendSmsRequest.setTemplateCode(sms_info_yml.getTemplate_code());   //设置短信模板
        sendSmsRequest.setPhoneNumbers(phone);                              //设置手机号码
        sendSmsRequest.setTemplateParam("{'code':"+randNum+"}");         //设置验证码，注意该格式为键值对


        Client client = new Client(config);    //客户端对象
        //通过客户端将信息对象发送获得一个响应对象
        SendSmsResponse response = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = response.getBody();   //获得响应回来的主体信息
        logger.info("状态码: {}",body.getCode());
        logger.info("信息: {}",body.getMessage());

        //当响应状态码为OK时，将手机号码作为键，验证码作为值存到redis中。
        if ("OK".equals(body.getCode())){
            //短信发送成功后向短信日志中插入一条数据
            SmsLog sms = new SmsLog();
            sms.setCodeType(0);
            sms.setCreatdTime(new Date());
            sms.setMessage(randNum+"");
            sms.setPhone(phone);
            sms.setStatus(1);
            sms.setIsDelete(0);
            sms.setFailInfo("未失败！");
            smsLogMapper.insert(sms);

            redisTemplate.opsForValue().set(loginPhone,randNum+"",300l, TimeUnit.SECONDS);
        }

    }
}
