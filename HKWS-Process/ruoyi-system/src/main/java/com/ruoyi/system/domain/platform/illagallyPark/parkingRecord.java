package com.ruoyi.system.domain.platform.illagallyPark;

import java.io.Serializable;

/**
 * Copyright 2021 json.cn
 */
        import java.util.Date;

/**
 * Auto-generated: 2021-05-20 10:28:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class parkingRecord  implements Serializable {

    private String orderNo;
    private String orgName;
    private String lng;
    private String plateNo;
    private Date parkingTime;
    private String parkingAddress;
    private String recordId;
    private String accountId;
    private Date recordTime;
    private String vehicleKind;
    private Date createTime;
    private String name;
    private String plateNoColor;
    private String lat;
    private String status;
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getOrgName() {
        return orgName;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getLng() {
        return lng;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
    public String getPlateNo() {
        return plateNo;
    }

    public void setParkingTime(Date parkingTime) {
        this.parkingTime = parkingTime;
    }
    public Date getParkingTime() {
        return parkingTime;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }
    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }
    public String getRecordId() {
        return recordId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getAccountId() {
        return accountId;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
    public Date getRecordTime() {
        return recordTime;
    }

    public void setVehicleKind(String vehicleKind) {
        this.vehicleKind = vehicleKind;
    }
    public String getVehicleKind() {
        return vehicleKind;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPlateNoColor(String plateNoColor) {
        this.plateNoColor = plateNoColor;
    }
    public String getPlateNoColor() {
        return plateNoColor;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLat() {
        return lat;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

}
