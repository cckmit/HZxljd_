package com.ruoyi.system.domain.platform.illagallyPark;

import java.io.Serializable;
import java.util.List;

/**
 * @author FanKaibiao
 * @date 2021-05-19-18:36
 */
/**
 * Auto-generated: 2021-05-19 19:42:34
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class illParkList implements Serializable{

    private String msg;
    private int code;
    private List<illPark> data;
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

    public List<illPark> getData() {
        return data;
    }

    public void setData(List<illPark> data) {
        this.data = data;
    }
}
