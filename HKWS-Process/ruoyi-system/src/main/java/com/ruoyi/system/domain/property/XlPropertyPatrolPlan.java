package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 物业-巡更计划对象 xl_property_patrol_plan
 *
 * @author ruoyi
 * @date 2021-06-04
 */
public class XlPropertyPatrolPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡更计划id */
    private Long planId;

    /** 巡更计划名称 */
    @Excel(name = "巡更计划名称")
    private String planName;

    /** 巡更路线id */
    @Excel(name = "巡更路线id")
    private Long pathId;
    private XlPropertyPatrolPath path;

    /** 巡更计划生效开始时间 */
    @Excel(name = "巡更计划生效开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planStartTime;

    /** 巡更计划生效结束时间 */
    @Excel(name = "巡更计划生效结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planEndTime;

    /** 巡更周期类型 */
    @Excel(name = "巡更计划周期")
    private String planCycle;

    /** 巡更周期 */
    @Excel(name = "巡更计划周期时间点")
    private String planCycleTiming;

    /** 巡更计划描述 */
    @Excel(name = "巡更计划描述")
    private String planRemark;

    /** 巡更计划状态(0：可执行(默认)；1：不可执行) */
    @Excel(name = "巡更计划状态(0：可执行(默认)；1：不可执行)")
    private Integer planStatus;

    /** 删除标识（0：未删除；1：已删除） */
    private Integer delFlag;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    /** 巡更员*/
    private List<SysUser> users;
    private List<String> userNames;
    private List<Long> userIds;


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
    public void setPathId(Long pathId)
    {
        this.pathId = pathId;
    }

    public Long getPathId()
    {
        return pathId;
    }
    public void setPlanStartTime(Date planStartTime)
    {
        this.planStartTime = planStartTime;
    }

    public Date getPlanStartTime()
    {
        return planStartTime;
    }
    public void setPlanEndTime(Date planEndTime)
    {
        this.planEndTime = planEndTime;
    }

    public Date getPlanEndTime()
    {
        return planEndTime;
    }

    public String getPlanCycle() {
        return planCycle;
    }

    public void setPlanCycle(String planCycle) {
        this.planCycle = planCycle;
    }

    public String getPlanCycleTiming() {
        return planCycleTiming;
    }

    public void setPlanCycleTiming(String planCycleTiming) {
        this.planCycleTiming = planCycleTiming;
    }

    public void setPlanRemark(String planRemark)
    {
        this.planRemark = planRemark;
    }

    public String getPlanRemark()
    {
        return planRemark;
    }
    public void setPlanStatus(Integer planStatus)
    {
        this.planStatus = planStatus;
    }

    public Integer getPlanStatus()
    {
        return planStatus;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }

    public XlPropertyPatrolPath getPath() {
        if(path == null){
            path = new XlPropertyPatrolPath();
        }
        return path;
    }

    public void setPath(XlPropertyPatrolPath path) {
        this.path = path;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("planId", getPlanId())
                .append("planName", getPlanName())
                .append("pathId", getPathId())
                .append("path", getPath())
                .append("userIds", getUserIds())
                .append("userNames", getUserNames())
                .append("users", getUsers())
                .append("planStartTime", getPlanStartTime())
                .append("planEndTime", getPlanEndTime())
                .append("planCycleTiming", getPlanCycleTiming())
                .append("planCycle", getPlanCycle())
                .append("planRemark", getPlanRemark())
                .append("planStatus", getPlanStatus())
                .append("delFlag", getDelFlag())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}