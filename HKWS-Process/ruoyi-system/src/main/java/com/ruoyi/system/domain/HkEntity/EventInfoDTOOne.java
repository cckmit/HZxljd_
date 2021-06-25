package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-12-28-14:23
 */
public class EventInfoDTOOne implements Serializable {

    private String eventId;
    /**
     *组件标识
     */
    private String componentId;
    /**
     *事件唯一标识
     */
    private String eventIndexCode;
    /**
     *事件标题
     */
    private String eventTitle;
    /**
     *事件上报时间
     */
    private String reportTime;
    /**
     *事件类型
     */
    private String eventType;
    /**
     *事件类型名称
     */
    private String eventTypeName;
    /**
     *事件图片地址（原图）
     */
    private String eventImage;
    /**
     *事件图片地址（缩略图）
     */
    private String eventThumbnailImage;
    /**
     *图片存储设备id
     */
    private String storageId;
    /**
     *事件状态值（1已签收，2未签收，3已研判，4未研判，5已共治  6:未共治 7:已反馈 8:已忽略）
     */
    private Integer eventStatus;
    /**
     *事件状态名称（已签收，未签收，已研判，未研判，已共治  未共治 已反馈 已忽略）
     */
    private String eventStatusName;
    /**
     * 事件状态(1:预警 2:研判中 3:调度中 4:已退回 5:处置 6:完结,7已忽略 8:已关闭)
     */
    private Integer eventAlertStatus;
    /**
     * 事件状态(预警,研判中,调度中,签收,处置,完结)
     */
    private String eventAlertStatusName;
    /**
     *事件子状态值
     */
    private String eventSubStatus;
    /**
     *事件子状态名称
     */
    private String eventSubStatusName;
    /**
     *事件上报类型（1智能上报，2人工上报）
     */
    private Integer reportType;
    /**
     *事件上报类型名称（人工上报，智能上报）
     */
    private String reportTypeName;
    /**
     *事件执法类型（1自行处置，2自治/自整改，3共治/社区督促，4执法）
     */
    private Integer lawEnforcementType;
    /**
     *事件执法类型名称（自行处置，自治/自整改，共治/社区督促，执法）
     */
    private String lawEnforcementTypeName;
    /**
     *事件更新时间
     */
    private String eventUpdateTime;
    /**
     *经纬度范围
     */
    private String geometry;

    /*private List<TargetDTO> targets;*/
    /**
     *事件上报人标识
     */
    private String reportPersonId;
    /**
     *上报人名称
     */
    private String reportPersonName;
    /**
     *上报人真实姓名
     */
    private String reportPersonRealName;
    /**
     *上报电话
     */
    private String reportPersonPhone;
    /**
     *上报设备的id
     */
    private String cameraIndexCode;
    /**
     *上报设备的名称(预警来源)
     */
    private String cameraName;
    /**
     *事件发生的区域标识
     */
    private String regionIndexCode;
    /**
     *事件发生的区域名称(网格社区)
     */
    private String regionName;
    /**
     *场所类型
     */
    private String placeType;
    /**
     *场所类型名称
     */
    private String placeTypeName;
    /**
     *场所标识
     */
    private String placeIndexCode;
    /**
     *场所名称(涉及主体)
     */
    private String placeName;
    /**
     *发生地经度
     */
    private String longitude;
    /**
     *发生地纬度
     */
    private String latitude;
    /**
     *路由跳转地址
     */
    private String routingAddress;
    /**
     *
     */
    private Integer extendInt1;
    /**
     *
     */
    private Integer extendInt2;
    /**
     *
     */
    private Integer extendInt3;
    /**
     *
     */
    private String extendStr1;
    /**
     *
     */
    private String extendStr2;
    /**
     *
     */
    private String extendStr3;
    /**
     *
     */
    private String extendJson;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *修改时间
     */
    private Date updateTime;

    private List<EventProcessRecordDTO> processRecords;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

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

    public Integer getEventAlertStatus() {
        return eventAlertStatus;
    }

    public void setEventAlertStatus(Integer eventAlertStatus) {
        this.eventAlertStatus = eventAlertStatus;
    }

    public String getEventAlertStatusName() {
        return eventAlertStatusName;
    }

    public void setEventAlertStatusName(String eventAlertStatusName) {
        this.eventAlertStatusName = eventAlertStatusName;
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

    public String getEventUpdateTime() {
        return eventUpdateTime;
    }

    public void setEventUpdateTime(String eventUpdateTime) {
        this.eventUpdateTime = eventUpdateTime;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getReportPersonId() {
        return reportPersonId;
    }

    public void setReportPersonId(String reportPersonId) {
        this.reportPersonId = reportPersonId;
    }

    public String getReportPersonName() {
        return reportPersonName;
    }

    public void setReportPersonName(String reportPersonName) {
        this.reportPersonName = reportPersonName;
    }

    public String getReportPersonRealName() {
        return reportPersonRealName;
    }

    public void setReportPersonRealName(String reportPersonRealName) {
        this.reportPersonRealName = reportPersonRealName;
    }

    public String getReportPersonPhone() {
        return reportPersonPhone;
    }

    public void setReportPersonPhone(String reportPersonPhone) {
        this.reportPersonPhone = reportPersonPhone;
    }

    public String getCameraIndexCode() {
        return cameraIndexCode;
    }

    public void setCameraIndexCode(String cameraIndexCode) {
        this.cameraIndexCode = cameraIndexCode;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
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

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(String placeTypeName) {
        this.placeTypeName = placeTypeName;
    }

    public String getPlaceIndexCode() {
        return placeIndexCode;
    }

    public void setPlaceIndexCode(String placeIndexCode) {
        this.placeIndexCode = placeIndexCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRoutingAddress() {
        return routingAddress;
    }

    public void setRoutingAddress(String routingAddress) {
        this.routingAddress = routingAddress;
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

    public String getExtendStr1() {
        return extendStr1;
    }

    public void setExtendStr1(String extendStr1) {
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

    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<EventProcessRecordDTO> getProcessRecords() {
        return processRecords;
    }

    public void setProcessRecords(List<EventProcessRecordDTO> processRecords) {
        this.processRecords = processRecords;
    }

    public EventInfoDTOOne() {
    }

    public EventInfoDTOOne(String eventId, String componentId, String eventIndexCode, String eventTitle, String reportTime, String eventType, String eventTypeName, String eventImage, String eventThumbnailImage, String storageId, Integer eventStatus, String eventStatusName, Integer eventAlertStatus, String eventAlertStatusName, String eventSubStatus, String eventSubStatusName, Integer reportType, String reportTypeName, Integer lawEnforcementType, String lawEnforcementTypeName, String eventUpdateTime, String geometry, String reportPersonId, String reportPersonName, String reportPersonRealName, String reportPersonPhone, String cameraIndexCode, String cameraName, String regionIndexCode, String regionName, String placeType, String placeTypeName, String placeIndexCode, String placeName, String longitude, String latitude, String routingAddress, Integer extendInt1, Integer extendInt2, Integer extendInt3, String extendStr1, String extendStr2, String extendStr3, String extendJson, Date createTime, Date updateTime, List<EventProcessRecordDTO> processRecords) {
        this.eventId = eventId;
        this.componentId = componentId;
        this.eventIndexCode = eventIndexCode;
        this.eventTitle = eventTitle;
        this.reportTime = reportTime;
        this.eventType = eventType;
        this.eventTypeName = eventTypeName;
        this.eventImage = eventImage;
        this.eventThumbnailImage = eventThumbnailImage;
        this.storageId = storageId;
        this.eventStatus = eventStatus;
        this.eventStatusName = eventStatusName;
        this.eventAlertStatus = eventAlertStatus;
        this.eventAlertStatusName = eventAlertStatusName;
        this.eventSubStatus = eventSubStatus;
        this.eventSubStatusName = eventSubStatusName;
        this.reportType = reportType;
        this.reportTypeName = reportTypeName;
        this.lawEnforcementType = lawEnforcementType;
        this.lawEnforcementTypeName = lawEnforcementTypeName;
        this.eventUpdateTime = eventUpdateTime;
        this.geometry = geometry;
        this.reportPersonId = reportPersonId;
        this.reportPersonName = reportPersonName;
        this.reportPersonRealName = reportPersonRealName;
        this.reportPersonPhone = reportPersonPhone;
        this.cameraIndexCode = cameraIndexCode;
        this.cameraName = cameraName;
        this.regionIndexCode = regionIndexCode;
        this.regionName = regionName;
        this.placeType = placeType;
        this.placeTypeName = placeTypeName;
        this.placeIndexCode = placeIndexCode;
        this.placeName = placeName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.routingAddress = routingAddress;
        this.extendInt1 = extendInt1;
        this.extendInt2 = extendInt2;
        this.extendInt3 = extendInt3;
        this.extendStr1 = extendStr1;
        this.extendStr2 = extendStr2;
        this.extendStr3 = extendStr3;
        this.extendJson = extendJson;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.processRecords = processRecords;
    }
}
