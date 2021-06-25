package com.ruoyi.system.domain.app;

import java.io.Serializable;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-12-16 21:11
 **/
public class appReportEvent implements Serializable {

    /**事件状态 */
    private Integer eventAlertStatus;
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
    private String eventAddress;
    /**场所类型 */
    private String  placeType;
    /**场所名称 */
    private String placeTypeName;
    /**事件图片地址 */
    private String eventImage;
    /**事件上报时间 */
    private String reportTime;
    /**所属区域 */
    private String regionName;
    /**事件发生的区域标识  */
    private String regionIndexCode;
    /**事件上报类型（1智能上报，2人工上报） */
    private Integer reportType;
    /**事件上报类型名称（人工上报，智能上报） */
    private String reportTypeName;
    /**场所名称 */
    private String placeName;
    /**上报意见 */
    private String eventRemarks;

    public String getEventRemarks() {
        return eventRemarks;
    }

    public void setEventRemarks(String eventRemarks) {
        this.eventRemarks = eventRemarks;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getEventAlertStatus() {
        return eventAlertStatus;
    }

    public void setEventAlertStatus(Integer eventAlertStatus) {
        this.eventAlertStatus = eventAlertStatus;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
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

    public String getRegionIndexCode() {
        return regionIndexCode;
    }

    public void setRegionIndexCode(String regionIndexCode) {
        this.regionIndexCode = regionIndexCode;
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
}
