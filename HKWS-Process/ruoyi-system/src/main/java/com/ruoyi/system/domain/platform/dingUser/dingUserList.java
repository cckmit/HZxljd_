package com.ruoyi.system.domain.platform.dingUser;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright 2021 json.cn
 */
        import java.util.List;

/**
 * Auto-generated: 2021-05-24 15:31:49
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class dingUserList implements Serializable {

    private boolean active;
    private boolean admin;
    private String avatar;
    private boolean boss;
    private List<Long> dept_id_list;
    private long dept_order;
    private String email;
    private boolean exclusive_account;
    private boolean hide_mobile;
    private String job_number;
    private boolean leader;
    private String mobile;
    private String name;
    private String remark;
    private String state_code;
    private String telephone;
    private String title;
    private String unionid;
    private String userid;
    private String work_place;
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean getActive() {
        return active;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public boolean getAdmin() {
        return admin;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }
    public boolean getBoss() {
        return boss;
    }

    public void setDept_id_list(List<Long> dept_id_list) {
        this.dept_id_list = dept_id_list;
    }
    public List<Long> getDept_id_list() {
        return dept_id_list;
    }

    public void setDept_order(long dept_order) {
        this.dept_order = dept_order;
    }
    public long getDept_order() {
        return dept_order;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setExclusive_account(boolean exclusive_account) {
        this.exclusive_account = exclusive_account;
    }
    public boolean getExclusive_account() {
        return exclusive_account;
    }

    public void setHide_mobile(boolean hide_mobile) {
        this.hide_mobile = hide_mobile;
    }
    public boolean getHide_mobile() {
        return hide_mobile;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }
    public String getJob_number() {
        return job_number;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
    public boolean getLeader() {
        return leader;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getMobile() {
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getRemark() {
        return remark;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }
    public String getState_code() {
        return state_code;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
    public String getUnionid() {
        return unionid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUserid() {
        return userid;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }
    public String getWork_place() {
        return work_place;
    }

}
