package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业-巡更任务对象 xl_property_patrol_record
 *
 * @author ruoyi
 * @date 2021-06-15
 */
public class XlPropertyPatrolRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recordId;

    /** 巡更员id */
    @Excel(name = "巡更员id")
    private Long userId;

    /** 巡更员 */
    @Excel(name = "巡更员")
    private String userName;

    /** 巡更路线id */
    @Excel(name = "巡更路线id")
    private Long pathId;

    /** 巡更路线 */
    @Excel(name = "巡更路线")
    private String pathName;

    /** 巡更计划id */
    @Excel(name = "巡更计划id")
    private Long planId;

    /** 巡更计划 */
    @Excel(name = "巡更计划")
    private String planName;

    /** 巡更时间 */
    @Excel(name = "巡更时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date patrolTime;

    /** 巡更时长（分钟） */
    @Excel(name = "巡更时长", readConverterExp = "分钟")
    private Integer patrolDuration;

    /** 巡更处理状态（1：待处理；2：处理中；3：已处理；4：已超时；5：已失效） */
    @Excel(name = "巡更处理状态", readConverterExp = "1=：待处理；2：处理中；3：已处理；4：已超时；5：已失效")
    private Integer handleStatus;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId()
    {
        return recordId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setPathId(Long pathId)
    {
        this.pathId = pathId;
    }

    public Long getPathId()
    {
        return pathId;
    }
    public void setPathName(String pathName)
    {
        this.pathName = pathName;
    }

    public String getPathName()
    {
        return pathName;
    }
    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setPlanName(String planName)
    {
        this.planName = planName;
    }

    public String getPlanName()
    {
        return planName;
    }
    public void setPatrolTime(Date patrolTime)
    {
        this.patrolTime = patrolTime;
    }

    public Date getPatrolTime()
    {
        return patrolTime;
    }
    public void setPatrolDuration(Integer patrolDuration)
    {
        this.patrolDuration = patrolDuration;
    }

    public Integer getPatrolDuration()
    {
        return patrolDuration;
    }
    public void setHandleStatus(Integer handleStatus)
    {
        this.handleStatus = handleStatus;
    }

    public Integer getHandleStatus()
    {
        return handleStatus;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("pathId", getPathId())
                .append("pathName", getPathName())
                .append("planId", getPlanId())
                .append("planName", getPlanName())
                .append("patrolTime", getPatrolTime())
                .append("patrolDuration", getPatrolDuration())
                .append("handleStatus", getHandleStatus())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}