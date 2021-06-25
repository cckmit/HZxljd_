package com.ruoyi.system.domain.HkEarlyWarning;

/**
 *一事一档-类型统计VO
 */
public class EventTypeVO {

    /**
     * 类型名称
     */
    private String name;

    /**
     * 类型所占半分比
     */
    private Integer value;

    /**
     * 部门Id
     */
    private String deptId;

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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
