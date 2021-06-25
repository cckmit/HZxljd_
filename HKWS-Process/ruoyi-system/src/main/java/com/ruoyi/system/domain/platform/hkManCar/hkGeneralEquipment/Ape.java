package com.ruoyi.system.domain.platform.hkManCar.hkGeneralEquipment;


/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-05-27 19:44:43
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Ape implements Serializable {

    private String ApeID;
    private String Name;
    private double Longtitude;
    private double Latitue;
    private String Place;
    private String IsOnline;
    private int FaceCapDirection;
    private int PositionDetailType;
    private String CommunityID;
    private String DataSourceID;
    public void setApeID(String ApeID) {
        this.ApeID = ApeID;
    }
    public String getApeID() {
        return ApeID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }

    public void setLongtitude(double Longtitude) {
        this.Longtitude = Longtitude;
    }
    public double getLongtitude() {
        return Longtitude;
    }

    public void setLatitue(double Latitue) {
        this.Latitue = Latitue;
    }
    public double getLatitue() {
        return Latitue;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }
    public String getPlace() {
        return Place;
    }

    public void setIsOnline(String IsOnline) {
        this.IsOnline = IsOnline;
    }
    public String getIsOnline() {
        return IsOnline;
    }

    public void setFaceCapDirection(int FaceCapDirection) {
        this.FaceCapDirection = FaceCapDirection;
    }
    public int getFaceCapDirection() {
        return FaceCapDirection;
    }

    public void setPositionDetailType(int PositionDetailType) {
        this.PositionDetailType = PositionDetailType;
    }
    public int getPositionDetailType() {
        return PositionDetailType;
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

}
