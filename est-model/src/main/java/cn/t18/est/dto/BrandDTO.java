package cn.t18.est.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 品牌DTO
 * @TableName brand
 */
@Data
public class BrandDTO implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 型号DTO集合
     */
    List<ModelDTO> modelList = new ArrayList<ModelDTO>();
}