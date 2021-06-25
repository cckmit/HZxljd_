package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.HkEntity.UserPostRegionVo;

public class CenterConfirmUserVo extends UserPostRegionVo {

    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private String username;

    private String phonenumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
