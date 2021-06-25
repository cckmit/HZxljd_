package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业-巡更统计对象 xl_property_patrol_statistic
 *
 * @author ruoyi
 * @date 2021-06-08
 */
public class XlPropertyPatrolStatistic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long statisticId;

    /** 巡更任务数 */
    @Excel(name = "巡更任务数")
    private Long patrolCount;

    /** 完成任务数 */
    @Excel(name = "完成任务数")
    private Long finishCount;

    /** 未完成任务数 */
    @Excel(name = "未完成任务数")
    private Long unfinishCount;

    /** 完成率 */
    @Excel(name = "完成率")
    private String finishRate;

    /** 统计日期 */
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticDate;
    /** 巡更物业id */
    @Excel(name = "巡更物业id")
    private Long patrolPropertyId;

    /** 巡更物业 */
    @Excel(name = "巡更物业")
    private String patrolProperty;

    public Long getPatrolPropertyId() {
        return patrolPropertyId;
    }

    public void setPatrolPropertyId(Long patrolPropertyId) {
        this.patrolPropertyId = patrolPropertyId;
    }

    public String getPatrolProperty() {
        return patrolProperty;
    }

    public void setPatrolProperty(String patrolProperty) {
        this.patrolProperty = patrolProperty;
    }

    public void setStatisticId(Long statisticId)
    {
        this.statisticId = statisticId;
    }

    public Long getStatisticId()
    {
        return statisticId;
    }
    public void setPatrolCount(Long patrolCount)
    {
        this.patrolCount = patrolCount;
    }

    public Long getPatrolCount()
    {
        return patrolCount;
    }
    public void setFinishCount(Long finishCount)
    {
        this.finishCount = finishCount;
    }

    public Long getFinishCount()
    {
        return finishCount;
    }
    public void setUnfinishCount(Long unfinishCount)
    {
        this.unfinishCount = unfinishCount;
    }

    public Long getUnfinishCount()
    {
        return unfinishCount;
    }
    public void setFinishRate(String finishRate)
    {
        this.finishRate = finishRate;
    }

    public String getFinishRate()
    {
        return finishRate;
    }
    public void setStatisticDate(Date statisticDate)
    {
        this.statisticDate = statisticDate;
    }

    public Date getStatisticDate()
    {
        return statisticDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("statisticId", getStatisticId())
                .append("patrolCount", getPatrolCount())
                .append("finishCount", getFinishCount())
                .append("unfinishCount", getUnfinishCount())
                .append("finishRate", getFinishRate())
                .append("statisticDate", getStatisticDate())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
