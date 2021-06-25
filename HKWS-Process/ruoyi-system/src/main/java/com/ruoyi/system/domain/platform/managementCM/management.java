package com.ruoyi.system.domain.platform.managementCM;

import java.io.Serializable;


/**
 * Copyright 2021 json.cn
 */

/**
 * Auto-generated: 2021-05-20 14:9:3
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class management  implements Serializable {

    private String code;
    private String msg;
    private managementData data;
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public managementData getData() {
        return data;
    }

    public void setData(managementData data) {
        this.data = data;
    }
}
