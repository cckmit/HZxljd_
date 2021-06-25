package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;

public class EventSearchVO implements Serializable {

    /**事件ID**/
    private Integer targetId;
    /**警情地址/社区网格信息**/
    private String region;
    /**全局搜索信息**/
    private String contents;
    /**上报平台**/
    private String platCode;
    /**人工or智能上报**/
    private String reportType;
    /**人工or智能上报**/
    private String alertStatus;
    /**是否已读**/
    private String eventReadStatus;
    /**开始上报时间**/
    private String startDate;
    /**截止上报时间**/
    private String endDate;
    /**交办部门ID**/
    private Long assignDeptId;
    /**每页行数**/
    private Integer pageSize;
    /**页数**/
    private Integer pageNum;

    private String[] statusArr;

    private String riskLevel;

    /**是否逾期（0未逾期  1逾期）**/
    private String overdueStatus;

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Long getAssignDeptId() {
        return assignDeptId;
    }

    public void setAssignDeptId(Long assignDeptId) {
        this.assignDeptId = assignDeptId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPlatCode() {
        return platCode;
    }

    public void setPlatCode(String platCode) {
        this.platCode = platCode;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getEventReadStatus() {
        return eventReadStatus;
    }

    public void setEventReadStatus(String eventReadStatus) {
        this.eventReadStatus = eventReadStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus;
    }

    public String[] getStatusArr() {
        return statusArr;
    }

    public void setStatusArr(String[] statusArr) {
        this.statusArr = statusArr;
    }
}
