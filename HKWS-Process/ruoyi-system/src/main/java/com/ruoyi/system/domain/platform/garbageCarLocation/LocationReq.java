package com.ruoyi.system.domain.platform.garbageCarLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author cui
 * @version 1.0
 * @date 2021-04-06
 */
public class LocationReq {

    /**
     * 车牌号颜色(接口约定，统一蓝牌)
     * 1：蓝牌
     * 2：黄牌
     */
    @JsonIgnore
    private Integer licensePlateType;

    public Integer getLicensePlateType() {
        return 1; //(接口约定，统一蓝牌)
    }

    /**
     * 车牌号
     */
    @NotEmpty
    private String licensePlate;

    /**
     * 定位设备号
     */
    private String locationSim;

    /**
     * 定位-经度(约定-GCJ02坐标系)
     */
    @NotNull
    private String lng;

    /**
     * 定位-维度(约定-GCJ02坐标系)
     */
    @NotNull
    private String lat;

    /**
     * 高程
     */
    private Integer height;

    /**
     * 速度
     */
    private String speed;

    /**
     * 方向
     */
    private Integer direction;

    /**
     * 定位时间(yyyy-MM-dd hh:mm:ss ex:2021-03-06 12:30:25)
     */
    @NotEmpty
    private String locationTime;

    public void setLicensePlateType(Integer licensePlateType) {
        this.licensePlateType = licensePlateType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLocationSim() {
        return locationSim;
    }

    public void setLocationSim(String locationSim) {
        this.locationSim = locationSim;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }
}
