package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一域一档 事件分析
 */
public class RegionEventAnalysisVO {

    /**
     *  事件数
     */
    private Integer eventCount;

    /**
     * 社区名称
     */
    private String  regionName;

    /**
     * 事件率
     */
    private Double eventRate;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Double getEventRate() {
        return eventRate;
    }

    public void setEventRate(Double eventRate) {
        this.eventRate = eventRate;
    }
}
