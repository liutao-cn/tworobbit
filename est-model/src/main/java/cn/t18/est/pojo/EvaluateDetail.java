package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评估信息详情
 * @TableName evaluate_detail
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvaluateDetail implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 评估信息Id
     */
    private Long evaluateId;

    /**
     * 故障id
     */
    private Long malfId;

    /**
     * 故障选项选项id
     */
    private Long optionId;

    /**
     * 故障选项选项名称
     */
    private String optionName;

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
     * 评估信息Id
     */
    public Long getEvaluateId() {
        return evaluateId;
    }

    /**
     * 评估信息Id
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    /**
     * 故障id
     */
    public Long getMalfId() {
        return malfId;
    }

    /**
     * 故障id
     */
    public void setMalfId(Long malfId) {
        this.malfId = malfId;
    }

    /**
     * 故障选项选项id
     */
    public Long getOptionId() {
        return optionId;
    }

    /**
     * 故障选项选项id
     */
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    /**
     * 故障选项选项名称
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 故障选项选项名称
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
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
        EvaluateDetail other = (EvaluateDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEvaluateId() == null ? other.getEvaluateId() == null : this.getEvaluateId().equals(other.getEvaluateId()))
            && (this.getMalfId() == null ? other.getMalfId() == null : this.getMalfId().equals(other.getMalfId()))
            && (this.getOptionId() == null ? other.getOptionId() == null : this.getOptionId().equals(other.getOptionId()))
            && (this.getOptionName() == null ? other.getOptionName() == null : this.getOptionName().equals(other.getOptionName()))
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
        result = prime * result + ((getEvaluateId() == null) ? 0 : getEvaluateId().hashCode());
        result = prime * result + ((getMalfId() == null) ? 0 : getMalfId().hashCode());
        result = prime * result + ((getOptionId() == null) ? 0 : getOptionId().hashCode());
        result = prime * result + ((getOptionName() == null) ? 0 : getOptionName().hashCode());
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
        sb.append(", evaluateId=").append(evaluateId);
        sb.append(", malfId=").append(malfId);
        sb.append(", optionId=").append(optionId);
        sb.append(", optionName=").append(optionName);
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