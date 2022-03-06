package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修订单流水信息
 * @TableName maintain_order_flow
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintainOrderFlow implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单状态（1:预约下单,2:支付定金,3:后台确认,4:实物质检,5:用户确认检查结果,6:维修完成,7:用户确认维修结果,8:支付尾款,9:用户取消,10结束）
     */
    private Integer orderStatus;

    /**
     * 订单状态说明
     */
    private String orderStatusDesc;

    /**
     * 操作人id
     */
    private Long operationUId;

    /**
     * 操作人姓名
     */
    private String operationName;

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
     * 订单状态（1:预约下单,2:支付定金,3:后台确认,4:实物质检,5:用户确认检查结果,6:维修完成,7:用户确认维修结果,8:支付尾款,9:用户取消,10结束）
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态（1:预约下单,2:支付定金,3:后台确认,4:实物质检,5:用户确认检查结果,6:维修完成,7:用户确认维修结果,8:支付尾款,9:用户取消,10结束）
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 订单状态说明
     */
    public String getOrderStatusDesc() {
        return orderStatusDesc;
    }

    /**
     * 订单状态说明
     */
    public void setOrderStatusDesc(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }

    /**
     * 操作人id
     */
    public Long getOperationUId() {
        return operationUId;
    }

    /**
     * 操作人id
     */
    public void setOperationUId(Long operationUId) {
        this.operationUId = operationUId;
    }

    /**
     * 操作人姓名
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 操作人姓名
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
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
        MaintainOrderFlow other = (MaintainOrderFlow) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderStatusDesc() == null ? other.getOrderStatusDesc() == null : this.getOrderStatusDesc().equals(other.getOrderStatusDesc()))
            && (this.getOperationUId() == null ? other.getOperationUId() == null : this.getOperationUId().equals(other.getOperationUId()))
            && (this.getOperationName() == null ? other.getOperationName() == null : this.getOperationName().equals(other.getOperationName()))
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
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderStatusDesc() == null) ? 0 : getOrderStatusDesc().hashCode());
        result = prime * result + ((getOperationUId() == null) ? 0 : getOperationUId().hashCode());
        result = prime * result + ((getOperationName() == null) ? 0 : getOperationName().hashCode());
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
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderStatusDesc=").append(orderStatusDesc);
        sb.append(", operationUId=").append(operationUId);
        sb.append(", operationName=").append(operationName);
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