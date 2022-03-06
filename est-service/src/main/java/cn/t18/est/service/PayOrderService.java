package cn.t18.est.service;

import java.util.Map;

/**
 * 订单支付业务接口
 */
public interface PayOrderService {

    /**
     * 根据订单编号查询是否存在该条订单
     * @param orderNO 订单编号
     * @return
     * @throws Exception
     */
    String selectByOrderNo(String orderNO)throws Exception;

    String getNotify(Map<String,String> params)throws Exception;
}
