package cn.t18.est.service.impl;

import cn.t18.est.constants.SMSConstants;
import cn.t18.est.constants.Sms_info;
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
//@Service
public class TestSmsServiceImpl implements SmsService {

    //注入redis模板
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 日志对象
     */
    Logger logger=LoggerFactory.getLogger(TestSmsServiceImpl.class);

    @Override
    public void getSms(String phone, Integer codeType) throws Exception {
        //判断编码是登录验证码还是预约维修验证码
        switch (codeType){
            case 0:
                phone= SMSConstants.CHECK_LOGIN +phone;
               break;
            case 3:
                phone= SMSConstants.APPOINTMENT+phone;
                break;
        }
        //判断redis中是否存在验证码
        String code = redisTemplate.opsForValue().get(phone);
        if (code!=null){    //表名redis中以存在验证码
            return;
        }
        System.out.println("手机号码"+phone+"状态码"+codeType);
        int randNum = RandNum.creatRandom(6);   //获得随机数验证码

        logger.info("验证码为"+randNum);
        redisTemplate.opsForValue().set(phone,randNum+"",60l, TimeUnit.SECONDS);

    }
}
