package cn.t18.est.mapper;

import cn.t18.est.dto.ModelDTO;
import cn.t18.est.pojo.Model;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity cn.t18.est.pojo.Model
 */
public interface ModelMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Model record);

    int insertSelective(Model record);

    /**
     * 根据id查询商品型号信息
     * @param id
     * @return
     */
    Model selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);

    /**
     * 获取每个类型的品牌的型号
     * @param classifyId
     * @param
     * @return
     * @throws Exception
     */
    List<Model> getModel(@Param("classifyId") Long classifyId,
                         @Param("brandId") Long brandId)throws Exception;

    /**
     * 分页查询商品型号
     * @param model
     * @param index
     * @param pagSize
     * @return
     */
    List<ModelDTO> getModelPag(@Param("model") Model model,
                               @Param("index") Integer index,
                               @Param("pagSize") Integer pagSize
                               );

    /**
     * 获取总条数
     * @return
     * @throws Exception
     */
    int getCount(Model model)throws Exception;

    //根据modelid 查询出型号信息
    Model selectModelById(Long modelId)throws Exception;
}
