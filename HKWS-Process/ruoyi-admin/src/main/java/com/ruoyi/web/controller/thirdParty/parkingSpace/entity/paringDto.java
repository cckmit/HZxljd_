package com.ruoyi.web.controller.thirdParty.parkingSpace.entity;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2021-05-19-20:38
 */
public class paringDto implements Serializable {
    private String account;

    /**
     * 请求时间戳，防止恶意重复提交
     */
    private String timestamp;

    /**
     * 签名方式请参考签名生成规则
     */
    private String sign;

    /**
     * 请求信息主体
     */
    private String content;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
