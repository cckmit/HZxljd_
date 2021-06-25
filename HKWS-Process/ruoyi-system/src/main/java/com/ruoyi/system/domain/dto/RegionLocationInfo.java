package com.ruoyi.system.domain.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain.dto
 * @ClassName: RegionLocationInfo
 * @Author: guohailong
 * @Description: 地区位置信息-地图标记点查询结果类
 * @Date: 2021/3/17 14:07
 * @Version: 1.0
 */
public class RegionLocationInfo implements Serializable {

    /**
     * 地区id
     */
    private Long regionId;

    /**
     * 地区名字
     */
    private String regionName;

    /**
     * 标记点信息
     */
    private String markerPoints;

    /**
     * 上级地区id
     */
    private Long parentRegionId;

    /**
     * 上级地区名称
     */
    private String parentRegionName;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getMarkerPoints() {
        return markerPoints;
    }

    public void setMarkerPoints(String markerPoints) {
        this.markerPoints = markerPoints;
    }

    public Long getParentRegionId() {
        return parentRegionId;
    }

    public void setParentRegionId(Long parentRegionId) {
        this.parentRegionId = parentRegionId;
    }

    public String getParentRegionName() {
        return parentRegionName;
    }

    public void setParentRegionName(String parentRegionName) {
        this.parentRegionName = parentRegionName;
    }

}
