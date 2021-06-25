package com.ruoyi.system.domain.platform.unifiedAdress;


import java.io.Serializable;

/**
 * @author xyq
 * @date 2021 类说明: 返回实体类
 */
public class GatewayAddress implements Serializable {
	private String code;
    private String message;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
