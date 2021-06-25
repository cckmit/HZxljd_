package com.ruoyi.system.domain.HkEarlyWarning;

import java.io.Serializable;

public class HkEventFourVo implements Serializable {

    /**起始完结时间**/
    private String startDoneDate;
    /**截至完结时间**/
    private String endDoneDate;
    /**起始创建时间**/
    private String beginCreateTime;
    /**截至创建时间**/
    private String endCreateDate;
    /**事件状态**/
    private String eventAlertStatus;

    private String dayType;
    /**部门ID**/
    private String deptId;
    /**部门名称**/
    private String deptName;
    /**职能id**/
    private String postId;
    /**社区id**/
    private String regionId;
    /**社区名称**/
    private String regionName;
    /**网格员id**/
    private String userId;

    private String userName;
    /**是否共治 1共治**/
    private String isGovernance;
    /**当天**/
    private String currentDate;
    /**本周**/
    private String trendWeekMonday;
    /**本月**/
    private String trendMonthMonday;
    /**事件类型**/
    private String eventType;
    /**事件状态集合**/
    private String[] statusArr;
    /**事件处置记录操作状态**/
    private String[] processStatusArr;
    /**网格员职能**/
    private String[] postArr;
    /**当前页数**/
    private Integer pageNum = 1;
    /**页面行数**/
    private Integer pageSize = 10;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String[] getPostArr() {
        return postArr;
    }

    public void setPostArr(String[] postArr) {
        this.postArr = postArr;
    }

    public String[] getProcessStatusArr() {
        return processStatusArr;
    }

    public void setProcessStatusArr(String[] processStatusArr) {
        this.processStatusArr = processStatusArr;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEventAlertStatus() {
        return eventAlertStatus;
    }

    public void setEventAlertStatus(String eventAlertStatus) {
        this.eventAlertStatus = eventAlertStatus;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getTrendWeekMonday() {
        return trendWeekMonday;
    }

    public void setTrendWeekMonday(String trendWeekMonday) {
        this.trendWeekMonday = trendWeekMonday;
    }

    public String getTrendMonthMonday() {
        return trendMonthMonday;
    }

    public void setTrendMonthMonday(String trendMonthMonday) {
        this.trendMonthMonday = trendMonthMonday;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getStartDoneDate() {
        return startDoneDate;
    }

    public void setStartDoneDate(String startDoneDate) {
        this.startDoneDate = startDoneDate;
    }

    public String getEndDoneDate() {
        return endDoneDate;
    }

    public void setEndDoneDate(String endDoneDate) {
        this.endDoneDate = endDoneDate;
    }

    public String getBeginCreateTime() {
        return beginCreateTime;
    }

    public void setBeginCreateTime(String beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public String getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(String endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public String[] getStatusArr() {
        return statusArr;
    }

    public void setStatusArr(String[] statusArr) {
        this.statusArr = statusArr;
    }

    public String getIsGovernance() {
        return isGovernance;
    }

    public void setIsGovernance(String isGovernance) {
        this.isGovernance = isGovernance;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
