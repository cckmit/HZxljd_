package com.ruoyi.system.domain.app;

import java.io.Serializable;

/**
 * @program: data-ruoyi
 * @description: app-用户与角色关联
 * @author: Yang-Teng-Fei
 * @create: 2020-12-14 22:55
 **/
public class appRole implements Serializable {

    /**用户id */
    private Long userId;

    /** 角色id*/
    private Integer roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
