package cn.t18.est.service.impl;

import cn.t18.est.config.AlipayConfig;
import cn.t18.est.constants.Ali_payConstants;
import cn.t18.est.constants.Result_CodeInfo;
import cn.t18.est.exception.BusinessException;
import cn.t18.est.mapper.*;
import cn.t18.est.pojo.*;
import cn.t18.est.service.PayOrderService;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * 订单查询业务接口实现类
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {
    @Resource
    private PayOrderMapper payOrderMapper;
    @Resource
    private MaintainOrderMapper maintainOrderMapper;
    @Resource
    private ModelMapper modelMapper;
    @Resource
    private AlipayConfig alipayConfig;
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private MaintainOrderFlowMapper maintainOrderFlowMapper;

    @Override
    public String selectByOrderNo(String orderNO) throws Exception {
        //根据订单编号和订单类型查询该条订单，如果存在该条订单则不插入，不存在则插入该条订单
        PayOrder payOrder = payOrderMapper.selectOrderNoByPayTypePayOrder(orderNO, Ali_payConstants.TYPE_DEPOSIT);


        if (payOrder != null && payOrder.getStatus()==Ali_payConstants.PAYMENT_SUCCESSFUL) {
            throw new BusinessException(Result_CodeInfo.ERROR_CODE,"已支付，不需要重复支付");
        }
        //根据订单编号查询维修订单，获取订单的定金和用户id
        MaintainOrder maintainOrder = maintainOrderMapper.selectByOrderNo(orderNO);
        //根据订单的modelID查询机型
        Model model = modelMapper.selectModelById(maintainOrder.getModelId());
         //当该条订单为空时，插入一条新的订单
        if(payOrder == null){
            payOrder=new PayOrder();
            payOrder.setOrderNo(maintainOrder.getOrderNo());
            payOrder.setPayNo(maintainOrder.getOrderNo()+new Date().getTime());
            payOrder.setUserId(maintainOrder.getUserId());
            payOrder.setPrice(maintainOrder.getSubscription());
            payOrder.setPayType(Ali_payConstants.TYPE_DEPOSIT);
            payOrder.setStatus(Ali_payConstants.NO_PAYMENT);
            payOrder.setPayChannel(Ali_payConstants.ALI_PAYMENT);
            payOrder.setCreatedUserId(maintainOrder.getUserId());
            payOrder.setCreatdTime(new Date());
            payOrder.setIsDelete(0);
            payOrderMapper.insertSelective(payOrder);
        }




        //获得初始化的AlipayClient客户端
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayConfig.getGatewayUrl(),
                alipayConfig.getApp_id(),
                alipayConfig.getMerchant_private_key(),
                "json",
                alipayConfig.getCharset(),
                alipayConfig.getAlipay_public_key(),
                alipayConfig.getSign_type());

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //同步到客户端的url
        alipayRequest.setReturnUrl(alipayConfig.getReturn_url());
        //异步到应用程序的url
        alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no =payOrder.getPayNo();
        //付款金额，必填
        String total_amount =payOrder.getPrice().toString();
        //订单名称，必填
        String subject = model.getModelName()+"维修定金";
        //商品描述，可空
        String body ="";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String getNotify(Map<String,String> params) throws Exception {
        //验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params,
                alipayConfig.getAlipay_public_key(),
                alipayConfig.getCharset(),
                alipayConfig.getSign_type()); //调用SDK验证签名
        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no =params.get("out_trade_no");
            //支付宝交易号
            String trade_no = params.get("trade_no");
            //交易状态
            String trade_status = params.get("trade_status");

            if(trade_status.equals("TRADE_SUCCESS")){  //付款成功，执行业务操作
                PayOrder payOrder = payOrderMapper.selectOrderNoByPayOrder(out_trade_no);    //通过订单

                //当应用程序没响应时，判断状态为支付成功时，直接返回success
                if (payOrder.getStatus() == Ali_payConstants.PAYMENT_SUCCESSFUL) {
                    return "success";
                }
                payOrder.setAliTradeNo(trade_status);
                payOrder.setStatus(Ali_payConstants.PAYMENT_SUCCESSFUL);
                payOrder.setUpdatedTime(new Date());
                payOrderMapper.updateByPrimaryKeySelective(payOrder);   //修改订单支付表

                MaintainOrder maintainOrder = maintainOrderMapper.selectByOrderNo(payOrder.getOrderNo());  //根据订单编号查询维修订单
                maintainOrder.setStatus(Ali_payConstants.PAY_DEPOSIT);
                maintainOrder.setUpdatedTime(new Date());
                maintainOrderMapper.updateByPrimaryKeySelective(maintainOrder);  //修改维修订单

                //获取用户的id
                Users users = usersMapper.selectByPrimaryKey(maintainOrder.getUserId());
                MaintainOrderFlow orderFlow = new MaintainOrderFlow();
                orderFlow.setOrderNo(maintainOrder.getOrderNo());
                orderFlow.setOrderStatus(Ali_payConstants.PAY_DEPOSIT);
                orderFlow.setOrderStatusDesc("支付定金");
                orderFlow.setOperationUId(users.getId());
                orderFlow.setOperationName(users.getUserName());
                orderFlow.setCreatedUserId(users.getId());
                orderFlow.setCreatdTime(new Date());
                orderFlow.setIsDelete(0);

                //插入流水单
                maintainOrderFlowMapper.insertSelective(orderFlow);

                return "success";
            }else if (trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                return "success";
            }
        }
        return "fail";
    }
}
