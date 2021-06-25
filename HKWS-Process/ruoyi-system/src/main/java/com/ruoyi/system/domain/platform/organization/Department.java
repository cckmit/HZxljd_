package com.ruoyi.system.domain.platform.organization;


/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-05-21 21:8:13
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Department implements Serializable {

    private boolean createDeptGroup;
    private String name;
    private long id;
    private boolean autoAddUser;
    private int parentid;
    public void setCreateDeptGroup(boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }
    public boolean getCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setAutoAddUser(boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }
    public boolean getAutoAddUser() {
        return autoAddUser;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
    public int getParentid() {
        return parentid;
    }

}
