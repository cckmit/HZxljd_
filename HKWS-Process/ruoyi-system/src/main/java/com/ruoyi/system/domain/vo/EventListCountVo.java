package com.ruoyi.system.domain.vo;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2021-06-19-0:50
 */
public class EventListCountVo implements Serializable {
    private String count;

    private String longitude;

    private String latitude;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
