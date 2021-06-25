package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一人一档 处置分析
 */
public class PeopleDisposalAnalysisVO {


    /**
     * 用户名称
     */
    private String name;

    /**
     * 事件次数
     */
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
