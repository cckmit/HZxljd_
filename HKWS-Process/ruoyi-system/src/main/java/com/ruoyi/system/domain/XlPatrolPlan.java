package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 网格员--巡查计划对象 xl_patrol_plan
 *
 * @author ruoyi
 * @date 2021-05-22
 */
public class XlPatrolPlan extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 网格巡查计划id
     */
    private Long id;

    /**
     * 规则名称
     */
    @Excel(name = "规则名称")
    private String ruleName;

    /**
     * 周期
     */
    @Excel(name = "周期")
    private String period;

    /**
     * 次数
     */
    @Excel(name = "次数")
    private String number;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String describes;

    //类别状态-网格管理12345
    private Integer status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getDescribes() {
        return describes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("ruleName", getRuleName())
                .append("period", getPeriod())
                .append("number", getNumber())
                .append("describes", getDescribes())
                .append("status", getStatus())
                .toString();
    }
}
