package cn.t18.est.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品型号
 * @TableName model
 */
@Data
public class ModelDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private Long id;

    /**
     * 型号名称
     */
    private String modelName;

    /**
     * 商品图片
     */
    private String faceImg;
    /**
     * 内容图片
     */
    private String contentImg;


}