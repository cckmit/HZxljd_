package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 物业-巡更路线对象 xl_property_patrol_path
 *
 * @author ruoyi
 * @date 2021-06-03
 */
public class XlPropertyPatrolPath extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡更路线id */
    private Long pathId;

    /** 巡更路线名称 */
    @Excel(name = "巡更路线名称")
    private String pathName;

    /** 巡更时长（分钟） */
    @Excel(name = "巡更时长", readConverterExp = "分=钟")
    private Integer patrolDuration;

    /** 巡更路线描述 */
    @Excel(name = "巡更路线描述")
    private String pathRemark;

    /** 状态（0：可用；1：不可用） */
    @Excel(name = "状态", readConverterExp = "0=：可用；1：不可用")
    private Integer pathStatus;

    /** 删除标识（0：存在：1：删除） */
    private Integer delFlag;

    /** 小区id */
    @Excel(name = "小区id")
    private Integer villageId;

    /** 巡更点 */
    @Excel(name = "巡更点")
    private List<String> pointNames;

    private List<XlPropertyPatrolPoint> points;

    private  List<Long> pointIds;

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
    public void setPatrolDuration(Integer patrolDuration)
    {
        this.patrolDuration = patrolDuration;
    }

    public Integer getPatrolDuration()
    {
        return patrolDuration;
    }
    public void setPathRemark(String pathRemark)
    {
        this.pathRemark = pathRemark;
    }

    public String getPathRemark()
    {
        return pathRemark;
    }
    public void setPathStatus(Integer pathStatus)
    {
        this.pathStatus = pathStatus;
    }

    public Integer getPathStatus()
    {
        return pathStatus;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }
    public void setVillageId(Integer villageId)
    {
        this.villageId = villageId;
    }

    public Integer getVillageId()
    {
        return villageId;
    }

    public List<XlPropertyPatrolPoint> getPoints() {
        return points;
    }

    public void setPoints(List<XlPropertyPatrolPoint> points) {
        this.points = points;
    }

    public List<String> getPointNames() {
        return pointNames;
    }

    public void setPointNames(List<String> pointNames) {
        this.pointNames = pointNames;
    }

    public List<Long> getPointIds() {
        return pointIds;
    }

    public void setPointIds(List<Long> pointIds) {
        this.pointIds = pointIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("pathId", getPathId())
                .append("pathName", getPathName())
                .append("pointName", getPointNames())
                .append("patrolDuration", getPatrolDuration())
                .append("pathRemark", getPathRemark())
                .append("pathStatus", getPathStatus())
                .append("delFlag", getDelFlag())
                .append("villageId", getVillageId())
                .append("points", getPoints())
                .append("pointIds",getPointIds())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}