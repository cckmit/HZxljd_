package com.ruoyi.web.controller.thirdParty.parkingSpace.entity;


import java.util.List;

/**
 * ParkingResponse
 *
 * @author lcl
 * @date: 2021/4/15
 **/
public class ParkingResponse {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * HTTP请求状态码
     */
    private int httpStatus;
    /**
     * 返回的对象数据
     */
    private List<DataVo> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<DataVo> getData() {
        return data;
    }

    public void setData(List<DataVo> data) {
        this.data = data;
    }

    public static class DataVo{

        /**
         * 名称
         */
        private String parkName;

        /**
         * 停车场编号
         */
        private String parkCode;

        /**
         * 地址
         */
        private String address;

        /**
         * 维度
         */
        private Float lat;

        /**
         * 经度
         */
        private Float lng;

        /**
         * 是否运营（1.正常运营,2.停止运营）
         */
        private String isOp;

        /**
         * 总泊位数
         */
        private Integer totalLots;

        /**
         * 空余泊位数
         */
        private Integer currentLots;

        public String getParkName() {
            return parkName;
        }

        public void setParkName(String parkName) {
            this.parkName = parkName;
        }

        public String getParkCode() {
            return parkCode;
        }

        public void setParkCode(String parkCode) {
            this.parkCode = parkCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Float getLat() {
            return lat;
        }

        public void setLat(Float lat) {
            this.lat = lat;
        }

        public Float getLng() {
            return lng;
        }

        public void setLng(Float lng) {
            this.lng = lng;
        }

        public String getIsOp() {
            return isOp;
        }

        public void setIsOp(String isOp) {
            this.isOp = isOp;
        }

        public Integer getTotalLots() {
            return totalLots;
        }

        public void setTotalLots(Integer totalLots) {
            this.totalLots = totalLots;
        }

        public Integer getCurrentLots() {
            return currentLots;
        }

        public void setCurrentLots(Integer currentLots) {
            this.currentLots = currentLots;
        }
    }
}
