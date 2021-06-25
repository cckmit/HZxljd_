package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;

import java.io.Serializable;

/**
 * 一人一档事件列表返回字段
 */
public class HkEventPersonVo implements Serializable {

    /**用户ID**/
    private String userId;
    /**用户名**/
    @Excel(name="用户姓名")
    private String userName;
    /**所属部门**/
    @Excel(name="部门")
    private String deptName;
    /**所属社区**/
    private String regionName;
    /**处置事件数量**/
    @Excel(name="处置事件总数（件）")
    private Integer eventCount;
    /**正在处置数量**/
    @Excel(name="正在处置数量（件）")
    private Integer doingCount;
    /**正在处置数量**/
    @Excel(name="待签收数量（件）")
    private Integer noSignCount;
    /*总时长*/
    @Excel(name="总时长")
    private String totalTime;
    /*平均时长*/
    @Excel(name="平均时长")
    private String averageTime;
    /*用户岗位*/
    private String userPost;

    public Integer getNoSignCount() {
        return noSignCount;
    }

    public void setNoSignCount(Integer noSignCount) {
        this.noSignCount = noSignCount;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(String averageTime) {
        this.averageTime = averageTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getDoingCount() {
        return doingCount;
    }

    public void setDoingCount(Integer doingCount) {
        this.doingCount = doingCount;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
