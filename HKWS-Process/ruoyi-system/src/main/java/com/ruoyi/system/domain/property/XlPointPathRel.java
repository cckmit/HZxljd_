package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物业-巡更点与巡更路线关系对象 xl_point_path_rel
 *
 * @author ruoyi
 * @date 2021-06-03
 */
public class XlPointPathRel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 巡更路线id */
    @Excel(name = "巡更路线id")
    private Long pathId;

    /** 巡更点id */
    @Excel(name = "巡更点id")
    private Long pointId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPathId(Long pathId)
    {
        this.pathId = pathId;
    }

    public Long getPathId()
    {
        return pathId;
    }
    public void setPointId(Long pointId)
    {
        this.pointId = pointId;
    }

    public Long getPointId()
    {
        return pointId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pathId", getPathId())
                .append("pointId", getPointId())
                .toString();
    }
}
