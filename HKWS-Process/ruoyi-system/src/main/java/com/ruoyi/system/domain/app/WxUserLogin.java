package com.ruoyi.system.domain.app;

import java.io.Serializable;

/**
 * 小程序账号登录接受对象
 */
public class WxUserLogin implements Serializable {


    private String openid;

    private String sessionid;

    private String userName;

    private String password;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
