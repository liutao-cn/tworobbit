package cn.t18.est.controller;

import cn.t18.est.constants.Result_CodeInfo;
import cn.t18.est.constants.SMSConstants;
import cn.t18.est.dto.Result;
import cn.t18.est.pojo.Appointment;
import cn.t18.est.pojo.MaintainOrder;
import cn.t18.est.pojo.Users;
import cn.t18.est.service.impl.AppointmentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 预约控制层接口
 */
@RestController
public class AppointmentController {

    @Resource
    private StringRedisTemplate stringRedisTemplate ;
    @Resource
    private AppointmentServiceImpl appointmentService;


    @PostMapping("/api/order/maintain/submit")
    public Result submit(@Valid Appointment appointment, BindingResult result, HttpServletRequest request) throws Exception {
        //从请求中获取token信息,并转换成用户对象
        if (result.hasErrors()){
            return Result.error(Result_CodeInfo.ERROR_CODE,result.getFieldError().getDefaultMessage());
        }

        // 验证手机验证码
        String appCode = stringRedisTemplate.opsForValue().get(SMSConstants.APPOINTMENT+appointment.getPhone());
        if (appCode == null || !appCode.equals(appointment.getSms())){
            return Result.error(Result_CodeInfo.ERROR_CODE,"验证有误！");
        }
        String userInfo = stringRedisTemplate.opsForValue().get(request.getHeader("token"));
        ObjectMapper om=new ObjectMapper();
        Users users = om.readValue(userInfo, Users.class);

        MaintainOrder submit = appointmentService.submit(appointment, users);
        //System.out.println("返回前端的订单编码"+submit.getOrderNo());
        return Result.success(Result_CodeInfo.ERROR_CODE,Result_CodeInfo.SUCCESS_MSG,submit);
    }

}
