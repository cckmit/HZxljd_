package com.ruoyi.system.domain;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @program: data-ruoyi
 * @description: 待处理结果表
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 19:47
 **/
public class HKrecord extends BaseEntity {

    /** */
    private Integer id;
    /**uuid */
    private String recordId;
    /**关联的事件标识(事件uuid) */
    private String eventId;
    /** 事件处理人关联的区域标识*/
    private String regionIndexCode;
    /**事件处理人关联的区域名称 */
    private String regionName;
    /** 传入的事件处理记录标识*/
    private String handlerRecordIndexCode;
    /**事件处理人标识 */
   private String handlerIndexCode;
    /**事件处理人 */
    private String handlerName;
    /**处理人电话 */
    private String handlerPhone;
    /**处理内容 */
    private String  handlerContent;
    /**处理人处置事件的状态（1审核超时，2处置超时，3超时处置，4已处理） */
    private String  processStatus;
    /**处理人处置事件的状态名称（审核超时，处置超时，超时处置，已处理） */
    private String processStatusName;
    /**处理时间 */
    private Date processTime;
    /** */
    private Integer extendInt1;
    private Integer extendInt2;
    private Integer extendInt3;
    private Integer extendStr1;
    private String extendStr2;
    private String extendStr3;
    private String extendjson;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getHandlerRecordIndexCode() {
        return handlerRecordIndexCode;
    }

    public void setHandlerRecordIndexCode(String handlerRecordIndexCode) {
        this.handlerRecordIndexCode = handlerRecordIndexCode;
    }

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    public String getProcessStatusName() {
        return processStatusName;
    }

    public void setProcessStatusName(String processStatusName) {
        this.processStatusName = processStatusName;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public Integer getExtendInt1() {
        return extendInt1;
    }

    public void setExtendInt1(Integer extendInt1) {
        this.extendInt1 = extendInt1;
    }

    public Integer getExtendInt2() {
        return extendInt2;
    }

    public void setExtendInt2(Integer extendInt2) {
        this.extendInt2 = extendInt2;
    }

    public Integer getExtendInt3() {
        return extendInt3;
    }

    public void setExtendInt3(Integer extendInt3) {
        this.extendInt3 = extendInt3;
    }

    public Integer getExtendStr1() {
        return extendStr1;
    }

    public void setExtendStr1(Integer extendStr1) {
        this.extendStr1 = extendStr1;
    }

    public String getExtendStr2() {
        return extendStr2;
    }

    public void setExtendStr2(String extendStr2) {
        this.extendStr2 = extendStr2;
    }

    public String getExtendStr3() {
        return extendStr3;
    }

    public void setExtendStr3(String extendStr3) {
        this.extendStr3 = extendStr3;
    }

    public String getExtendjson() {
        return extendjson;
    }

    public void setExtendjson(String extendjson) {
        this.extendjson = extendjson;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerContent() {
        return handlerContent;
    }

    public void setHandlerContent(String handlerContent) {
        this.handlerContent = handlerContent;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getHandlerIndexCode() {
        return handlerIndexCode;
    }

    public void setHandlerIndexCode(String handlerIndexCode) {
        this.handlerIndexCode = handlerIndexCode;
    }
}
