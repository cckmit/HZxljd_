package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;
import java.util.List;

/**
 * @author: Lijiajia8
 * @date: 2020/4/30 10:56
 * @since: jdk1.8
 */
public class EventDTO  implements Serializable {
    /** 事件唯一标识 */
    private String eventIndexCode;

    /** 事件标题（可用于APP首页显示） */
    private String eventTitle;

    /** 事件发生地 */
    private String eventAddress;

    /** 事件上报时间 */
    private String reportTime;

    /** 事件类型 */
    private String eventType;

    /** 事件类型名称 */
    private String eventTypeName;

    /** 事件图片（大图） */
    private String eventImage;

    /** 事件图片（缩略图） */
    private String eventThumbnailImage;

    /** 图片存储设备id */
    private String storageId;

    /** 事件状态（处理中2；已完成3；已超时4；自动关闭5） */
    private Integer eventStatus;

    /** 事件状态（处理中2；已完成3；已超时4；自动关闭5） */
    private String eventStatusName;

    /** 事件子状态 1误报 2非误报 */
    private String eventSubStatus;

    /** 事件子状态名称 */
    private String eventSubStatusName;

    /** 事件上报类型（智能上报1；2人工上报） */
    private Integer reportType;

    /** 事件上报类型（智能上报1；2人工上报） */
    private String reportTypeName;

    /** 执法类型（1自行处置，2自治（自整改），3共治（社区督促），4执法，5不处理） */
    private Integer lawEnforcementType;

    /** 执法类型名称 */
    private String lawEnforcementTypeName;

    /** 超时时间 */
    private Integer timeOut;

    /** 事件风险等级 */
    private String riskLevel;

    /** 当前处理人 */
    private String currentProcessorId;

    /** 当前处理人 */
    private String currentProcessorName;

    /** 事件更新时间 */
    private String eventUpdateTime;

    /** 边界范围 */
    private List<PointDTO> geometry;

    public String getEventIndexCode() {
        return eventIndexCode;
    }

    public void setEventIndexCode(String eventIndexCode) {
        this.eventIndexCode = eventIndexCode;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventThumbnailImage() {
        return eventThumbnailImage;
    }

    public void setEventThumbnailImage(String eventThumbnailImage) {
        this.eventThumbnailImage = eventThumbnailImage;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventStatusName() {
        return eventStatusName;
    }

    public void setEventStatusName(String eventStatusName) {
        this.eventStatusName = eventStatusName;
    }

    public String getEventSubStatus() {
        return eventSubStatus;
    }

    public void setEventSubStatus(String eventSubStatus) {
        this.eventSubStatus = eventSubStatus;
    }

    public String getEventSubStatusName() {
        return eventSubStatusName;
    }

    public void setEventSubStatusName(String eventSubStatusName) {
        this.eventSubStatusName = eventSubStatusName;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }

    public void setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    public Integer getLawEnforcementType() {
        return lawEnforcementType;
    }

    public void setLawEnforcementType(Integer lawEnforcementType) {
        this.lawEnforcementType = lawEnforcementType;
    }

    public String getLawEnforcementTypeName() {
        return lawEnforcementTypeName;
    }

    public void setLawEnforcementTypeName(String lawEnforcementTypeName) {
        this.lawEnforcementTypeName = lawEnforcementTypeName;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getCurrentProcessorId() {
        return currentProcessorId;
    }

    public void setCurrentProcessorId(String currentProcessorId) {
        this.currentProcessorId = currentProcessorId;
    }

    public String getCurrentProcessorName() {
        return currentProcessorName;
    }

    public void setCurrentProcessorName(String currentProcessorName) {
        this.currentProcessorName = currentProcessorName;
    }

    public String getEventUpdateTime() {
        return eventUpdateTime;
    }

    public void setEventUpdateTime(String eventUpdateTime) {
        this.eventUpdateTime = eventUpdateTime;
    }

    public List<PointDTO> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<PointDTO> geometry) {
        this.geometry = geometry;
    }




}
