package cn.t18.est.service.impl;

import cn.t18.est.constants.Appointment_tool;
import cn.t18.est.mapper.AppointmentMapper;
import cn.t18.est.mapper.EvaluateMapper;
import cn.t18.est.mapper.MaintainOrderFlowMapper;
import cn.t18.est.mapper.MaintainOrderMapper;
import cn.t18.est.pojo.*;
import cn.t18.est.service.AppointmentService;
import cn.t18.est.utils.RandNum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 预约订单服务接口实现类
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private EvaluateMapper evaluateMapper;
    @Resource
    private MaintainOrderMapper maintainOrderMapper;
    @Resource
    private MaintainOrderFlowMapper maintainOrderFlowMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public MaintainOrder submit(Appointment appointment, Users users) throws Exception {
        //System.out.println("前端传进来的预约对象的信息"+appointment);
        //插入预约表
        appointment.setUserId(users.getId());
        appointment.setTemporalInterval(Appointment_tool.MORNING);
        appointment.setStatus(Appointment_tool.USER_APP);
        appointment.setCreatdTime(new Date());
        int i = appointmentMapper.insertSelective(appointment);
        System.out.println("预约表受影响的行数"+i);

        //插入维修订单表
        MaintainOrder order = new MaintainOrder();
        //根据id查出评估表获取modelId
        Evaluate evaluate = evaluateMapper.selectByPrimaryKey(appointment.getEvaluateId());

        order.setUserId(users.getId());
        order.setModelId(evaluate.getModelId());
        order.setEvaluateId(evaluate.getId());
        order.setSubscription(evaluate.getSubscription());
        order.setStatus(Appointment_tool.ONE);
        order.setIsComment(1);
        order.setCreatedUserId(users.getId());
        order.setIsDelete(0);
        order.setCreatdTime(new Date());
        maintainOrderMapper.insertSelective(order);

        //根据id修改维修订单的订单编号
        MaintainOrder main=new MaintainOrder();
        String orderNum = getOrderNum(order.getId());
        main.setOrderNo(orderNum);
        main.setId(order.getId());
        maintainOrderMapper.updateByPrimaryKeySelective(main);



        //插入维修订单流水表
        MaintainOrderFlow flow = new MaintainOrderFlow();
        flow.setOrderNo(main.getOrderNo());
        flow.setOrderStatus(Appointment_tool.ONE);
        flow.setOrderStatusDesc("预约下单");
        flow.setOperationUId(users.getId());
        flow.setOperationName(users.getUserName());
        flow.setCreatedUserId(users.getId());
        flow.setCreatdTime(new Date());
        maintainOrderFlowMapper.insertSelective(flow);

        //将维修订单表中的订单编码返回
        MaintainOrder order1 = new MaintainOrder();
        order1.setOrderNo(flow.getOrderNo());

        return order1;
    }


    /**
     * 获取订单编号  格式 年月日时分秒 4位的随机数 id
     * @param id
     * @return
     */
    String getOrderNum(Long id){
        //获取日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);

        //将id转换成字符串
        String idLength = id.toString();

        //获取4位的随机数
        int randNum = RandNum.creatRandom(4);

        //拼接字符串
        StringBuilder builder = new StringBuilder(format + randNum);

        //循环生成位数
        for (int i =idLength.length() ; i < 10; i++) {
              builder.append(0);   //将0追加到字符串后
        }
        //将id追加到后面
        builder.append(id);
        return builder.toString();
    }
}
