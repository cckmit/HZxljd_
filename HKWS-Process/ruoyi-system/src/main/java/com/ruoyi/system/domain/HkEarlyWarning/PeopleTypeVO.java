package com.ruoyi.system.domain.HkEarlyWarning;

/**
 * 一人一档 队伍统计
 */
public class PeopleTypeVO {

    /**
     * 队伍在线数
     */
    private Integer peopleOnLineCount;

    /**
     * 队伍离线数
     */
    private Integer peopleOutLineCount;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 队伍总数
     */
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getPeopleOnLineCount() {
        return peopleOnLineCount;
    }

    public void setPeopleOnLineCount(Integer peopleOnLineCount) {
        this.peopleOnLineCount = peopleOnLineCount;
    }

    public Integer getPeopleOutLineCount() {
        return peopleOutLineCount;
    }

    public void setPeopleOutLineCount(Integer peopleOutLineCount) {
        this.peopleOutLineCount = peopleOutLineCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
