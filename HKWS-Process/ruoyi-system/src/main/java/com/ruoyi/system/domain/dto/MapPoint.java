package com.ruoyi.system.domain.dto;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.common.utils.map
 * @ClassName: MapPoint
 * @Author: guohailong
 * @Description: 地图点对象
 * @Date: 2021/3/14 23:36
 * @Version: 1.0
 */
public class MapPoint {

    private Double longitude;
    private Double latitude;

    public MapPoint(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
