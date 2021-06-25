package com.ruoyi.web.controller.thirdParty.parkingSpace.entity;


import java.io.Serializable;

/**
 * Content
 *
 * @author lcl
 * @date: 2021/4/15
 **/
public class Content implements Serializable {
    private String method;
    private ParkingRequest params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ParkingRequest getParams() {
        return params;
    }

    public void setParams(ParkingRequest params) {
        this.params = params;
    }
}
