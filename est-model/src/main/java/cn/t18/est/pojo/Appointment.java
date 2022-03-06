package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 预约
 * @TableName appointment
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Appointment implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 评估id
     */
    @NotNull
    private Long evaluateId;

    @NotNull
    private String sms;

    /**
     * 预约编号
     */
    private String appointCode;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 预约手机号
     */
    @NotNull
    @Length(min = 11,max = 11,message = "手机号码长度为11位数字")
    private String phone;

    /**
     * 预约日期
     */
    @Future(message = "预约日期只能为未来时间")
    private Date appintDate;

    /**
     * 预约时间（1:上午,2:中午,3:下午,4:晚上）
     */
    @NotNull
    private Integer temporalInterval;

    /**
     * 预约上门维修地址
     */
    @NotNull
    private String adress;

    /**
     * 状态((1:用户预约,2:完成)
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
     * 预约编号
     */
    public String getAppointCode() {
        return appointCode;
    }

    /**
     * 预约编号
     */
    public void setAppointCode(String appointCode) {
        this.appointCode = appointCode;
    }

    /**
     * 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 预约手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 预约手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 预约日期
     */
    public Date getAppintDate() {
        return appintDate;
    }

    /**
     * 预约日期
     */
    public void setAppintDate(Date appintDate) {
        this.appintDate = appintDate;
    }

    /**
     * 预约时间（1:上午,2:中午,3:下午,4:晚上）
     */
    public Integer getTemporalInterval() {
        return temporalInterval;
    }

    /**
     * 预约时间（1:上午,2:中午,3:下午,4:晚上）
     */
    public void setTemporalInterval(Integer temporalInterval) {
        this.temporalInterval = temporalInterval;
    }

    /**
     * 预约上门维修地址
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 预约上门维修地址
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * 状态((1:用户预约,2:完成)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态((1:用户预约,2:完成)
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
        Appointment other = (Appointment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppointCode() == null ? other.getAppointCode() == null : this.getAppointCode().equals(other.getAppointCode()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAppintDate() == null ? other.getAppintDate() == null : this.getAppintDate().equals(other.getAppintDate()))
            && (this.getTemporalInterval() == null ? other.getTemporalInterval() == null : this.getTemporalInterval().equals(other.getTemporalInterval()))
            && (this.getAdress() == null ? other.getAdress() == null : this.getAdress().equals(other.getAdress()))
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
        result = prime * result + ((getAppointCode() == null) ? 0 : getAppointCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAppintDate() == null) ? 0 : getAppintDate().hashCode());
        result = prime * result + ((getTemporalInterval() == null) ? 0 : getTemporalInterval().hashCode());
        result = prime * result + ((getAdress() == null) ? 0 : getAdress().hashCode());
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
        sb.append(", appointCode=").append(appointCode);
        sb.append(", userId=").append(userId);
        sb.append(", phone=").append(phone);
        sb.append(", appintDate=").append(appintDate);
        sb.append(", temporalInterval=").append(temporalInterval);
        sb.append(", adress=").append(adress);
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