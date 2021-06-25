package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公共管理/物业--车辆信息对象 xl_car_info
 *
 * @author ruoyi
 * @date 2021-05-25
 */
public class XlCarInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 车辆类型 */
    @Excel(name = "车辆类型", readConverterExp = "1=小型汽车,2=大型汽车,3=小型新能源汽车,4=大型新能源汽车")
    private String carType;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    /** 车主姓名 */
    @Excel(name = "车主姓名")
    private String ownerName;

    /** 车主手机号 */
    @Excel(name = "车主手机号")
    private String ownerPhone;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String quartersName;

    /** 小区id */
//    @Excel(name = "小区id")
    private Long villageId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCarType(String carType)
    {
        this.carType = carType;
    }

    public String getCarType()
    {
        return carType;
    }
    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber()
    {
        return carNumber;
    }
    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName()
    {
        return ownerName;
    }
    public void setOwnerPhone(String ownerPhone)
    {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerPhone()
    {
        return ownerPhone;
    }
    public void setQuartersName(String quartersName)
    {
        this.quartersName = quartersName;
    }

    public String getQuartersName()
    {
        return quartersName;
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
                .append("id", getId())
                .append("carType", getCarType())
                .append("carNumber", getCarNumber())
                .append("ownerName", getOwnerName())
                .append("ownerPhone", getOwnerPhone())
                .append("quartersName", getQuartersName())
                .append("villageId", getVillageId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}