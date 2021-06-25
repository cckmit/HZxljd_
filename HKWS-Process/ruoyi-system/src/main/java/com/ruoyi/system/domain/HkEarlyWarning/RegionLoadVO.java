package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一域一档-社区负荷VO
 */
public class RegionLoadVO {

    /**
     * 负荷社区名称
     */
    private String regionName;

    /**
     * 负荷量
     */
    private Double regionLoadCount;

    /**
     * 事件数
     */
    private Integer eventCount;

    /**
     * 社区工作人员数
     */
    private Integer userCount;

    /**
     * 社区名称
     */
    private String deptName;

    /*社区数量*/
    private Integer regionCount;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Double getRegionLoadCount() {
        return regionLoadCount;
    }

    public void setRegionLoadCount(Double regionLoadCount) {
        this.regionLoadCount = regionLoadCount;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getRegionCount() {
        return regionCount;
    }

    public void setRegionCount(Integer regionCount) {
        this.regionCount = regionCount;
    }
}
