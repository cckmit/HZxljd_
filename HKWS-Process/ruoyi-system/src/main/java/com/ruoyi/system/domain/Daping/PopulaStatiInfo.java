package com.ruoyi.system.domain.Daping;

import java.io.Serializable;

public class PopulaStatiInfo implements Serializable {

    private String regionName;

    private int total;

    private int ldCount;

    private int rhCount;

    private String percent;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLdCount() {
        return ldCount;
    }

    public void setLdCount(int ldCount) {
        this.ldCount = ldCount;
    }

    public int getRhCount() {
        return rhCount;
    }

    public void setRhCount(int rhCount) {
        this.rhCount = rhCount;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }
}
