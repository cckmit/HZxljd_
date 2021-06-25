package com.ruoyi.system.domain.ding;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain.ding
 * @ClassName: DingEvent
 * @Author: guohailong
 * @Description: 浙政钉-事件
 * @Date: 2021/3/21 23:08
 * @Version: 1.0
 */
public class DingEvent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 预警详情表
     */
    private String eventId;

    /**
     * 事件接入平台标识
     */
    private String componentId;

    /**
     * 事件唯一标识
     */
    private String eventIndexCode;

    /**
     * 事件标题
     */
    private String eventTitle;

    /**
     * 事件上报时间
     */
    private String reportTime;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 事件类型名称
     */
    private String eventTypeName;

    /**
     * 事件预警类别(1:数感城管 2:数感消防 3:数感社区) 无用
     */
    private Integer eventCategory;

    /**
     * 事件预警类别名称(数感城管 数感消防 数感社区)无用
     */
    private String eventCategoryName;

    /**
     * 事件预警来源(1:城市大脑 2:数感横店 3:基层四平台)无用
     */
    private Integer eventSource;

    /**
     * 事件预警来源(城市大脑 数感横店 基层四平台)无用
     */
    private String eventSourceName;

    /**
     * 事件图片地址（原图）
     */
    private String eventImage;

    /**
     * 事件图片地址（缩略图）
     */
    private String eventThumbnailImage;

    /**
     * 图片存储设备id
     */
    private String storageId;

    /**
     * 事件处置状态（1:未审核 2:已审核 3:中心处置 4:系统处置 5:人工处置）
     */
    private Integer eventStatus;

    /**
     * '事件状态名称（未审核 已审核 中心处置 系统处置 人工处置）无用
     */
    private String eventStatusName;

    /**
     * 事件状态(1:预警 2:研判中 3:调度中,4:已退回 5:处置 6:完结 7:已忽略 8:关闭详情 9:系统自动完成,10:重复报警)
     */
    private Integer eventAlertStatus;

    /**
     * 事件状态(预警,研判中,调度中,签收,处置,完结,已忽略,已关闭) 无用
     */
    private String eventAlertStatusName;

    /**
     * 事件子类型
     */
    private String eventSubStatus;

    /**
     * 事件子类型名称
     */
    private String eventSubStatusName;

    /**
     * 事件上报类型（1智能上报，2人工上报）
     */
    private Integer reportType;

    /**
     * 事件上报类型名称（人工上报，智能上报）
     */
    private String reportTypeName;

    /**
     * 事件执法类型（1自行处置，2自治/自整改，3共治/社区督促，4执法）
     */
    private Integer lawEnforcementType;

    /**
     * 事件执法类型名称（自行处置，自治/自整改，共治/社区督促，执法）
     */
    private String lawEnforcementTypeName;

    /**
     * 是否查看(0否  1是)
     */
    private Integer isView;

    /**
     * 超时时间
     */
    private Date timeOut;

    /**
     * 事件风险等级
     */
    private String riskLevel;

    /**
     * 事件当前处理人
     */
    private String currentProcessorId;

    /**
     * 事件当前处理人
     */
    private String currentProcessorName;

    /**
     * 事件更新时间
     */
    private String eventUpdateTime;

    /**
     * 当天时间
     */
    private String eventCreateTime;

    /**
     * 经纬度范围
     */
    private String geometry;

    /**
     * 事件上报人标识
     */
    private String reportPersonId;

    /**
     * 上报人名称
     */
    private String reportPersonName;

    /**
     * 上报人真实姓名
     */
    private String reportPersonRealName;

    /**
     * 上报电话
     */
    private String reportPersonPhone;

    /**
     * 上报设备的id
     */
    private String cameraIndexCode;

    /**
     * 上报设备的名称(预警来源)
     */
    private String cameraName;

    /**
     * 责任主体
     */
    private String responsibilitySubject;

    /**
     * 事件发生的区域标识
     */
    private String regionIndexCode;

    /**
     * 事件发生的区域名称(网格社区)
     */
    private String regionName;

    /**
     * 场所类型
     */
    private String placeType;

    /**
     * 场所类型名称
     */
    private String placeTypeName;

    /**
     * 场所标识
     */
    private String placeIndexCode;

    /**
     * 场所名称(涉及主体)
     */
    private String placeName;

    /**
     * 单位法人
     */
    private String companyLegalPerson;

    /**
     * 事件单位地址
     */
    private String eventAddress;

    /**
     * 统一信用社代码
     */
    private String creditUnionCode;

    /**
     * 联系方式
     */
    private String companyContactInformation;

    /**
     * 网格名称
     */
    private String gridName;

    /**
     * 网格员
     */
    private String gridMan;

    /**
     * 巡防队伍
     */
    private String patrolTeam;

    /**
     * 巡防队伍 联系方式
     */
    private String patrolTeamPhone;

    /**
     * 巡防队伍2
     */
    private String patrolTeam2;

    /**
     * 巡防队伍2联系方式
     */
    private String patrolTeam2Phone;

    /**
     * 警情地址
     */
    private String gridCommunity;

    /**
     * 网格联系方式
     */
    private String gridContactInformation;

    /**
     * 发生地经度
     */
    private String longitude;

    /**
     * 发生地纬度
     */
    private String latitude;

    /**
     * 路由跳转地址
     */
    private String routingAddress;

    /**
     * 备注(忽略和关闭原因)
     */
    private String eventRemarks;

    /**
     * $column.columnComment
     */
    private Integer extendInt1;

    /**
     * $column.columnComment
     */
    private Integer extendInt2;

    /**
     * $column.columnComment
     */
    private Integer extendInt3;

    /**
     * 青和云接入视频地址
     */
    private String extendStr1;

    /**
     * 各平台事件类型
     */
    private String extendStr2;

    /**
     * 青和云视频地址
     */
    private String extendStr3;

    /**
     * $column.columnComment
     */
    private String extendjson;

    /**
     * 行动链唯一标识
     */
    private String procdefType;

    /**
     * 0:未读 1:已读
     */
    private Integer eventRead;

    /**
     * 上传事件设备类型编号
     */
    private String cameraTypeCode;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setEventIndexCode(String eventIndexCode) {
        this.eventIndexCode = eventIndexCode;
    }

    public String getEventIndexCode() {
        return eventIndexCode;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventCategory(Integer eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Integer getEventCategory() {
        return eventCategory;
    }

    public void setEventCategoryName(String eventCategoryName) {
        this.eventCategoryName = eventCategoryName;
    }

    public String getEventCategoryName() {
        return eventCategoryName;
    }

    public void setEventSource(Integer eventSource) {
        this.eventSource = eventSource;
    }

    public Integer getEventSource() {
        return eventSource;
    }

    public void setEventSourceName(String eventSourceName) {
        this.eventSourceName = eventSourceName;
    }

    public String getEventSourceName() {
        return eventSourceName;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventThumbnailImage(String eventThumbnailImage) {
        this.eventThumbnailImage = eventThumbnailImage;
    }

    public String getEventThumbnailImage() {
        return eventThumbnailImage;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Integer getEventStatus() {
        return eventStatus;
    }

    public void setEventStatusName(String eventStatusName) {
        this.eventStatusName = eventStatusName;
    }

    public String getEventStatusName() {
        return eventStatusName;
    }

    public void setEventAlertStatus(Integer eventAlertStatus) {
        this.eventAlertStatus = eventAlertStatus;
    }

    public Integer getEventAlertStatus() {
        return eventAlertStatus;
    }

    public void setEventAlertStatusName(String eventAlertStatusName) {
        this.eventAlertStatusName = eventAlertStatusName;
    }

    public String getEventAlertStatusName() {
        return eventAlertStatusName;
    }

    public void setEventSubStatus(String eventSubStatus) {
        this.eventSubStatus = eventSubStatus;
    }

    public String getEventSubStatus() {
        return eventSubStatus;
    }

    public void setEventSubStatusName(String eventSubStatusName) {
        this.eventSubStatusName = eventSubStatusName;
    }

    public String getEventSubStatusName() {
        return eventSubStatusName;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportTypeName(String reportTypeName) {
        this.reportTypeName = reportTypeName;
    }

    public String getReportTypeName() {
        return reportTypeName;
    }

    public void setLawEnforcementType(Integer lawEnforcementType) {
        this.lawEnforcementType = lawEnforcementType;
    }

    public Integer getLawEnforcementType() {
        return lawEnforcementType;
    }

    public void setLawEnforcementTypeName(String lawEnforcementTypeName) {
        this.lawEnforcementTypeName = lawEnforcementTypeName;
    }

    public String getLawEnforcementTypeName() {
        return lawEnforcementTypeName;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setCurrentProcessorId(String currentProcessorId) {
        this.currentProcessorId = currentProcessorId;
    }

    public String getCurrentProcessorId() {
        return currentProcessorId;
    }

    public void setCurrentProcessorName(String currentProcessorName) {
        this.currentProcessorName = currentProcessorName;
    }

    public String getCurrentProcessorName() {
        return currentProcessorName;
    }

    public void setEventUpdateTime(String eventUpdateTime) {
        this.eventUpdateTime = eventUpdateTime;
    }

    public String getEventUpdateTime() {
        return eventUpdateTime;
    }

    public void setEventCreateTime(String eventCreateTime) {
        this.eventCreateTime = eventCreateTime;
    }

    public String getEventCreateTime() {
        return eventCreateTime;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setReportPersonId(String reportPersonId) {
        this.reportPersonId = reportPersonId;
    }

    public String getReportPersonId() {
        return reportPersonId;
    }

    public void setReportPersonName(String reportPersonName) {
        this.reportPersonName = reportPersonName;
    }

    public String getReportPersonName() {
        return reportPersonName;
    }

    public void setReportPersonRealName(String reportPersonRealName) {
        this.reportPersonRealName = reportPersonRealName;
    }

    public String getReportPersonRealName() {
        return reportPersonRealName;
    }

    public void setReportPersonPhone(String reportPersonPhone) {
        this.reportPersonPhone = reportPersonPhone;
    }

    public String getReportPersonPhone() {
        return reportPersonPhone;
    }

    public void setCameraIndexCode(String cameraIndexCode) {
        this.cameraIndexCode = cameraIndexCode;
    }

    public String getCameraIndexCode() {
        return cameraIndexCode;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setResponsibilitySubject(String responsibilitySubject) {
        this.responsibilitySubject = responsibilitySubject;
    }

    public String getResponsibilitySubject() {
        return responsibilitySubject;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
    }

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceTypeName(String placeTypeName) {
        this.placeTypeName = placeTypeName;
    }

    public String getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceIndexCode(String placeIndexCode) {
        this.placeIndexCode = placeIndexCode;
    }

    public String getPlaceIndexCode() {
        return placeIndexCode;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setCompanyLegalPerson(String companyLegalPerson) {
        this.companyLegalPerson = companyLegalPerson;
    }

    public String getCompanyLegalPerson() {
        return companyLegalPerson;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setCreditUnionCode(String creditUnionCode) {
        this.creditUnionCode = creditUnionCode;
    }

    public String getCreditUnionCode() {
        return creditUnionCode;
    }

    public void setCompanyContactInformation(String companyContactInformation) {
        this.companyContactInformation = companyContactInformation;
    }

    public String getCompanyContactInformation() {
        return companyContactInformation;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridMan(String gridMan) {
        this.gridMan = gridMan;
    }

    public String getGridMan() {
        return gridMan;
    }

    public void setPatrolTeam(String patrolTeam) {
        this.patrolTeam = patrolTeam;
    }

    public String getPatrolTeam() {
        return patrolTeam;
    }

    public void setPatrolTeamPhone(String patrolTeamPhone) {
        this.patrolTeamPhone = patrolTeamPhone;
    }

    public String getPatrolTeamPhone() {
        return patrolTeamPhone;
    }

    public void setPatrolTeam2(String patrolTeam2) {
        this.patrolTeam2 = patrolTeam2;
    }

    public String getPatrolTeam2() {
        return patrolTeam2;
    }

    public void setPatrolTeam2Phone(String patrolTeam2Phone) {
        this.patrolTeam2Phone = patrolTeam2Phone;
    }

    public String getPatrolTeam2Phone() {
        return patrolTeam2Phone;
    }

    public void setGridCommunity(String gridCommunity) {
        this.gridCommunity = gridCommunity;
    }

    public String getGridCommunity() {
        return gridCommunity;
    }

    public void setGridContactInformation(String gridContactInformation) {
        this.gridContactInformation = gridContactInformation;
    }

    public String getGridContactInformation() {
        return gridContactInformation;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setRoutingAddress(String routingAddress) {
        this.routingAddress = routingAddress;
    }

    public String getRoutingAddress() {
        return routingAddress;
    }

    public void setEventRemarks(String eventRemarks) {
        this.eventRemarks = eventRemarks;
    }

    public String getEventRemarks() {
        return eventRemarks;
    }

    public void setExtendInt1(Integer extendInt1) {
        this.extendInt1 = extendInt1;
    }

    public Integer getExtendInt1() {
        return extendInt1;
    }

    public void setExtendInt2(Integer extendInt2) {
        this.extendInt2 = extendInt2;
    }

    public Integer getExtendInt2() {
        return extendInt2;
    }

    public void setExtendInt3(Integer extendInt3) {
        this.extendInt3 = extendInt3;
    }

    public Integer getExtendInt3() {
        return extendInt3;
    }

    public void setExtendStr1(String extendStr1) {
        this.extendStr1 = extendStr1;
    }

    public String getExtendStr1() {
        return extendStr1;
    }

    public void setExtendStr2(String extendStr2) {
        this.extendStr2 = extendStr2;
    }

    public String getExtendStr2() {
        return extendStr2;
    }

    public void setExtendStr3(String extendStr3) {
        this.extendStr3 = extendStr3;
    }

    public String getExtendStr3() {
        return extendStr3;
    }

    public void setExtendjson(String extendjson) {
        this.extendjson = extendjson;
    }

    public String getExtendjson() {
        return extendjson;
    }

    public void setProcdefType(String procdefType) {
        this.procdefType = procdefType;
    }

    public String getProcdefType() {
        return procdefType;
    }

    public void setEventRead(Integer eventRead) {
        this.eventRead = eventRead;
    }

    public Integer getEventRead() {
        return eventRead;
    }

    public void setCameraTypeCode(String cameraTypeCode) {
        this.cameraTypeCode = cameraTypeCode;
    }

    public String getCameraTypeCode() {
        return cameraTypeCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("eventId", getEventId())
                .append("componentId", getComponentId())
                .append("eventIndexCode", getEventIndexCode())
                .append("eventTitle", getEventTitle())
                .append("reportTime", getReportTime())
                .append("eventType", getEventType())
                .append("eventTypeName", getEventTypeName())
                .append("eventCategory", getEventCategory())
                .append("eventCategoryName", getEventCategoryName())
                .append("eventSource", getEventSource())
                .append("eventSourceName", getEventSourceName())
                .append("eventImage", getEventImage())
                .append("eventThumbnailImage", getEventThumbnailImage())
                .append("storageId", getStorageId())
                .append("eventStatus", getEventStatus())
                .append("eventStatusName", getEventStatusName())
                .append("eventAlertStatus", getEventAlertStatus())
                .append("eventAlertStatusName", getEventAlertStatusName())
                .append("eventSubStatus", getEventSubStatus())
                .append("eventSubStatusName", getEventSubStatusName())
                .append("reportType", getReportType())
                .append("reportTypeName", getReportTypeName())
                .append("lawEnforcementType", getLawEnforcementType())
                .append("lawEnforcementTypeName", getLawEnforcementTypeName())
                .append("isView", getIsView())
                .append("timeOut", getTimeOut())
                .append("riskLevel", getRiskLevel())
                .append("currentProcessorId", getCurrentProcessorId())
                .append("currentProcessorName", getCurrentProcessorName())
                .append("eventUpdateTime", getEventUpdateTime())
                .append("eventCreateTime", getEventCreateTime())
                .append("geometry", getGeometry())
                .append("reportPersonId", getReportPersonId())
                .append("reportPersonName", getReportPersonName())
                .append("reportPersonRealName", getReportPersonRealName())
                .append("reportPersonPhone", getReportPersonPhone())
                .append("cameraIndexCode", getCameraIndexCode())
                .append("cameraName", getCameraName())
                .append("responsibilitySubject", getResponsibilitySubject())
                .append("regionIndexCode", getRegionIndexCode())
                .append("regionName", getRegionName())
                .append("placeType", getPlaceType())
                .append("placeTypeName", getPlaceTypeName())
                .append("placeIndexCode", getPlaceIndexCode())
                .append("placeName", getPlaceName())
                .append("companyLegalPerson", getCompanyLegalPerson())
                .append("eventAddress", getEventAddress())
                .append("creditUnionCode", getCreditUnionCode())
                .append("companyContactInformation", getCompanyContactInformation())
                .append("gridName", getGridName())
                .append("gridMan", getGridMan())
                .append("patrolTeam", getPatrolTeam())
                .append("patrolTeamPhone", getPatrolTeamPhone())
                .append("patrolTeam2", getPatrolTeam2())
                .append("patrolTeam2Phone", getPatrolTeam2Phone())
                .append("gridCommunity", getGridCommunity())
                .append("gridContactInformation", getGridContactInformation())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("routingAddress", getRoutingAddress())
                .append("eventRemarks", getEventRemarks())
                .append("extendInt1", getExtendInt1())
                .append("extendInt2", getExtendInt2())
                .append("extendInt3", getExtendInt3())
                .append("extendStr1", getExtendStr1())
                .append("extendStr2", getExtendStr2())
                .append("extendStr3", getExtendStr3())
                .append("extendjson", getExtendjson())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("procdefType", getProcdefType())
                .append("eventRead", getEventRead())
                .append("cameraTypeCode", getCameraTypeCode())
                .toString();
    }
}
