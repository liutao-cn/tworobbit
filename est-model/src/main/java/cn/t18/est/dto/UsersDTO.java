package cn.t18.est.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @TableName users
 */
@ApiModel("用户")
@Data
public class UsersDTO implements Serializable {

    private String token;

    /**
     * 
     */
    @ApiModelProperty("用户id")
    private Long id;

    /**
     * 账号（手机号）
     */
    @ApiModelProperty("用户手机号")
    private String account;


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
     * 头像
     */
    private String faceUrl;

    /**
     * 微信openId
     */
    private String openid;

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

 }