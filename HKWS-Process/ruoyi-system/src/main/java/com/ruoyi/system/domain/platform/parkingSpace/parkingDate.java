package com.ruoyi.system.domain.platform.parkingSpace;

/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-05-26 15:24:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class parkingDate implements Serializable {

    private String parkCode;
    private String parkName;
    private String address;
    private double lat;
    private double lng;
    private String isOp;
    private int totalLots;
    private int currentLots;
    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }
    public String getParkCode() {
        return parkCode;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
    public String getParkName() {
        return parkName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLat() {
        return lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    public double getLng() {
        return lng;
    }

    public void setIsOp(String isOp) {
        this.isOp = isOp;
    }
    public String getIsOp() {
        return isOp;
    }

    public void setTotalLots(int totalLots) {
        this.totalLots = totalLots;
    }
    public int getTotalLots() {
        return totalLots;
    }

    public void setCurrentLots(int currentLots) {
        this.currentLots = currentLots;
    }
    public int getCurrentLots() {
        return currentLots;
    }

}
