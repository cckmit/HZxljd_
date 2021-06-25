package com.ruoyi.system.domain.platform.hkManCar.hkFaceCapture;

/**
 * @author FanKaibiao
 * @date 2021-05-27-19:55
 */
/**
 * Copyright 2021 json.cn
 */

/**
 * Auto-generated: 2021-05-27 19:52:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class FaceObject {

    private String FaceID;
    private int InfoKind;
    private String SourceID;
    private String DeviceID;
    private String FaceAppearTime;
    private SubImageList SubImageList;
    private String CommunityID;
    private String DataSourceID;
    public void setFaceID(String FaceID) {
        this.FaceID = FaceID;
    }
    public String getFaceID() {
        return FaceID;
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

    public void setDeviceID(String DeviceID) {
        this.DeviceID = DeviceID;
    }
    public String getDeviceID() {
        return DeviceID;
    }

    public void setFaceAppearTime(String FaceAppearTime) {
        this.FaceAppearTime = FaceAppearTime;
    }
    public String getFaceAppearTime() {
        return FaceAppearTime;
    }

    public void setSubImageList(SubImageList SubImageList) {
        this.SubImageList = SubImageList;
    }
    public SubImageList getSubImageList() {
        return SubImageList;
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