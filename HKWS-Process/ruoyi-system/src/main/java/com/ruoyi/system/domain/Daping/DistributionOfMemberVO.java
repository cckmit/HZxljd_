package com.ruoyi.system.domain.Daping;

/**
 * 网格员、执法力量分布情况实体
 */
public class DistributionOfMemberVO {

    /**
     * 区域名称
     */
    private String deptName;

    /**
     * 网格员/执法力量分布情况
     */
    private Integer count;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
