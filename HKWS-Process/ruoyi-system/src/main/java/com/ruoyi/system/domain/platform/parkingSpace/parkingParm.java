package com.ruoyi.system.domain.platform.parkingSpace;



/**
 * Copyright 2021 json.cn
 */
        import java.io.Serializable;
        import java.util.List;

/**
 * Auto-generated: 2021-05-26 15:24:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class parkingParm implements Serializable {

    private String code;
    private String msg;
    private int httpStatus;
    private List<parkingDate> data;
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

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
    public int getHttpStatus() {
        return httpStatus;
    }

    public List<parkingDate> getData() {
        return data;
    }

    public void setData(List<parkingDate> data) {
        this.data = data;
    }
}