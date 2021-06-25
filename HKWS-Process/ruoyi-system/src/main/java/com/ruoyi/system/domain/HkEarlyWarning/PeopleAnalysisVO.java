package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一人一档
 */
public class PeopleAnalysisVO {

    /**用户ID**/
    private Long userId;

    /**用户姓名**/
    private String userName;

    /**平均事件时长*/
    private Integer eventAvgCount;

    /**用户事件总数**/
    private Integer eventCount;

    /**用户平均时长**/
    private Integer userAvgHour;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getEventAvgCount() {
        return eventAvgCount;
    }

    public void setEventAvgCount(Integer eventAvgCount) {
        this.eventAvgCount = eventAvgCount;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getUserAvgHour() {
        return userAvgHour;
    }

    public void setUserAvgHour(Integer userAvgHour) {
        this.userAvgHour = userAvgHour;
    }
}
