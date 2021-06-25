package com.ruoyi.web.controller.thirdParty.parkingSpace.entity;


import javax.validation.constraints.NotBlank;


/**
 * RequestData
 *
 * @author lcl
 * @date: 2021/4/15
 **/
public class RequestData {
    @NotBlank(message = "商户号不能为空")
    private String account;

    /**
     * 请求时间戳，防止恶意重复提交
     */
    @NotBlank(message = "时间戳不能为空")
    private String timestamp;

    /**
     * 签名方式请参考签名生成规则
     */
    @NotBlank(message = "签名不能为空")
    private String sign;

    /**
     * 请求信息主体
     */
    @NotBlank(message = "请求信息主体不能为空")
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
