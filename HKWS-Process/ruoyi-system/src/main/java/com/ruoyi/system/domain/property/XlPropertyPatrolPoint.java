package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物业-巡更点对象 xl_property_patrol_point
 *
 * @author ruoyi
 * @date 2021-06-03
 */
public class XlPropertyPatrolPoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 巡更点id */
    private Long pointId;

    /** 巡更点名称 */
    @Excel(name = "巡更点名称")
    private String pointName;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrCode;

    /** 位置描述 */
    @Excel(name = "位置描述")
    private String locationRemark;

    /** 删除标识（0：存在；1：删除） */
    private Integer delFlag;

    /** 小区id */
    @Excel(name = "小区id")
    private Integer villageId;

    public void setPointId(Long pointId)
    {
        this.pointId = pointId;
    }

    public Long getPointId()
    {
        return pointId;
    }
    public void setPointName(String pointName)
    {
        this.pointName = pointName;
    }

    public String getPointName()
    {
        return pointName;
    }
    public void setQrCode(String qrCode)
    {
        this.qrCode = qrCode;
    }

    public String getQrCode()
    {
        return qrCode;
    }
    public void setLocationRemark(String locationRemark)
    {
        this.locationRemark = locationRemark;
    }

    public String getLocationRemark()
    {
        return locationRemark;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("pointId", getPointId())
                .append("pointName", getPointName())
                .append("qrCode", getQrCode())
                .append("locationRemark", getLocationRemark())
                .append("delFlag", getDelFlag())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}