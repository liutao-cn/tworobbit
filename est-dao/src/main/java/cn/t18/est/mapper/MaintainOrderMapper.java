package cn.t18.est.mapper;

import cn.t18.est.pojo.MaintainOrder;

/**
 * @Entity cn.t18.est.pojo.MaintainOrder
 */
public interface MaintainOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MaintainOrder record);

    int insertSelective(MaintainOrder record);

    MaintainOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaintainOrder record);

    int updateByPrimaryKey(MaintainOrder record);

    /**
     * 根据订单编号查询维修订单
     * @param orderNo
     * @return
     * @throws Exception
     */
    MaintainOrder selectByOrderNo(String orderNo)throws Exception;

}
