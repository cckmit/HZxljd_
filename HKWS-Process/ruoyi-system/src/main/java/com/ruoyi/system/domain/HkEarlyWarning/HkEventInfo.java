package com.ruoyi.system.domain.HkEarlyWarning;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.HkLmanagement;
import com.ruoyi.system.domain.HkLmanagementInfo;

/**
 * @author FanKaibiao
 * @date 2020-11-03-16:03
 * 预警详情表
 */
public class HkEventInfo extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * 更新人
     */
    private String updateUser;

	/**
     * 自增id
     */
    private Integer id;
    /**
     * uuid
     */

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
     *所属组织编码
     */
    private Integer eventCategory;
    /**
     * 所属组织名称
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
     *事件状态值（1未审核  2已审核  3中心处理  4机器处理 5人工处理）
     */
    private Integer eventStatus;
    /**
     *事件状态名称（未审核  已审核  中心处理  机器处理  人工处理）
     */
    private String eventStatusName;
    /**
     * 事件状态(1:预警 2:研判中 3:调度中 4:已退回 5:处置 6:完结,7已忽略 8:已关闭 9系统自动完成)
     */
    private Integer eventAlertStatus;
    /**
     * 事件状态(预警,研判中,调度中,签收,处置,完结 已忽略  已关闭 系统自动完成)
     */
    private String eventAlertStatusName;
    /**
     *事件子类型值
     */
    private String eventSubStatus;
    /**
     *事件子类型名称
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
     * 是否查看
     */
    private Integer isView;
    /**
     *事件超时时间
     */
    private Date timeOut;
    private String timeOutEnd;
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
     *事件更新时间
     */
    private String eventUpdateTime;
    //事件天数时间
    private String eventCreateTime;
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
     * 上报事件设备类型(物联网设备类型)
     */
    private String cameraTypeCode;
    /**
     *责任主体
     */
    private String responsibilitySubject;
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
     *警情地址
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
    private String createDate;
    /**
     *修改时间
     */
    private Date updateTime;

    private String date;

    private String dateNow;

    private String procdefType;

    /** 申请人姓名 */
    private String applyUserName;

    /** 任务ID */
    private String taskId;

    /** 任务名称 */
    private String taskName;

    /** 办理时间 */
    private Date doneTime;

    /** 创建人 */
    private String createUserName;

    /** 流程实例状态 1 激活 2 挂起 */
    private String suspendState;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 0未读  1已读
     */
    private Integer eventRead;
    /**
     * 备注(忽略或关闭原因)
     */
    private String eventRemarks;
    /**
     * 指派的人
     */
    private String todoUserName;
    /**
     * 指派时间
     */
    private String todoTime;
    private String HandlerOrder;

    private List<Map<String,Object>> listMap;

    private Integer count;
    //待处理数量
    private Integer pendingCount;
    //已完成数量
    private Integer endCount;
    //已逾期数量
    private Integer overdueCount;

    //签收时间
    private String signTime;

    /**事件退回前状态**/
    private String beforeBackStatus;

    /**重复事件校验时间**/
    private String repeatTime;

    /**交办部门集合 （,组合）**/
    private String assignDeptId;
    /**交办操作人**/
    private String assignOperator;
    /**交办原因**/
    private String assignReason;
    /**交办时间**/
    private Date assignTime;
    /**违停机动车牌号**/
    private String plateNo;
    /**确认警情时间**/
    private Date dispatchEventTime;
    /**确认警情操作人**/
    private Integer dispatchEventUser;
    /**标签列表**/
    List<HkLmanagementInfo> hkLmanagements;
    /**事件处置图片集合**/
    List<Map<String,String>> picList;

    private String regionDetail;
    //评价
    private Integer evaluate;

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Date getDispatchEventTime() {
        return dispatchEventTime;
    }

    public void setDispatchEventTime(Date dispatchEventTime) {
        this.dispatchEventTime = dispatchEventTime;
    }

    public Integer getDispatchEventUser() {
        return dispatchEventUser;
    }

    public void setDispatchEventUser(Integer dispatchEventUser) {
        this.dispatchEventUser = dispatchEventUser;
    }

    public String getRegionDetail() {
        return regionDetail;
    }

    public void setRegionDetail(String regionDetail) {
        this.regionDetail = regionDetail;
    }

    public List<Map<String, String>> getPicList() {
        return picList;
    }

    public void setPicList(List<Map<String, String>> picList) {
        this.picList = picList;
    }

    public List<HkLmanagementInfo> getHkLmanagements() {
        return hkLmanagements;
    }

    public void setHkLmanagements(List<HkLmanagementInfo> hkLmanagements) {
        this.hkLmanagements = hkLmanagements;
    }

    public String getAssignDeptId() {
        return assignDeptId;
    }

    public void setAssignDeptId(String assignDeptId) {
        this.assignDeptId = assignDeptId;
    }

    public String getAssignOperator() {
        return assignOperator;
    }

    public void setAssignOperator(String assignOperator) {
        this.assignOperator = assignOperator;
    }

    public String getAssignReason() {
        return assignReason;
    }

    public void setAssignReason(String assignReason) {
        this.assignReason = assignReason;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public String getRepeatTime() {
        return repeatTime;
    }

    public void setRepeatTime(String repeatTime) {
        this.repeatTime = repeatTime;
    }

    public String getBeforeBackStatus() {
        return beforeBackStatus;
    }

    public void setBeforeBackStatus(String beforeBackStatus) {
        this.beforeBackStatus = beforeBackStatus;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getCameraTypeCode() {
        return cameraTypeCode;
    }

    public void setCameraTypeCode(String cameraTypeCode) {
        this.cameraTypeCode = cameraTypeCode;
    }

    public String getEventCreateTime() {
        return eventCreateTime;
    }

    public void setEventCreateTime(String eventCreateTime) {
        this.eventCreateTime = eventCreateTime;
    }

    public String getTimeOutEnd() {
        return timeOutEnd;
    }

    public void setTimeOutEnd(String timeOutEnd) {
        this.timeOutEnd = timeOutEnd;
    }

    public Integer getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(Integer overdueCount) {
        this.overdueCount = overdueCount;
    }

    public Integer getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(Integer pendingCount) {
        this.pendingCount = pendingCount;
    }

    public Integer getEndCount() {
        return endCount;
    }

    public void setEndCount(Integer endCount) {
        this.endCount = endCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Map<String, Object>> getListMap() {
        return listMap;
    }

    public void setListMap(List<Map<String, Object>> listMap) {
        this.listMap = listMap;
    }

    public String getHandlerOrder() {
        return HandlerOrder;
    }

    public void setHandlerOrder(String handlerOrder) {
        HandlerOrder = handlerOrder;
    }

    public String getTodoUserName() {
        return todoUserName;
    }

    public void setTodoUserName(String todoUserName) {
        this.todoUserName = todoUserName;
    }

    public String getTodoTime() {
        return todoTime;
    }

    public void setTodoTime(String todoTime) {
        this.todoTime = todoTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEventRemarks() {
        return eventRemarks;
    }

    public void setEventRemarks(String eventRemarks) {
        this.eventRemarks = eventRemarks;
    }

    public Integer getEventRead() {
        return eventRead;
    }

    public void setEventRead(Integer eventRead) {
        this.eventRead = eventRead;
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

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getSuspendState() {
        return suspendState;
    }

    public void setSuspendState(String suspendState) {
        this.suspendState = suspendState;
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

    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public HkEventInfo() {
    }

    @Override
    public String toString() {
        return "HkEventInfo{" +
                "id=" + id +
                ", eventId='" + eventId + '\'' +
                ", componentId='" + componentId + '\'' +
                ", eventIndexCode='" + eventIndexCode + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventTypeName='" + eventTypeName + '\'' +
                ", eventCategory=" + eventCategory +
                ", eventCategoryName='" + eventCategoryName + '\'' +
                ", eventSource=" + eventSource +
                ", eventSourceName='" + eventSourceName + '\'' +
                ", eventImage='" + eventImage + '\'' +
                ", eventThumbnailImage='" + eventThumbnailImage + '\'' +
                ", storageId='" + storageId + '\'' +
                ", eventStatus=" + eventStatus +
                ", eventStatusName='" + eventStatusName + '\'' +
                ", eventAlertStatus=" + eventAlertStatus +
                ", eventAlertStatusName='" + eventAlertStatusName + '\'' +
                ", eventSubStatus=" + eventSubStatus +
                ", eventSubStatusName='" + eventSubStatusName + '\'' +
                ", reportType=" + reportType +
                ", reportTypeName='" + reportTypeName + '\'' +
                ", lawEnforcementType=" + lawEnforcementType +
                ", lawEnforcementTypeName='" + lawEnforcementTypeName + '\'' +
                ", isView=" + isView +
                ", timeOut=" + timeOut +
                ", riskLevel='" + riskLevel + '\'' +
                ", currentProcessorId='" + currentProcessorId + '\'' +
                ", currentProcessorName='" + currentProcessorName + '\'' +
                ", eventUpdateTime='" + eventUpdateTime + '\'' +
                ", geometry='" + geometry + '\'' +
                ", reportPersonId='" + reportPersonId + '\'' +
                ", reportPersonName='" + reportPersonName + '\'' +
                ", reportPersonRealName='" + reportPersonRealName + '\'' +
                ", reportPersonPhone='" + reportPersonPhone + '\'' +
                ", cameraIndexCode='" + cameraIndexCode + '\'' +
                ", cameraName='" + cameraName + '\'' +
                ", responsibilitySubject='" + responsibilitySubject + '\'' +
                ", regionIndexCode='" + regionIndexCode + '\'' +
                ", regionName='" + regionName + '\'' +
                ", placeType='" + placeType + '\'' +
                ", placeTypeName='" + placeTypeName + '\'' +
                ", placeIndexCode='" + placeIndexCode + '\'' +
                ", placeName='" + placeName + '\'' +
                ", companyLegalPerson='" + companyLegalPerson + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", creditUnionCode='" + creditUnionCode + '\'' +
                ", companyContactInformation='" + companyContactInformation + '\'' +
                ", gridName='" + gridName + '\'' +
                ", gridMan='" + gridMan + '\'' +
                ", patrolTeam='" + patrolTeam + '\'' +
                ", patrolTeamPhone='" + patrolTeamPhone + '\'' +
                ", patrolTeam2='" + patrolTeam2 + '\'' +
                ", patrolTeam2Phone='" + patrolTeam2Phone + '\'' +
                ", gridCommunity='" + gridCommunity + '\'' +
                ", gridContactInformation='" + gridContactInformation + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", routingAddress='" + routingAddress + '\'' +
                ", extendInt1=" + extendInt1 +
                ", extendInt2=" + extendInt2 +
                ", extendInt3=" + extendInt3 +
                ", extendStr1='" + extendStr1 + '\'' +
                ", extendStr2='" + extendStr2 + '\'' +
                ", extendStr3='" + extendStr3 + '\'' +
                ", extendJson='" + extendJson + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", date='" + date + '\'' +
                ", dateNow='" + dateNow + '\'' +
                ", procdefType='" + procdefType + '\'' +
                ", applyUserName='" + applyUserName + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", doneTime=" + doneTime +
                ", createUserName='" + createUserName + '\'' +
                ", suspendState='" + suspendState + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", eventRead=" + eventRead +
                ", eventRemarks='" + eventRemarks + '\'' +
                '}';
    }
}
