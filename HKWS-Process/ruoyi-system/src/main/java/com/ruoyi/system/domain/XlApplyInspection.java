package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 网格管理-检查组应用对象 xl_apply_inspection
 * 
 * @author ruoyi
 * @date 2021-06-04
 */
public class XlApplyInspection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 检查组id */
    @Excel(name = "检查组id")
    private Long inspectionId;

    /** 类型(1单位2入户巡查3面上4物业小区5出租房6其他) */
    @Excel(name = "类型(1单位2入户巡查3面上4物业小区5出租房6其他)")
    private Integer status;

    /** 村社网格id */
    @Excel(name = "村社网格id")
    private String regionId;

    /** 应用于事物的id(单位人员等id) */
    @Excel(name = "应用于事物的id(单位人员等id)")
    private String thingId;

    /** 应用时间 */
    @Excel(name = "应用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInspectionId(Long inspectionId) 
    {
        this.inspectionId = inspectionId;
    }

    public Long getInspectionId() 
    {
        return inspectionId;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setRegionId(String regionId) 
    {
        this.regionId = regionId;
    }

    public String getRegionId() 
    {
        return regionId;
    }
    public void setThingId(String thingId) 
    {
        this.thingId = thingId;
    }

    public String getThingId() 
    {
        return thingId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("inspectionId", getInspectionId())
            .append("status", getStatus())
            .append("regionId", getRegionId())
            .append("thingId", getThingId())
            .append("createDate", getCreateDate())
            .toString();
    }
}
