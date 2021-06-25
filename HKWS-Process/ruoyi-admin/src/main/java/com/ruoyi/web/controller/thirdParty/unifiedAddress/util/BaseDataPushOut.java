package com.ruoyi.web.controller.thirdParty.unifiedAddress.util;


import java.util.Date;

/**
 * @author cui
 * @version 1.0
 * @date 2021-03-22
 */
public class BaseDataPushOut<T> {


    /**
     * 推送类型--PushTypeEnum
     */
    private String pushType;

    /**
     * 推送事件编号
     * 事件推送-三方自己的事件编号(需在平台映射)
     * 数据推送-MetaDataTypeEnum
     */
    private String pushTypeCode;

    /**
     * 回调说明
     */
    private String remark;

    /**
     * 发生时间
     */
    private Date happenTime;

    /**
     * 解析后值
     */
    private T data;

    /**
     * 数据条数
     */
    private Integer num;

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getPushTypeCode() {
        return pushTypeCode;
    }

    public void setPushTypeCode(String pushTypeCode) {
        this.pushTypeCode = pushTypeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
