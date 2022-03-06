package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店
 * @TableName store
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 地址
     */
    private String adress;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

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
     * 门店名称
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 门店名称
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 地址
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 地址
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * 经度
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 经度
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 纬度
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 纬度
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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
        Store other = (Store) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAdress() == null ? other.getAdress() == null : this.getAdress().equals(other.getAdress()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
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
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAdress() == null) ? 0 : getAdress().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
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
        sb.append(", storeName=").append(storeName);
        sb.append(", phone=").append(phone);
        sb.append(", adress=").append(adress);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
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