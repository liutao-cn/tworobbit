package cn.t18.est.controller;

import cn.hutool.http.server.HttpServerResponse;
import cn.t18.est.service.impl.PayOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *订单支付控制层
 */
@RestController
public class Pay_OrderController {

    @Autowired
    private PayOrderServiceImpl payOrderService;

    /**
     * 支付宝支付的方法
     * @param orderNo
     * @param response
     * @throws Exception
     */
    @GetMapping("/api/pay/aliPay")
    public void aliPay(String orderNo, HttpServletResponse response) throws Exception {
        String str_html = payOrderService.selectByOrderNo(orderNo);
       /* System.out.println("订单编码为"+orderNo);
        System.out.println("响应的页面"+str_html);*/
        response.setContentType("text/html;charset=utf-8");  //设置响应出去的编码
        response.getWriter().write(str_html);   //页面重定向
    }

    /**
     * 支付宝异步回调
     * @param map
     * @param response
     * @throws Exception
     */
    @PostMapping("/api/pay/aliPay/notify")
    public void notify(@RequestParam Map<String,String> map, HttpServletResponse response) throws Exception {
        System.out.println("支付宝异步回调请求过来的参数"+map);
         String result = payOrderService.getNotify(map);
         //将参数响应出去
        response.getWriter().write(result);
    }

    /**
     * 支付宝同步回调
     * @param map
     * @param response
     * @throws IOException
     */
    @GetMapping("/api/pay/aliPay/return")
    public void return_Pag(@RequestParam Map<String,String> map,HttpServletResponse response) throws IOException {
        System.out.println("支付宝同步请求过来的参数"+map);
        response.sendRedirect("http://localhost:8090/confirmation");
    }


}
