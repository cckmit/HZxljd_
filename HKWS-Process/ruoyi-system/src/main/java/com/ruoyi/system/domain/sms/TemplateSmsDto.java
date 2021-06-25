package com.ruoyi.system.domain.sms;

import java.io.Serializable;

/**
 * 模板短信
 */
public class TemplateSmsDto implements Serializable {

    /**企业名称**/
    private String ecName;
    /**账户用户名**/
    private String apId;
    /**收信手机号**/
    private String mobiles;
    /**模板id**/
    private String templateId;
    /**模板变量**/
    private String params;
    /**签名**/
    private String sign;
    /**扩展吗**/
    private String addSerial;
    /**参数校验序列**/
    private String mac;

    public String getEcName() {
        return ecName;
    }

    public void setEcName(String ecName) {
        this.ecName = ecName;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAddSerial() {
        return addSerial;
    }

    public void setAddSerial(String addSerial) {
        this.addSerial = addSerial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
