package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 故障选项
 * @TableName malfunction_options
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MalfunctionOptions implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 商品型号id
     */
    private Long modelId;

    /**
     * 故障id
     */
    private Long malfId;

    /**
     * 名称
     */
    private String optionName;

    /**
     * 是否有提示0:否,1:是)
     */
    private Integer isHint;

    /**
     * 提示信息
     */
    private String hintInfo;

    /**
     * 提示图片
     */
    private String hintImg;

    /**
     * 处理方式（1:维修,2:更换配件）
     */
    private Integer processType;

    /**
     * 本项问题价格占比（最大100）
     */
    private Integer ratio;

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
     * 商品型号id
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * 商品型号id
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
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
     * 名称
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 名称
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * 是否有提示0:否,1:是)
     */
    public Integer getIsHint() {
        return isHint;
    }

    /**
     * 是否有提示0:否,1:是)
     */
    public void setIsHint(Integer isHint) {
        this.isHint = isHint;
    }

    /**
     * 提示信息
     */
    public String getHintInfo() {
        return hintInfo;
    }

    /**
     * 提示信息
     */
    public void setHintInfo(String hintInfo) {
        this.hintInfo = hintInfo;
    }

    /**
     * 提示图片
     */
    public String getHintImg() {
        return hintImg;
    }

    /**
     * 提示图片
     */
    public void setHintImg(String hintImg) {
        this.hintImg = hintImg;
    }

    /**
     * 处理方式（1:维修,2:更换配件）
     */
    public Integer getProcessType() {
        return processType;
    }

    /**
     * 处理方式（1:维修,2:更换配件）
     */
    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    /**
     * 本项问题价格占比（最大100）
     */
    public Integer getRatio() {
        return ratio;
    }

    /**
     * 本项问题价格占比（最大100）
     */
    public void setRatio(Integer ratio) {
        this.ratio = ratio;
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
        MalfunctionOptions other = (MalfunctionOptions) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getMalfId() == null ? other.getMalfId() == null : this.getMalfId().equals(other.getMalfId()))
            && (this.getOptionName() == null ? other.getOptionName() == null : this.getOptionName().equals(other.getOptionName()))
            && (this.getIsHint() == null ? other.getIsHint() == null : this.getIsHint().equals(other.getIsHint()))
            && (this.getHintInfo() == null ? other.getHintInfo() == null : this.getHintInfo().equals(other.getHintInfo()))
            && (this.getHintImg() == null ? other.getHintImg() == null : this.getHintImg().equals(other.getHintImg()))
            && (this.getProcessType() == null ? other.getProcessType() == null : this.getProcessType().equals(other.getProcessType()))
            && (this.getRatio() == null ? other.getRatio() == null : this.getRatio().equals(other.getRatio()))
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
        result = prime * result + ((getMalfId() == null) ? 0 : getMalfId().hashCode());
        result = prime * result + ((getOptionName() == null) ? 0 : getOptionName().hashCode());
        result = prime * result + ((getIsHint() == null) ? 0 : getIsHint().hashCode());
        result = prime * result + ((getHintInfo() == null) ? 0 : getHintInfo().hashCode());
        result = prime * result + ((getHintImg() == null) ? 0 : getHintImg().hashCode());
        result = prime * result + ((getProcessType() == null) ? 0 : getProcessType().hashCode());
        result = prime * result + ((getRatio() == null) ? 0 : getRatio().hashCode());
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
        sb.append(", malfId=").append(malfId);
        sb.append(", optionName=").append(optionName);
        sb.append(", isHint=").append(isHint);
        sb.append(", hintInfo=").append(hintInfo);
        sb.append(", hintImg=").append(hintImg);
        sb.append(", processType=").append(processType);
        sb.append(", ratio=").append(ratio);
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