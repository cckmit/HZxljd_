package com.ruoyi.system.domain.platform.illagallyPark;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2021-05-20-10:34
 */
/**
 * Copyright 2021 json.cn
 */

/**
 * Auto-generated: 2021-05-20 10:28:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class illagallyDail implements Serializable{

    private String msg;
    private int code;
    private parkDate data;
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public parkDate getData() {
        return data;
    }

    public void setData(parkDate data) {
        this.data = data;
    }
}
