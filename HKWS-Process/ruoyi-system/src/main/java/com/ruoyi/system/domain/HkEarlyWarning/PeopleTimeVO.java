package com.ruoyi.system.domain.HkEarlyWarning;

import java.util.Date;

/**
 * 一人一档 耗时检测
 */
public class PeopleTimeVO {

    /**
     * 网格人员登录账号
     */
    private String loginName;

    /**
     * 网格人员昵称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改事件
     */
    private Date updateTime;

    /**
     * 总耗时
     */
    private Double time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}
