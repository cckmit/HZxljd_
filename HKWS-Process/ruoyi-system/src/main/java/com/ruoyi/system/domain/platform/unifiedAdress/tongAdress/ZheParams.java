package com.ruoyi.system.domain.platform.unifiedAdress.tongAdress;

/**
 * @author FanKaibiao
 * @date 2021-06-18-20:25
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-06-18 20:23:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class ZheParams implements Serializable {

    private int code;
    private String msg;
    private boolean success;
    private ZheDate data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }

    public boolean isSuccess() {
        return success;
    }

    public ZheDate getData() {
        return data;
    }

    public void setData(ZheDate data) {
        this.data = data;
    }
}