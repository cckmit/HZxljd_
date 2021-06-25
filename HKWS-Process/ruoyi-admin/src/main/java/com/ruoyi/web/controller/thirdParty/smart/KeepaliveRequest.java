package com.ruoyi.web.controller.thirdParty.smart;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 心跳维护
 *
 * @author lcl
 * @date: 2021/4/21
 **/
public class KeepaliveRequest {

    @JsonProperty("KeepaliveObject")
    private KeepaliveObjectVo keepaliveObject;

    public KeepaliveObjectVo getKeepaliveObject() {
        return keepaliveObject;
    }

    public void setKeepaliveObject(KeepaliveObjectVo keepaliveObject) {
        this.keepaliveObject = keepaliveObject;
    }

    public static class KeepaliveObjectVo{

        @JsonProperty("DeviceID")
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }
    }
}
