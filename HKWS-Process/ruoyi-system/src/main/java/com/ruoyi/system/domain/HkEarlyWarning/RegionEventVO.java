package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一域一档-社区检测VO
 */
public class RegionEventVO {

    /**
     * 社区检测名称
     */
    private String regionName;

    /**
     * 社区检测-店铺事件发生数
     */
    private Integer regionStreetCount;

    /**
     * 社区检测-街道事件发生数
     */
    private Integer regionShopCount;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionStreetCount() {
        return regionStreetCount;
    }

    public void setRegionStreetCount(Integer regionStreetCount) {
        this.regionStreetCount = regionStreetCount;
    }

    public Integer getRegionShopCount() {
        return regionShopCount;
    }

    public void setRegionShopCount(Integer regionShopCount) {
        this.regionShopCount = regionShopCount;
    }
}
