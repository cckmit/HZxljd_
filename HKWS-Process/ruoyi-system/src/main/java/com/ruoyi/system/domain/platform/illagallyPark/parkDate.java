package com.ruoyi.system.domain.platform.illagallyPark;

/**
 * Copyright 2021 json.cn
 */
import java.util.List;

/**
 * Auto-generated: 2021-05-20 10:28:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class parkDate {

    private parkingRecord parkingRecord;
    private List<imageList> imageList;

    public com.ruoyi.system.domain.platform.illagallyPark.parkingRecord getParkingRecord() {
        return parkingRecord;
    }

    public void setParkingRecord(com.ruoyi.system.domain.platform.illagallyPark.parkingRecord parkingRecord) {
        this.parkingRecord = parkingRecord;
    }

    public List<com.ruoyi.system.domain.platform.illagallyPark.imageList> getImageList() {
        return imageList;
    }

    public void setImageList(List<com.ruoyi.system.domain.platform.illagallyPark.imageList> imageList) {
        this.imageList = imageList;
    }
}
