package com.ruoyi.system.domain.platform.hkManCar.hkCarCapture;

/**
 * @author FanKaibiao
 * @date 2021-05-27-20:07
 */
/**
 * Copyright 2021 json.cn
 */

import com.ruoyi.system.domain.platform.hkManCar.hkFaceCapture.SubImageList;

import java.io.Serializable;

/**
 * Auto-generated: 2021-05-27 20:5:9
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class MotorVehicleObject implements Serializable {

    private String MotorVehicleID;
    private int InfoKind;
    private String SourceID;
    private String StorageUrl1;
    private String StorageUrl2;
    private String AppearTime;
    private String HasPlate;
    private String PlateClass;
    private String PlateNo;
    private CarSubImageList SubImageList;
    private int IsMotorVehicleReg;
    private String CommunityID;
    private String DataSourceID;
    private int Direction;
    private String CapCameraID;
    public void setMotorVehicleID(String MotorVehicleID) {
        this.MotorVehicleID = MotorVehicleID;
    }
    public String getMotorVehicleID() {
        return MotorVehicleID;
    }

    public void setInfoKind(int InfoKind) {
        this.InfoKind = InfoKind;
    }
    public int getInfoKind() {
        return InfoKind;
    }

    public void setSourceID(String SourceID) {
        this.SourceID = SourceID;
    }
    public String getSourceID() {
        return SourceID;
    }

    public void setStorageUrl1(String StorageUrl1) {
        this.StorageUrl1 = StorageUrl1;
    }
    public String getStorageUrl1() {
        return StorageUrl1;
    }

    public void setStorageUrl2(String StorageUrl2) {
        this.StorageUrl2 = StorageUrl2;
    }
    public String getStorageUrl2() {
        return StorageUrl2;
    }

    public void setAppearTime(String AppearTime) {
        this.AppearTime = AppearTime;
    }
    public String getAppearTime() {
        return AppearTime;
    }

    public void setHasPlate(String HasPlate) {
        this.HasPlate = HasPlate;
    }
    public String getHasPlate() {
        return HasPlate;
    }

    public void setPlateClass(String PlateClass) {
        this.PlateClass = PlateClass;
    }
    public String getPlateClass() {
        return PlateClass;
    }

    public void setPlateNo(String PlateNo) {
        this.PlateNo = PlateNo;
    }
    public String getPlateNo() {
        return PlateNo;
    }

    public CarSubImageList getSubImageList() {
        return SubImageList;
    }

    public void setSubImageList(CarSubImageList subImageList) {
        SubImageList = subImageList;
    }

    public void setIsMotorVehicleReg(int IsMotorVehicleReg) {
        this.IsMotorVehicleReg = IsMotorVehicleReg;
    }
    public int getIsMotorVehicleReg() {
        return IsMotorVehicleReg;
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

    public void setDirection(int Direction) {
        this.Direction = Direction;
    }
    public int getDirection() {
        return Direction;
    }

    public void setCapCameraID(String CapCameraID) {
        this.CapCameraID = CapCameraID;
    }
    public String getCapCameraID() {
        return CapCameraID;
    }

}
