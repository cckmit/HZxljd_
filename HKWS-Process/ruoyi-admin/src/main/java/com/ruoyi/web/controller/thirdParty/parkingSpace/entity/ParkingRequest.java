package com.ruoyi.web.controller.thirdParty.parkingSpace.entity;

import java.io.Serializable;

/**
 * WorkOrderReq
 *
 * @author lcl
 * @date: 2021/4/15
 **/
public class ParkingRequest implements Serializable {
    /**
     * 名称
     */
    private String parkName;
    /**
     * 停车场编号
     */
    private String parkCode;

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
}
