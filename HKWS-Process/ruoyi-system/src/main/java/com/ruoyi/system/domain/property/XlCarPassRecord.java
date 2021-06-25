package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业--车辆进出记录对象 xl_car_pass_record
 *
 * @author ruoyi
 * @date 2021-06-09
 */
public class XlCarPassRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recordId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private Integer carType;

    /** 记录类型（1进  2出） */
    @Excel(name = "记录类型", readConverterExp = "1=进,2=出")
    private Integer passType;

    /** 设备id */
    @Excel(name = "设备id")
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 通行时间 */
    @Excel(name = "通行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date accessTime;

    /** 抓拍照片 */
    @Excel(name = "抓拍照片")
    private String carPhoto;

    /** 是否删除（0：存在 1：删除） */
    private Integer delFlag;

    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId()
    {
        return recordId;
    }
    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber()
    {
        return carNumber;
    }
    public void setCarType(Integer carType)
    {
        this.carType = carType;
    }

    public Integer getCarType()
    {
        return carType;
    }
    public void setpassType(Integer passType)
    {
        this.passType = passType;
    }

    public Integer getpassType()
    {
        return passType;
    }
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setAccessTime(Date accessTime)
    {
        this.accessTime = accessTime;
    }

    public Date getAccessTime()
    {
        return accessTime;
    }
    public void setCarPhoto(String carPhoto)
    {
        this.carPhoto = carPhoto;
    }

    public String getCarPhoto()
    {
        return carPhoto;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("carNumber", getCarNumber())
                .append("carType", getCarType())
                .append("passType", getpassType())
                .append("deviceId", getDeviceId())
                .append("deviceName", getDeviceName())
                .append("accessTime", getAccessTime())
                .append("carPhoto", getCarPhoto())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}