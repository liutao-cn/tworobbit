package cn.t18.est.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类
 * @TableName classify
 */
@Data
public class ClassifyDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 类型名称
     */
    private String classifyName;

    /**
     * 图标
     */
    private String icon;

    /**
     * 大图标
     */
    private String bigIcon;

    /**
     * 品牌dto集合
     */
    List<BrandDTO> brandList = new ArrayList<BrandDTO>();
}