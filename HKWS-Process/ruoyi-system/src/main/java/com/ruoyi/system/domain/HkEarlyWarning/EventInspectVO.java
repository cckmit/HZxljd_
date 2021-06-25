package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一事一档-社区检测VO
 */
public class EventInspectVO {

    private String regionCode;
    /**
     * 社区名称
     */
    private String regionName;
    /**
     * 事件统计数
     */
    private Integer eventCount;

    /**流转率**/
    private String transferRate;

    /**共治率**/
    private String governanceRate;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTransferRate() {
        return transferRate==null?"0.00":transferRate;
    }

    public void setTransferRate(String transferRate) {
        this.transferRate = transferRate;
    }

    public String getGovernanceRate() {
        return governanceRate==null?"0.00":governanceRate;
    }

    public void setGovernanceRate(String governanceRate) {
        this.governanceRate = governanceRate;
    }

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
}
