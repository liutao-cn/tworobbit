package cn.t18.est.constants;

/**
 * 维修订单常量类
 */
public class Appointment_tool {

    //预约时间
    public static final Integer MORNING=1;  //上午
    public static final Integer AT_NOON=2;   //中午
    public static final Integer AFTERNOON=3;  //下午
    public static final Integer EVENING=4;   //晚上

    //预约状态
    public static final Integer USER_APP=1;  //用户预约
    public static final Integer OK=2;   //完成



    //订单状态（1:预约下单,2:支付定金,3:后台确认,4:实物质检,5:用户确认检查结果,6:维修完成,7:用户确认维修结果,8:支付尾款,9:用户取消,10结束）
    public static final Integer ONE=1;
    public static final Integer TWO=2;
    public static final Integer THREE=3;
    public static final Integer FOUR=4;
    public static final Integer FIVE=5;
    public static final Integer SIX=6;
    public static final Integer SEVEN=7;
    public static final Integer EIG=8;
    public static final Integer NINE=9;
    public static final Integer TEN=10;
}
