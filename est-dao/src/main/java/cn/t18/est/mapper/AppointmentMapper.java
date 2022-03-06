package cn.t18.est.mapper;

import cn.t18.est.pojo.Appointment;

/**
 * @Entity cn.t18.est.pojo.Appointment
 */
public interface AppointmentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);

}
