package cn.t18.est.mapper;

import cn.t18.est.pojo.SmsLog;

/**
 * @Entity cn.t18.est.pojo.SmsLog
 */
public interface SmsLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SmsLog record);

    int insertSelective(SmsLog record);

    SmsLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsLog record);

    int updateByPrimaryKey(SmsLog record);

}
