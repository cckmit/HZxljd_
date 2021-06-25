package com.ruoyi.system.domain.platform.hkManCar.hkResidentialHours;

/**
 * @author FanKaibiao
 * @date 2021-06-01-14:41
 */
/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-06-01 14:39:34
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class HouseInfoObject implements Serializable {

    private String HouseID;
    private int BuildingNo;
    private int Unit;
    private int Floor;
    private String GateHouseNo;
    private String LivingType;
    private String HouseName;
    private String CommunityID;
    private String DataSourceID;
    private int DataStatus;
    public void setHouseID(String HouseID) {
        this.HouseID = HouseID;
    }
    public String getHouseID() {
        return HouseID;
    }

    public void setBuildingNo(int BuildingNo) {
        this.BuildingNo = BuildingNo;
    }
    public int getBuildingNo() {
        return BuildingNo;
    }

    public void setUnit(int Unit) {
        this.Unit = Unit;
    }
    public int getUnit() {
        return Unit;
    }

    public void setFloor(int Floor) {
        this.Floor = Floor;
    }
    public int getFloor() {
        return Floor;
    }

    public void setGateHouseNo(String GateHouseNo) {
        this.GateHouseNo = GateHouseNo;
    }
    public String getGateHouseNo() {
        return GateHouseNo;
    }

    public void setLivingType(String LivingType) {
        this.LivingType = LivingType;
    }
    public String getLivingType() {
        return LivingType;
    }

    public void setHouseName(String HouseName) {
        this.HouseName = HouseName;
    }
    public String getHouseName() {
        return HouseName;
    }

    public void setCommunityID(String CommunityID) {
        this.CommunityID = CommunityID;
    }
    public String getCommunityID() {
        return CommunityID;
    }

    public void setDataSourceID(String DataSourceID) {
        this.DataSourceID = DataSourceID;
    }
    public String getDataSourceID() {
        return DataSourceID;
    }

    public void setDataStatus(int DataStatus) {
        this.DataStatus = DataStatus;
    }
    public int getDataStatus() {
        return DataStatus;
    }

}
