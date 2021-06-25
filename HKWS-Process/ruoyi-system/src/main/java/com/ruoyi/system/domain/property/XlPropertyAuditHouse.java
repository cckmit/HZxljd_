package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物业-房屋审核对象 xl_property_audit_house
 *
 * @author ruoyi
 * @date 2021-06-01
 */
public class XlPropertyAuditHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long auditId;

    /** 审核房间位置 */
    @Excel(name = "审核房间位置")
    private String location;

    /** 审核房屋面积（平方米） */
    @Excel(name = "审核房屋面积", readConverterExp = "平=方米")
    private String area;

    /** 房屋类型（1：商品房；2：自建房） */
    @Excel(name = "房屋类型", readConverterExp = "1=：商品房；2：自建房")
    private Integer houseType;

    /** 是否产权人（0：是；1：否） */
    @Excel(name = "是否产权人", readConverterExp = "0=：是；1：否")
    private Integer propertyRight;

    /** 申请人 */
    @Excel(name = "申请人")
    private String proposer;

    /** 申请人手机号 */
    @Excel(name = "申请人手机号")
    private String proposerPhone;

    /** 审核状态（1：待审核；2：审核通过；3：审核拒绝） */
    @Excel(name = "审核状态", readConverterExp = "1=：待审核；2：审核通过；3：审核拒绝")
    private Integer auditStatus;

    /** 小区id */
    @Excel(name = "小区id")
    private Integer villageId;

    public void setAuditId(Long auditId)
    {
        this.auditId = auditId;
    }

    public Long getAuditId()
    {
        return auditId;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public Integer getPropertyRight() {
        return propertyRight;
    }

    public void setPropertyRight(Integer propertyRight) {
        this.propertyRight = propertyRight;
    }

    public String getArea()
    {
        return area;
    }
    public void setHouseType(Integer houseType)
    {
        this.houseType = houseType;
    }

    public Integer getHouseType()
    {
        return houseType;
    }
    public void setProposer(String proposer)
    {
        this.proposer = proposer;
    }

    public String getProposer()
    {
        return proposer;
    }
    public void setProposerPhone(String proposerPhone)
    {
        this.proposerPhone = proposerPhone;
    }

    public String getProposerPhone()
    {
        return proposerPhone;
    }
    public void setAuditStatus(Integer auditStatus)
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus()
    {
        return auditStatus;
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
                .append("auditId", getAuditId())
                .append("location", getLocation())
                .append("area", getArea())
                .append("houseType", getHouseType())
                .append("proposer", getProposer())
                .append("proposerPhone", getProposerPhone())
                .append("auditStatus", getAuditStatus())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}