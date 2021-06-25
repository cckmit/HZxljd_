package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author FanKaibiao
 * @date 2020-11-03-16:30
 */
public class HkEventInfoRecord extends BaseEntity {

    /**
     * id
     */
    private Integer id;
    /**
     * uuid
     */
    private String  eventId;
    /**
     *uuid
     */
    private String eventUuid;
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
     *事件预警类别(1:数感城管 2:数感消防 3:数感社区)
     */
    private Integer eventCategory;
    /**
     * 事件预警类别名称(数感城管 数感消防 数感社区)
     */
    private String eventCategoryName;
    /**
     *事件预警来源(1:城市大脑 2:数感横店 3:基层四平台)
     */
    private Integer eventSource;
    /**
     *事件预警来源(城市大脑 数感横店 基层四平台)
     */
    private String eventSourceName;
    /**
     * 调度状态(1:已下达 2:未下达 3:已忽略）
     */
    private String eventDispatchType;
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
     * 事件状态(1:预警 2:研判中 3:调度中 4:签收 5:处置 6:完结)
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
     *事件超时时间
     */
    private Integer timeOut;
    /**
     *事件风险等级
     */
    private String riskLevel;
    /**
     *事件当前处理人
     */
    private String currentProcessorId;
    /**
     *事件当前处理人
     */
    private String currentProcessorName;
    /**
     * 事件预警时间
     */
    private String eventCreateTime;
    /**
     *事件更新时间
     */
    private String eventUpdateTime;
    /**
     *经纬度范围
     */
    private String geometry;
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
     *责任主体
     */
    private String responsibilitySubject;
    /**
     *事件发生的区域标识
     */
    private String regionIndexCode;
    /**
     *事件发生的区域名称(警情地址)
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
     *单位法人
     */
    private String companyLegalPerson;
    /**
     *事件单位地址
     */
    private String eventAddress;
    /**
     *统一信用社代码
     */
    private String creditUnionCode;
    /**
     *联系方式
     */
    private String companyContactInformation;
    /**
     *网格名称
     */
    private String gridName;
    /**
     *网格员
     */
    private String gridMan;
    /**
     *巡防队伍(人)
     */
    private String patrolTeam;
    /**
     * 巡防队伍联系方式
     */
    private String patrolTeamPhone;
    /**
     * 巡防队伍2(人)
     */
    private String patrolTeam2;
    /**
     * 巡防队伍2联系方式
     */
    private String patrolTeam2Phone;
    /**
     *网格社区
     */
    private String gridCommunity;
    /**
     *网格联系方式
     */
    private String gridContactInformation;
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
    private String date;
    /**
     *修改时间
     */
    private Date updateTime;

    private String dateNow;
    private String procdefType;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 指派的人
     */
    private String todoUserName;
    /**
     * 指派时间
     */
    private Date todoTime;

    public String getTodoUserName() {
        return todoUserName;
    }

    public void setTodoUserName(String todoUserName) {
        this.todoUserName = todoUserName;
    }

    public Date getTodoTime() {
        return todoTime;
    }

    public void setTodoTime(Date todoTime) {
        this.todoTime = todoTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProcdefType() {
        return procdefType;
    }

    public void setProcdefType(String procdefType) {
        this.procdefType = procdefType;
    }

    public String getDateNow() {
        return dateNow;
    }

    public void setDateNow(String dateNow) {
        this.dateNow = dateNow;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventUuid() {
        return eventUuid;
    }

    public void setEventUuid(String eventUuid) {
        this.eventUuid = eventUuid;
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

    public Integer getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(Integer eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventCategoryName() {
        return eventCategoryName;
    }

    public void setEventCategoryName(String eventCategoryName) {
        this.eventCategoryName = eventCategoryName;
    }

    public Integer getEventSource() {
        return eventSource;
    }

    public void setEventSource(Integer eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventSourceName() {
        return eventSourceName;
    }

    public void setEventSourceName(String eventSourceName) {
        this.eventSourceName = eventSourceName;
    }

    public String getEventDispatchType() {
        return eventDispatchType;
    }

    public void setEventDispatchType(String eventDispatchType) {
        this.eventDispatchType = eventDispatchType;
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

    public String getEventCreateTime() {
        return eventCreateTime;
    }

    public void setEventCreateTime(String eventCreateTime) {
        this.eventCreateTime = eventCreateTime;
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

    public String getResponsibilitySubject() {
        return responsibilitySubject;
    }

    public void setResponsibilitySubject(String responsibilitySubject) {
        this.responsibilitySubject = responsibilitySubject;
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

    public String getCompanyLegalPerson() {
        return companyLegalPerson;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getCreditUnionCode() {
        return creditUnionCode;
    }

    public void setCreditUnionCode(String creditUnionCode) {
        this.creditUnionCode = creditUnionCode;
    }

    public String getCompanyContactInformation() {
        return companyContactInformation;
    }

    public void setCompanyContactInformation(String companyContactInformation) {
        this.companyContactInformation = companyContactInformation;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public String getGridMan() {
        return gridMan;
    }

    public void setGridMan(String gridMan) {
        this.gridMan = gridMan;
    }

    public String getPatrolTeam() {
        return patrolTeam;
    }

    public void setPatrolTeam(String patrolTeam) {
        this.patrolTeam = patrolTeam;
    }

    public String getPatrolTeamPhone() {
        return patrolTeamPhone;
    }

    public void setPatrolTeamPhone(String patrolTeamPhone) {
        this.patrolTeamPhone = patrolTeamPhone;
    }

    public String getPatrolTeam2() {
        return patrolTeam2;
    }

    public void setPatrolTeam2(String patrolTeam2) {
        this.patrolTeam2 = patrolTeam2;
    }

    public String getPatrolTeam2Phone() {
        return patrolTeam2Phone;
    }

    public void setPatrolTeam2Phone(String patrolTeam2Phone) {
        this.patrolTeam2Phone = patrolTeam2Phone;
    }

    public String getGridCommunity() {
        return gridCommunity;
    }

    public void setGridCommunity(String gridCommunity) {
        this.gridCommunity = gridCommunity;
    }

    public String getGridContactInformation() {
        return gridContactInformation;
    }

    public void setGridContactInformation(String gridContactInformation) {
        this.gridContactInformation = gridContactInformation;
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

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public HkEventInfoRecord() {
    }

    public HkEventInfoRecord(Integer id, String eventId, String eventUuid, String componentId, String eventIndexCode, String eventTitle, String reportTime, String eventType, String eventTypeName, Integer eventCategory, String eventCategoryName, Integer eventSource, String eventSourceName, String eventDispatchType, String eventImage, String eventThumbnailImage, String storageId, Integer eventStatus, String eventStatusName, Integer eventAlertStatus, String eventAlertStatusName, String eventSubStatus, String eventSubStatusName, Integer reportType, String reportTypeName, Integer lawEnforcementType, String lawEnforcementTypeName, Integer timeOut, String riskLevel, String currentProcessorId, String currentProcessorName, String eventCreateTime, String eventUpdateTime, String geometry, String reportPersonId, String reportPersonName, String reportPersonRealName, String reportPersonPhone, String cameraIndexCode, String cameraName, String responsibilitySubject, String regionIndexCode, String regionName, String placeType, String placeTypeName, String placeIndexCode, String placeName, String companyLegalPerson, String eventAddress, String creditUnionCode, String companyContactInformation, String gridName, String gridMan, String patrolTeam, String patrolTeamPhone, String patrolTeam2, String patrolTeam2Phone, String gridCommunity, String gridContactInformation, String longitude, String latitude, String routingAddress, Integer extendInt1, Integer extendInt2, Integer extendInt3, String extendStr1, String extendStr2, String extendStr3, String extendJson, Date createTime, String date, Date updateTime, String dateNow, String procdefType) {
        this.id = id;
        this.eventId = eventId;
        this.eventUuid = eventUuid;
        this.componentId = componentId;
        this.eventIndexCode = eventIndexCode;
        this.eventTitle = eventTitle;
        this.reportTime = reportTime;
        this.eventType = eventType;
        this.eventTypeName = eventTypeName;
        this.eventCategory = eventCategory;
        this.eventCategoryName = eventCategoryName;
        this.eventSource = eventSource;
        this.eventSourceName = eventSourceName;
        this.eventDispatchType = eventDispatchType;
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
        this.timeOut = timeOut;
        this.riskLevel = riskLevel;
        this.currentProcessorId = currentProcessorId;
        this.currentProcessorName = currentProcessorName;
        this.eventCreateTime = eventCreateTime;
        this.eventUpdateTime = eventUpdateTime;
        this.geometry = geometry;
        this.reportPersonId = reportPersonId;
        this.reportPersonName = reportPersonName;
        this.reportPersonRealName = reportPersonRealName;
        this.reportPersonPhone = reportPersonPhone;
        this.cameraIndexCode = cameraIndexCode;
        this.cameraName = cameraName;
        this.responsibilitySubject = responsibilitySubject;
        this.regionIndexCode = regionIndexCode;
        this.regionName = regionName;
        this.placeType = placeType;
        this.placeTypeName = placeTypeName;
        this.placeIndexCode = placeIndexCode;
        this.placeName = placeName;
        this.companyLegalPerson = companyLegalPerson;
        this.eventAddress = eventAddress;
        this.creditUnionCode = creditUnionCode;
        this.companyContactInformation = companyContactInformation;
        this.gridName = gridName;
        this.gridMan = gridMan;
        this.patrolTeam = patrolTeam;
        this.patrolTeamPhone = patrolTeamPhone;
        this.patrolTeam2 = patrolTeam2;
        this.patrolTeam2Phone = patrolTeam2Phone;
        this.gridCommunity = gridCommunity;
        this.gridContactInformation = gridContactInformation;
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
        this.date = date;
        this.updateTime = updateTime;
        this.dateNow = dateNow;
        this.procdefType = procdefType;
    }
}
