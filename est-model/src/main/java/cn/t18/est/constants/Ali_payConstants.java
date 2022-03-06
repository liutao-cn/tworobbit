package cn.t18.est.constants;

/**
 * 订单支付类
 */
public class Ali_payConstants {
    /**
     * 支付类型为定金
     */
    public static final Integer TYPE_DEPOSIT=1;
    /**
     * 支付类型为尾款
     */
    public static final Integer TYPE_TAIL=2;



    /**
     * 支付状态未支付
     */
    public static final Integer NO_PAYMENT=1;
    /**
     * 支付状态支付成功
     */
    public static final Integer PAYMENT_SUCCESSFUL=2;
    /**
     * 支付状态支付失败
     */
    public static final Integer PAYMENT_FAIL=3;


    /**
     * 支付途径现金
     */
    public static final Integer READY_MONEY=1;
    /**
     * 支付途径刷卡
     */
    public static final Integer SWIPE=2;
    /**
     * 支付途径刷卡
     */
    public static final Integer ALI_PAYMENT=3;
    /**
     * 支付途径微信
     */
    public static final Integer WE_CHAT=4;



    /**
     * 预约下单
     */
    public static final Integer MAKE_AN_APPOINTMENT=1;
    /**
     * 支付定金
     */
    public static final Integer PAY_DEPOSIT=2;
    /**
     * 用户取消
     */
    public static final Integer user_cancels=9;
    /**
     * 完成
     */
    public static final Integer Finish=10;
}
