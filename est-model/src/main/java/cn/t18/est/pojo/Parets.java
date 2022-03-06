package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 零配件表
 * @TableName parets
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parets implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 型号id
     */
    private Long modelId;

    /**
     * 配件名称
     */
    private String paretsName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 图片
     */
    private String img;

    /**
     * 是否原厂（0:否,1:是,2:未知）
     */
    private Integer isOrign;

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
     * 型号id
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * 型号id
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /**
     * 配件名称
     */
    public String getParetsName() {
        return paretsName;
    }

    /**
     * 配件名称
     */
    public void setParetsName(String paretsName) {
        this.paretsName = paretsName;
    }

    /**
     * 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 供应商
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * 供应商
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 是否原厂（0:否,1:是,2:未知）
     */
    public Integer getIsOrign() {
        return isOrign;
    }

    /**
     * 是否原厂（0:否,1:是,2:未知）
     */
    public void setIsOrign(Integer isOrign) {
        this.isOrign = isOrign;
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
        Parets other = (Parets) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getParetsName() == null ? other.getParetsName() == null : this.getParetsName().equals(other.getParetsName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getSupplier() == null ? other.getSupplier() == null : this.getSupplier().equals(other.getSupplier()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getIsOrign() == null ? other.getIsOrign() == null : this.getIsOrign().equals(other.getIsOrign()))
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
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getParetsName() == null) ? 0 : getParetsName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getSupplier() == null) ? 0 : getSupplier().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getIsOrign() == null) ? 0 : getIsOrign().hashCode());
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
        sb.append(", modelId=").append(modelId);
        sb.append(", paretsName=").append(paretsName);
        sb.append(", price=").append(price);
        sb.append(", supplier=").append(supplier);
        sb.append(", img=").append(img);
        sb.append(", isOrign=").append(isOrign);
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