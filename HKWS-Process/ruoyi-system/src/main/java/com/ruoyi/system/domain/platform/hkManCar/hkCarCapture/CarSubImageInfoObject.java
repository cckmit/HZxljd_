package com.ruoyi.system.domain.platform.hkManCar.hkCarCapture;


/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-05-27 20:10:27
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class CarSubImageInfoObject implements Serializable {

    private String ImageID;
    private String ImageSource;
    private String DeviceID;
    private String StoragePath;
    private String FileFormat;
    private String ShotTime;
    private String Type;
    private int Width;
    private int Height;
    private String Data;
    public void setImageID(String ImageID) {
        this.ImageID = ImageID;
    }
    public String getImageID() {
        return ImageID;
    }

    public void setImageSource(String ImageSource) {
        this.ImageSource = ImageSource;
    }
    public String getImageSource() {
        return ImageSource;
    }

    public void setDeviceID(String DeviceID) {
        this.DeviceID = DeviceID;
    }
    public String getDeviceID() {
        return DeviceID;
    }

    public void setStoragePath(String StoragePath) {
        this.StoragePath = StoragePath;
    }
    public String getStoragePath() {
        return StoragePath;
    }

    public void setFileFormat(String FileFormat) {
        this.FileFormat = FileFormat;
    }
    public String getFileFormat() {
        return FileFormat;
    }

    public void setShotTime(String ShotTime) {
        this.ShotTime = ShotTime;
    }
    public String getShotTime() {
        return ShotTime;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    public String getType() {
        return Type;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }
    public int getWidth() {
        return Width;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }
    public int getHeight() {
        return Height;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
    public String getData() {
        return Data;
    }

}
