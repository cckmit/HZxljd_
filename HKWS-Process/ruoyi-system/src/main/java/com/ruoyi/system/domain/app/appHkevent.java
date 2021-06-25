package com.ruoyi.system.domain.app;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: data-ruoyi
 * @description: app-事件详情概要
 * @author: Yang-Teng-Fei
 * @create: 2020-12-10 12:46
 **/
public class appHkevent implements Serializable {

    /**事件状态 */
    private Integer eventAlertStatus;

    private String componentId;
    /**事件id */
    private String eventId;
    /**事件类型 */
    private String eventType;
    /**事件类型名称 */
    private String eventTypeName;
    /**事件标题 */
    private String eventTitle;

    /**事件唯一标识 */
    private String eventIndexCode;

    /**事件地址 */
    private String gridCommunity;
    /*事件地址*/
    private String eventAddress;
    /**场所类型 */
    private String  placeType;
    /**场所名称 */
    private String placeTypeName;
    /**图片存储设备id*/
    private String storageId;
    /**事件图片地址 */
    private String eventImage;
    /**事件上报时间 */
    private String reportTime;
    /**所属区域 */
    private String regionCode;
    /**所属区域 */
    private String regionName;
    /**逾期时间 */
    private Date timeOut;

    private Date createTime;

    private Date updateTime;
    /**计算待处理时间 */
    private Integer pengTime;
    /**计算已逾期时间 */
    private Integer overTime;

    private String cameraName;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public Integer getPengTime() {
        return pengTime;
    }

    public void setPengTime(Integer pengTime) {
        this.pengTime = pengTime;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getEventAlertStatus() {
        return eventAlertStatus;
    }

    public void setEventAlertStatus(Integer eventAlertStatus) {
        this.eventAlertStatus = eventAlertStatus;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventIndexCode() {
        return eventIndexCode;
    }

    public void setEventIndexCode(String eventIndexCode) {
        this.eventIndexCode = eventIndexCode;
    }

    public String getGridCommunity() {
        return gridCommunity;
    }

    public void setGridCommunity(String gridCommunity) {
        this.gridCommunity = gridCommunity;
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

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }
}
