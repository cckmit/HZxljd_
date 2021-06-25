package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;

/**
 * 一事一档事件列表返回字段
 */
public class HkEventThingVo implements Serializable {


    /**事件标题**/
    private Integer id;
    /**事件标题**/
    @Excel(name = "事件标题")
    private String eventTitle;
    /**事件类型**/
    @Excel(name = "事件类型")
    private String eventType;
    /**事件上报时间**/
    @Excel(name = "上报平台", readConverterExp = "1001=智慧城管,1002=应急管理,1003=综合治理,1004=青山云,1010=青和治")
    private String reportTime;
    /**事件上报类型**/
    @Excel(name = "上报类型")
    private String reportType;
    /**所属社区**/
    @Excel(name = "所属社区")
    private String regionName;
    /**事件地址**/
    @Excel(name = "事件地址")
    private String eventAddress;
    /**事件状态**/
    @Excel(name = "当前节点",readConverterExp = "2=研判中,3=已调度,4=退回,5=已签收,6=已完结,7=已忽略,8=异常关闭,9=系统自动完成")
    private String eventAlertType;
    /**调度时间**/
    @Excel(name = "调度时间")
    private String dispatchTime;
    /**签收时间**/
    @Excel(name = "签收时间")
    private String signTime;
    /**完结时间**/
    @Excel(name = "完结时间")
    private String doneTime;
    /**事件处置状态**/
    @Excel(name = "处置方式",readConverterExp = "3=中心处置,4=系统处置,5=人工处置")
    private String eventStatus;
    /**事件流转时间**/
    private String processTime;
    /**事件处置人**/
    @Excel(name = "事件处置人")
    private String processUserName;
    /**事件创建时间**/
    @Excel(name = "事件创建时间")
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getProcessUserName() {
        return processUserName;
    }

    public void setProcessUserName(String processUserName) {
        this.processUserName = processUserName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(String doneTime) {
        this.doneTime = doneTime;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventAlertType() {
        return eventAlertType;
    }

    public void setEventAlertType(String eventAlertType) {
        this.eventAlertType = eventAlertType;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
