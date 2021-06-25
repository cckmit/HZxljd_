package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 稠城云图-社区报表-近七日社区事件VO
 */
public class EventDisposalEfficiencyVO {

    /**
     * 社区告警数
     */
    private Integer eventCount;

    /**
     * 社区名称
     */
    private String deptName;

    /**
     * 处置率
     */
    private Double achieveRate;

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getAchieveRate() {
        return achieveRate;
    }

    public void setAchieveRate(Double achieveRate) {
        this.achieveRate = achieveRate;
    }
}
