package com.ruoyi.web.controller.thirdParty.smart;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 注册
 *
 * @author lcl
 * @date: 2021/4/21
 **/
public class RegisterRequest {

    @JsonProperty("RegisterObject")
    private RegisterObjectVo registerObject;

    public static class RegisterObjectVo{

        @JsonProperty("DeviceID")
        private String deviceId;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }
    }

    public RegisterObjectVo getRegisterObject() {
        return registerObject;
    }

    public void setRegisterObject(RegisterObjectVo registerObject) {
        this.registerObject = registerObject;
    }
}
