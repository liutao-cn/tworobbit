package cn.t18.est.mapper;

import cn.t18.est.pojo.PayOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity cn.t18.est.pojo.PayOrder
 */
public interface PayOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    PayOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKey(PayOrder record);

    /**
     * 根据订单编号和类型查询该条订单
     * @param orderNo  订单编号
     * @param payType   订单类型
     * @return
     * @throws Exception
     */
    PayOrder selectOrderNoByPayTypePayOrder(@Param("orderNo") String orderNo, @Param("payType") Integer payType)throws Exception;

    /**
     * 根据支付订单号查询
     * @param payNo  支付订单号
     * @return
     * @throws Exception
     */
    PayOrder selectOrderNoByPayOrder(String payNo)throws Exception;

}
