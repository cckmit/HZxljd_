package com.ruoyi.system.domain.Daping;

import java.io.Serializable;
import java.math.BigDecimal;

public class PercentResult implements Serializable {

    private String name;

    private String code;

    private Long value;

    private Double percent;

    private String createTime;

    private Double eventRateYear;

    private Double eventRateMonth;

    private String postName;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value==null?0L:value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getEventRateYear() {
        return eventRateYear;
    }

    public void setEventRateYear(Double eventRateYear) {
        this.eventRateYear = eventRateYear;
    }

    public Double getEventRateMonth() {
        return eventRateMonth;
    }

    public void setEventRateMonth(Double eventRateMonth) {
        this.eventRateMonth = eventRateMonth;
    }
}
