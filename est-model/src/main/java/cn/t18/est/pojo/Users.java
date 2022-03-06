package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @TableName users
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 账号（手机号）
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 性别（0:女,1:男,2:保密）
     */
    private Integer sex;

    /**
     * 是否实名认证（0:否,1:是）
     */
    private Integer isAuthentication;

    /**
     * 真是姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String cardNo;

    /**
     * 头像
     */
    private String faceUrl;

    /**
     * 微信openId
     */
    private String openId;

    /**
     * 微信绑定状态（0:未绑定,1:已绑定,2:已解绑）
     */
    private Integer bindStatus;

    /**
     * 微信绑定时间
     */
    private Date bindTime;

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
     * 账号（手机号）
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号（手机号）
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 昵称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 性别（0:女,1:男,2:保密）
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别（0:女,1:男,2:保密）
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 是否实名认证（0:否,1:是）
     */
    public Integer getIsAuthentication() {
        return isAuthentication;
    }

    /**
     * 是否实名认证（0:否,1:是）
     */
    public void setIsAuthentication(Integer isAuthentication) {
        this.isAuthentication = isAuthentication;
    }

    /**
     * 真是姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 真是姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 身份证号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 身份证号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 头像
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * 头像
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    /**
     * 微信openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 微信绑定状态（0:未绑定,1:已绑定,2:已解绑）
     */
    public Integer getBindStatus() {
        return bindStatus;
    }

    /**
     * 微信绑定状态（0:未绑定,1:已绑定,2:已解绑）
     */
    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    /**
     * 微信绑定时间
     */
    public Date getBindTime() {
        return bindTime;
    }

    /**
     * 微信绑定时间
     */
    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
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
        Users other = (Users) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getIsAuthentication() == null ? other.getIsAuthentication() == null : this.getIsAuthentication().equals(other.getIsAuthentication()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
            && (this.getFaceUrl() == null ? other.getFaceUrl() == null : this.getFaceUrl().equals(other.getFaceUrl()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getBindStatus() == null ? other.getBindStatus() == null : this.getBindStatus().equals(other.getBindStatus()))
            && (this.getBindTime() == null ? other.getBindTime() == null : this.getBindTime().equals(other.getBindTime()))
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
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getIsAuthentication() == null) ? 0 : getIsAuthentication().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getFaceUrl() == null) ? 0 : getFaceUrl().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getBindStatus() == null) ? 0 : getBindStatus().hashCode());
        result = prime * result + ((getBindTime() == null) ? 0 : getBindTime().hashCode());
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
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", isAuthentication=").append(isAuthentication);
        sb.append(", name=").append(name);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", faceUrl=").append(faceUrl);
        sb.append(", openId=").append(openId);
        sb.append(", bindStatus=").append(bindStatus);
        sb.append(", bindTime=").append(bindTime);
        sb.append(", updatedUserId=").append(updatedUserId);
        sb.append(", creatdTime=").append(creatdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}