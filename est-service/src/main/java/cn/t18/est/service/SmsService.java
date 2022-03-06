package cn.t18.est.service;

/**
 * 短信服务接口
 */
public interface SmsService {

    /**
     * 发送短信的方法
     * @param phone  接收到手机号
     * @param codeType
     * @throws Exception
     */
    void getSms(String phone,Integer codeType)throws Exception;
}
