package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 维修订单
 * @TableName maintain_order
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintainOrder implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 商品序列号
     */
    private String serialNo;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 型号id
     */
    private Long modelId;

    /**
     * 评估信息id
     */
    private Long evaluateId;

    /**
     * 订金金额
     */
    private BigDecimal subscription;

    /**
     * 实际交易金额
     */
    private BigDecimal price;

    /**
     * 订单状态（1:预约下单,2:支付定金,9:用户取消,10:完成）
     */
    private Integer status;

    /**
     * 是否评论
     */
    private Integer isComment;

    /**
     * 取消订单的原因
     */
    private String cancelReason;

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
     * 商品序列号
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 商品序列号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * 评估信息id
     */
    public Long getEvaluateId() {
        return evaluateId;
    }

    /**
     * 评估信息id
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    /**
     * 订金金额
     */
    public BigDecimal getSubscription() {
        return subscription;
    }

    /**
     * 订金金额
     */
    public void setSubscription(BigDecimal subscription) {
        this.subscription = subscription;
    }

    /**
     * 实际交易金额
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 实际交易金额
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 订单状态（1:预约下单,2:支付定金,9:用户取消,10:完成）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态（1:预约下单,2:支付定金,9:用户取消,10:完成）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否评论
     */
    public Integer getIsComment() {
        return isComment;
    }

    /**
     * 是否评论
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * 取消订单的原因
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 取消订单的原因
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
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
        MaintainOrder other = (MaintainOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getEvaluateId() == null ? other.getEvaluateId() == null : this.getEvaluateId().equals(other.getEvaluateId()))
            && (this.getSubscription() == null ? other.getSubscription() == null : this.getSubscription().equals(other.getSubscription()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsComment() == null ? other.getIsComment() == null : this.getIsComment().equals(other.getIsComment()))
            && (this.getCancelReason() == null ? other.getCancelReason() == null : this.getCancelReason().equals(other.getCancelReason()))
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
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getEvaluateId() == null) ? 0 : getEvaluateId().hashCode());
        result = prime * result + ((getSubscription() == null) ? 0 : getSubscription().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsComment() == null) ? 0 : getIsComment().hashCode());
        result = prime * result + ((getCancelReason() == null) ? 0 : getCancelReason().hashCode());
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
        sb.append(", serialNo=").append(serialNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", userId=").append(userId);
        sb.append(", modelId=").append(modelId);
        sb.append(", evaluateId=").append(evaluateId);
        sb.append(", subscription=").append(subscription);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", isComment=").append(isComment);
        sb.append(", cancelReason=").append(cancelReason);
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