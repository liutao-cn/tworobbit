package cn.t18.est.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单
 * @TableName menus
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menus implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 菜单编号
     */
    private String menuCode;

    /**
     * 菜单名称名称
     */
    private String menuName;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 状态（0:无效,1:有效）
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
     * 菜单编号
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 菜单编号
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 菜单名称名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单名称名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 访问地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 访问地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 状态（0:无效,1:有效）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（0:无效,1:有效）
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
        Menus other = (Menus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuCode() == null ? other.getMenuCode() == null : this.getMenuCode().equals(other.getMenuCode()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
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
        result = prime * result + ((getMenuCode() == null) ? 0 : getMenuCode().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
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
        sb.append(", menuCode=").append(menuCode);
        sb.append(", menuName=").append(menuName);
        sb.append(", url=").append(url);
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