package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;
import java.util.List;

public class EventBackVo implements Serializable {

    private String eventId;

    private String eventIndexCode;

    private String eventType;

    private String eventAlertStatus;

    private String handlerUserName;

    private String handlerUserId;

    private String processTime;

    private String processResult;

    private String componentId;

    private List<EventBackProcessRecordVo> recordList;

    private Integer pageNum;

    private Integer pageSize;

    public List<EventBackProcessRecordVo> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<EventBackProcessRecordVo> recordList) {
        this.recordList = recordList;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventIndexCode() {
        return eventIndexCode;
    }

    public void setEventIndexCode(String eventIndexCode) {
        this.eventIndexCode = eventIndexCode;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getHandlerUserName() {
        return handlerUserName;
    }

    public void setHandlerUserName(String handlerUserName) {
        this.handlerUserName = handlerUserName;
    }

    public String getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(String handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getEventAlertStatus() {
        return eventAlertStatus;
    }

    public void setEventAlertStatus(String eventAlertStatus) {
        this.eventAlertStatus = eventAlertStatus;
    }
}
