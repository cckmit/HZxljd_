package com.ruoyi.system.domain.ding;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRole;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain.ding
 * @ClassName: DingUser
 * @Author: guohailong
 * @Description: 浙政钉用户对象
 * @Date: 2021/3/10 10:23
 * @Version: 1.0
 */
public class DingUser implements Serializable {

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 登录名称
     */
    private String loginName;
    /**
     * 浙政钉id
     */
    private String accountId;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 部门
     */
    private SysDept dept;
    /**
     * 是否领导
     */
    private String leaderFlag;
    /**
     * 角色
     */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public String getLeaderFlag() {
        return leaderFlag;
    }

    public void setLeaderFlag(String leaderFlag) {
        this.leaderFlag = leaderFlag;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
}
