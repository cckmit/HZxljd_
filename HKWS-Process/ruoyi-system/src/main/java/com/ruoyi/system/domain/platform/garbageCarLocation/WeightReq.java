package com.ruoyi.system.domain.platform.garbageCarLocation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author cui
 * @version 1.0
 * @date 2021-04-06
 */
public class WeightReq {

    /**
     * 车牌号颜色(接口约定，统一蓝牌)
     * 1：蓝牌
     * 2：黄牌
     */
    @JsonIgnore
    private Integer licensePlateType;

    public Integer getLicensePlateType() {
        return 1; //(接口约定，统一蓝牌)
    }

    /**
     * 车牌号
     */
    @NotEmpty
    private String licensePlate;

    /**
     * 重量(kg)
     */
    @NotNull
    private Integer weight;

    /**
     * 称重时间
     */
    @NotEmpty
    private String weightTime;

    public void setLicensePlateType(Integer licensePlateType) {
        this.licensePlateType = licensePlateType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getWeightTime() {
        return weightTime;
    }

    public void setWeightTime(String weightTime) {
        this.weightTime = weightTime;
    }
}
