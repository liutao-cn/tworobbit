package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品型号
 * @TableName model
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  //查出的数据为空时不会显示
public class Model implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 型号名称
     */
    private String modelName;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 类型id
     */
    private Long classifyId;

    /**
     * 当前行情价格
     */
    private BigDecimal exchangePrice;

    /**
     * 最高价
     */
    private BigDecimal topPrice;

    /**
     * 封面图片
     */
    private String faceImg;

    /**
     * 内容图片
     */
    private String contentImg;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态（0:下架,1:上架）
     */
    private Integer status;

    /**
     * 创建人
     */
    private Long createdUserId;

    /**
     * 修改人
     */
    private Long updatedUserId;

    /**
     * 创建时间
     */
    private Date creatdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 是否删除(0:否,1:是)
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 型号名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 型号名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 品牌id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 品牌id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 类型id
     */
    public Long getClassifyId() {
        return classifyId;
    }

    /**
     * 类型id
     */
    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    /**
     * 当前行情价格
     */
    public BigDecimal getExchangePrice() {
        return exchangePrice;
    }

    /**
     * 当前行情价格
     */
    public void setExchangePrice(BigDecimal exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    /**
     * 最高价
     */
    public BigDecimal getTopPrice() {
        return topPrice;
    }

    /**
     * 最高价
     */
    public void setTopPrice(BigDecimal topPrice) {
        this.topPrice = topPrice;
    }

    /**
     * 封面图片
     */
    public String getFaceImg() {
        return faceImg;
    }

    /**
     * 封面图片
     */
    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

    /**
     * 内容图片
     */
    public String getContentImg() {
        return contentImg;
    }

    /**
     * 内容图片
     */
    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    /**
     * 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 状态（0:下架,1:上架）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（0:下架,1:上架）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建人
     */
    public Long getCreatedUserId() {
        return createdUserId;
    }

    /**
     * 创建人
     */
    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    /**
     * 修改人
     */
    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * 修改人
     */
    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * 创建时间
     */
    public Date getCreatdTime() {
        return creatdTime;
    }

    /**
     * 创建时间
     */
    public void setCreatdTime(Date creatdTime) {
        this.creatdTime = creatdTime;
    }

    /**
     * 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 是否删除(0:否,1:是)
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除(0:否,1:是)
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Model other = (Model) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getClassifyId() == null ? other.getClassifyId() == null : this.getClassifyId().equals(other.getClassifyId()))
            && (this.getExchangePrice() == null ? other.getExchangePrice() == null : this.getExchangePrice().equals(other.getExchangePrice()))
            && (this.getTopPrice() == null ? other.getTopPrice() == null : this.getTopPrice().equals(other.getTopPrice()))
            && (this.getFaceImg() == null ? other.getFaceImg() == null : this.getFaceImg().equals(other.getFaceImg()))
            && (this.getContentImg() == null ? other.getContentImg() == null : this.getContentImg().equals(other.getContentImg()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedUserId() == null ? other.getCreatedUserId() == null : this.getCreatedUserId().equals(other.getCreatedUserId()))
            && (this.getUpdatedUserId() == null ? other.getUpdatedUserId() == null : this.getUpdatedUserId().equals(other.getUpdatedUserId()))
            && (this.getCreatdTime() == null ? other.getCreatdTime() == null : this.getCreatdTime().equals(other.getCreatdTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getClassifyId() == null) ? 0 : getClassifyId().hashCode());
        result = prime * result + ((getExchangePrice() == null) ? 0 : getExchangePrice().hashCode());
        result = prime * result + ((getTopPrice() == null) ? 0 : getTopPrice().hashCode());
        result = prime * result + ((getFaceImg() == null) ? 0 : getFaceImg().hashCode());
        result = prime * result + ((getContentImg() == null) ? 0 : getContentImg().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedUserId() == null) ? 0 : getCreatedUserId().hashCode());
        result = prime * result + ((getUpdatedUserId() == null) ? 0 : getUpdatedUserId().hashCode());
        result = prime * result + ((getCreatdTime() == null) ? 0 : getCreatdTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", modelName=").append(modelName);
        sb.append(", brandId=").append(brandId);
        sb.append(", classifyId=").append(classifyId);
        sb.append(", exchangePrice=").append(exchangePrice);
        sb.append(", topPrice=").append(topPrice);
        sb.append(", faceImg=").append(faceImg);
        sb.append(", contentImg=").append(contentImg);
        sb.append(", description=").append(description);
        sb.append(", status=").append(status);
        sb.append(", createdUserId=").append(createdUserId);
        sb.append(", updatedUserId=").append(updatedUserId);
        sb.append(", creatdTime=").append(creatdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}