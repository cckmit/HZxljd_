package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业-巡更排班对象 xl_property_patrol_schedule
 *
 * @author ruoyi
 * @date 2021-06-06
 */
public class XlPropertyPatrolSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long scheduleId;

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

    /** 巡更方式（1：首尾有序） */
    @Excel(name = "巡更方式", readConverterExp = "1=：首尾有序")
    private Integer patrolType;

    /** 巡更日期 */
    @Excel(name = "巡更日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date patrolDate;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    public void setScheduleId(Long scheduleId)
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId()
    {
        return scheduleId;
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
    public void setPatrolType(Integer patrolType)
    {
        this.patrolType = patrolType;
    }

    public Integer getPatrolType()
    {
        return patrolType;
    }
    public void setPatrolDate(Date patrolDate)
    {
        this.patrolDate = patrolDate;
    }

    public Date getPatrolDate()
    {
        return patrolDate;
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
                .append("scheduleId", getScheduleId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("pathId", getPathId())
                .append("pathName", getPathName())
                .append("planId", getPlanId())
                .append("planName", getPlanName())
                .append("patrolType", getPatrolType())
                .append("patrolDate", getPatrolDate())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}