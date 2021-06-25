package com.ruoyi.web.controller.hkApi.dingding;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2021-05-21-10:51
 */
public class DingGetTokenDto implements Serializable {
    private String appkey;

    private String appsecret;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public DingGetTokenDto() {
    }

    public DingGetTokenDto(String appkey, String appsecret) {
        this.appkey = appkey;
        this.appsecret = appsecret;
    }
}
