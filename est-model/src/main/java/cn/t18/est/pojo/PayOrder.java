package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单支付信息
 * @TableName pay_order
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayOrder implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 支付订单号
     */
    private String payNo;

    /**
     * 阿里交易订单号
     */
    private String aliTradeNo;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 支付金额
     */
    private BigDecimal price;

    /**
     * 支付类型（1:定金,2:尾款）
     */
    private Integer payType;

    /**
     * 支付状态（1:未支付,2:支付成功,3:支付失败）
     */
    private Integer status;

    /**
     * 支付途径（1:现金,2:刷卡,3:支付宝,4:微信）
     */
    private Integer payChannel;

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
     * 支付订单号
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * 支付订单号
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * 阿里交易订单号
     */
    public String getAliTradeNo() {
        return aliTradeNo;
    }

    /**
     * 阿里交易订单号
     */
    public void setAliTradeNo(String aliTradeNo) {
        this.aliTradeNo = aliTradeNo;
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
     * 支付金额
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 支付金额
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 支付类型（1:定金,2:尾款）
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 支付类型（1:定金,2:尾款）
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 支付状态（1:未支付,2:支付成功,3:支付失败）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 支付状态（1:未支付,2:支付成功,3:支付失败）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 支付途径（1:现金,2:刷卡,3:支付宝,4:微信）
     */
    public Integer getPayChannel() {
        return payChannel;
    }

    /**
     * 支付途径（1:现金,2:刷卡,3:支付宝,4:微信）
     */
    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
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
        PayOrder other = (PayOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getPayNo() == null ? other.getPayNo() == null : this.getPayNo().equals(other.getPayNo()))
            && (this.getAliTradeNo() == null ? other.getAliTradeNo() == null : this.getAliTradeNo().equals(other.getAliTradeNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayChannel() == null ? other.getPayChannel() == null : this.getPayChannel().equals(other.getPayChannel()))
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
        result = prime * result + ((getPayNo() == null) ? 0 : getPayNo().hashCode());
        result = prime * result + ((getAliTradeNo() == null) ? 0 : getAliTradeNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayChannel() == null) ? 0 : getPayChannel().hashCode());
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
        sb.append(", payNo=").append(payNo);
        sb.append(", aliTradeNo=").append(aliTradeNo);
        sb.append(", userId=").append(userId);
        sb.append(", price=").append(price);
        sb.append(", payType=").append(payType);
        sb.append(", status=").append(status);
        sb.append(", payChannel=").append(payChannel);
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