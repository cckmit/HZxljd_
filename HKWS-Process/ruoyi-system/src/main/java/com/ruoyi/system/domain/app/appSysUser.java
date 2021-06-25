package com.ruoyi.system.domain.app;

import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;

/**
 * @program: data-ruoyi
 * @description: app_用户表
 * @author: Yang-Teng-Fei
 * @create: 2020-12-14 14:07
 **/
public class appSysUser implements Serializable {

    /** 用户名称 */
    private String userName;
    /** 登录名称 */
    private String loginName;
    /** 用户头像 */
    private String avatar;
    /** 用户类型 */
    private String userType;
    /** 用户ID */
    private Long userId;
    /** 辖区id */
    private Integer deptId;
    /** 辖区名称*/
    private String deptName;
    private String deptUuid;

    public String getDeptUuid() {
        return deptUuid;
    }

    public void setDeptUuid(String deptUuid) {
        this.deptUuid = deptUuid;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
