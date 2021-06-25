package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;

/**
 * 点位
 * @author: Lijiajia8
 * @date: 2020/4/30 11:08
 * @since: jdk1.8
 */
public class PointDTO  implements Serializable {
    /** 经度 */
    private String longitude;

    /** 纬度 */
    private String latitude;

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
