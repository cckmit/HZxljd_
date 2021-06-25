package com.ruoyi.system.domain.platform.dingUser;

import java.io.Serializable;

/**
 * Copyright 2021 json.cn
 */

/**
 * Auto-generated: 2021-05-24 15:31:49
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class dingUserParm implements Serializable {

    private int errcode;
    private String errmsg;
    private dingResult result;
    private String request_id;
    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
    public int getErrcode() {
        return errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public String getErrmsg() {
        return errmsg;
    }

    public dingResult getResult() {
        return result;
    }

    public void setResult(dingResult result) {
        this.result = result;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
    public String getRequest_id() {
        return request_id;
    }

}
