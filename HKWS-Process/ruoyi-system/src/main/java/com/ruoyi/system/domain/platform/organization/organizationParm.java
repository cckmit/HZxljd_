package com.ruoyi.system.domain.platform.organization;

/**
 * Copyright 2021 json.cn
 */
        import java.io.Serializable;
        import java.util.List;

/**
 * Auto-generated: 2021-05-21 21:8:13
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class organizationParm implements Serializable {

    private int errcode;
    private List<Department> department;
    private String errmsg;
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
    public int getErrcode() {
        return errcode;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
    public List<Department> getDepartment() {
        return department;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getErrmsg() {
        return errmsg;
    }

}
