package com.ruoyi.system.domain.property;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物业--人员进出记录对象 xl_person_pass_record
 *
 * @author ruoyi
 * @date 2021-06-09
 */
public class XlPersonPassRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recordId;

    /** 人员姓名 */
    @Excel(name = "人员姓名")
    private String personName;

    /** 人员性别（0男 1女 2未知） */
    @Excel(name = "人员性别", readConverterExp = "0=男,1=女,2=未知")
    private Integer personSex;

    /** 设备id */
    @Excel(name = "设备id")
    private Long deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 进出（1进 2出） */
    @Excel(name = "进出", readConverterExp = "1=进,2=出")
    private Integer passType;

    /** 抓拍图片 */
    @Excel(name = "抓拍图片")
    private String recordPhoto;

    /** 通行时间 */
    @Excel(name = "通行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date accessTime;

    /** 删除标识（0：存在 1：删除） */
    private Integer delFlag;

    public void setRecordId(Long recordId)
    {
        this.recordId = recordId;
    }

    public Long getRecordId()
    {
        return recordId;
    }
    public void setPersonName(String personName)
    {
        this.personName = personName;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setPersonSex(Integer personSex)
    {
        this.personSex = personSex;
    }

    public Integer getPersonSex()
    {
        return personSex;
    }
    public void setDeviceId(Long deviceId)
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId()
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
    public void setpassType(Integer passType)
    {
        this.passType = passType;
    }

    public Integer getpassType()
    {
        return passType;
    }
    public void setRecordPhoto(String recordPhoto)
    {
        this.recordPhoto = recordPhoto;
    }

    public String getRecordPhoto()
    {
        return recordPhoto;
    }
    public void setAccessTime(Date accessTime)
    {
        this.accessTime = accessTime;
    }

    public Date getAccessTime()
    {
        return accessTime;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("personName", getPersonName())
                .append("personSex", getPersonSex())
                .append("deviceId", getDeviceId())
                .append("deviceName", getDeviceName())
                .append("passType", getpassType())
                .append("recordPhoto", getRecordPhoto())
                .append("accessTime", getAccessTime())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}