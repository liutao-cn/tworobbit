package cn.t18.est.mapper;

import cn.t18.est.pojo.MalfunctionOptions;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.MalfunctionOptions
 */
public interface MalfunctionOptionsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MalfunctionOptions record);

    int insertSelective(MalfunctionOptions record);

    MalfunctionOptions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MalfunctionOptions record);

    int updateByPrimaryKey(MalfunctionOptions record);

    /**
     * 根据评估维度id查询商品的规格属性
     * @param malfId
     * @return
     * @throws Exception
     */
    List<MalfunctionOptions> queryOptionBymalfId(Long malfId)throws Exception;

    /**
     * 根据选项id获取选项的对象，含维修单比例
     * @param ids
     * @return
     * @throws Exception
     */
    List<MalfunctionOptions> selectByids(Long[] ids)throws Exception;

}
