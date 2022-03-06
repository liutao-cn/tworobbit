package cn.t18.est.mapper;

import cn.t18.est.pojo.MaintainOrderFlow;

/**
 * @Entity cn.t18.est.pojo.MaintainOrderFlow
 */
public interface MaintainOrderFlowMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MaintainOrderFlow record);

    int insertSelective(MaintainOrderFlow record);

    MaintainOrderFlow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaintainOrderFlow record);

    int updateByPrimaryKey(MaintainOrderFlow record);

}
