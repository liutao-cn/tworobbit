package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 故障
 * @TableName malfunction
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Malfunction implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 商品型号id
     */
    private Long modelId;

    /**
     * 故障名称
     */
    private String title;

    /**
     * 是否有提示（0:否,1:是）
     */
    private Integer isHint;

    /**
     * 提示信息标题
     */
    private String hintTitle;

    /**
     * 提示信息
     */
    private String hintInfo;

    /**
     * 提示图片
     */
    private String hintImg;

    /**
     * 维修最高价
     */
    private BigDecimal maintainTopPrice;

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

    /**
     * 规格属性选项列表
     */
    private List<MalfunctionOptions> optionsList=new ArrayList<MalfunctionOptions>();


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
     * 故障名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 故障名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 是否有提示（0:否,1:是）
     */
    public Integer getIsHint() {
        return isHint;
    }

    /**
     * 是否有提示（0:否,1:是）
     */
    public void setIsHint(Integer isHint) {
        this.isHint = isHint;
    }

    /**
     * 提示信息标题
     */
    public String getHintTitle() {
        return hintTitle;
    }

    /**
     * 提示信息标题
     */
    public void setHintTitle(String hintTitle) {
        this.hintTitle = hintTitle;
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
     * 维修最高价
     */
    public BigDecimal getMaintainTopPrice() {
        return maintainTopPrice;
    }

    /**
     * 维修最高价
     */
    public void setMaintainTopPrice(BigDecimal maintainTopPrice) {
        this.maintainTopPrice = maintainTopPrice;
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
        Malfunction other = (Malfunction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getIsHint() == null ? other.getIsHint() == null : this.getIsHint().equals(other.getIsHint()))
            && (this.getHintTitle() == null ? other.getHintTitle() == null : this.getHintTitle().equals(other.getHintTitle()))
            && (this.getHintInfo() == null ? other.getHintInfo() == null : this.getHintInfo().equals(other.getHintInfo()))
            && (this.getHintImg() == null ? other.getHintImg() == null : this.getHintImg().equals(other.getHintImg()))
            && (this.getMaintainTopPrice() == null ? other.getMaintainTopPrice() == null : this.getMaintainTopPrice().equals(other.getMaintainTopPrice()))
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
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getIsHint() == null) ? 0 : getIsHint().hashCode());
        result = prime * result + ((getHintTitle() == null) ? 0 : getHintTitle().hashCode());
        result = prime * result + ((getHintInfo() == null) ? 0 : getHintInfo().hashCode());
        result = prime * result + ((getHintImg() == null) ? 0 : getHintImg().hashCode());
        result = prime * result + ((getMaintainTopPrice() == null) ? 0 : getMaintainTopPrice().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", isHint=").append(isHint);
        sb.append(", hintTitle=").append(hintTitle);
        sb.append(", hintInfo=").append(hintInfo);
        sb.append(", hintImg=").append(hintImg);
        sb.append(", maintainTopPrice=").append(maintainTopPrice);
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