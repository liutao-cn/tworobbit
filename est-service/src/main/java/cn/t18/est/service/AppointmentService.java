package cn.t18.est.service;

import cn.t18.est.pojo.Appointment;
import cn.t18.est.pojo.MaintainOrder;
import cn.t18.est.pojo.Users;

/**
 * 预约订单服务接口
 */
public interface AppointmentService {

    /**
     * 提交订单的方法
      * @param appointment
     * @param users
     * @return
     * @throws Exception
     */
    MaintainOrder submit(Appointment appointment, Users users)throws Exception;
}
