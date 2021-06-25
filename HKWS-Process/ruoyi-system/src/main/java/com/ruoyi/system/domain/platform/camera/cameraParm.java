package com.ruoyi.system.domain.platform.camera;
/**
 * Copyright 2021 json.cn
 */
        import java.io.Serializable;
        import java.util.List;

/**
 * Auto-generated: 2021-05-26 17:12:55
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class cameraParm implements Serializable {

    private String code;
    private String msg;
    private cameraDate data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public cameraDate getData() {
        return data;
    }

    public void setData(cameraDate data) {
        this.data = data;
    }
}