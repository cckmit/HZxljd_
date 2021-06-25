package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公共管理/物业--设备信息对象 xl_equipment_info
 *
 * @author ruoyi
 * @date 2021-06-18
 */
public class XlEquipmentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 设备类型（0-枪机,1-半球,2-快球,3-带云台枪机） */
    @Excel(name = "设备类型", readConverterExp = "0=-枪机,1-半球,2-快球,3-带云台枪机")
    private String equipmentType;

    /** 设备分类（1：监控；2：门禁） */
    @Excel(name = "设备分类", readConverterExp = "1=：监控；2：门禁")
    private String deviceType;

    /** 设备序列号 */
    @Excel(name = "设备序列号")
    private String equipmentSerialNumber;

    /** 标签id */
    @Excel(name = "标签id")
    private Long labelId;

    /** 验证码 */
    @Excel(name = "验证码")
    private String verificationCode;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String equipmentModel;

    /** 设备位置 */
    @Excel(name = "设备位置")
    private String equipmentAdress;

    /** 所属组织 */
    @Excel(name = "所属组织")
    private String equipmentOrganization;

    /** 存储（0-中心存储 1-设备存储） */
    @Excel(name = "存储", readConverterExp = "0=-中心存储,1=-设备存储")
    private Integer equipmentStorage;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 网络状态(0-不在线，1-在线) */
    @Excel(name = "网络状态(0-不在线，1-在线)")
    private Integer equipmentStatus;

    /** 小区id */
    @Excel(name = "小区id")
    private Long villageId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEquipmentName(String equipmentName)
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }
    public void setEquipmentType(String equipmentType)
    {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentType()
    {
        return equipmentType;
    }
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType()
    {
        return deviceType;
    }
    public void setEquipmentSerialNumber(String equipmentSerialNumber)
    {
        this.equipmentSerialNumber = equipmentSerialNumber;
    }

    public String getEquipmentSerialNumber()
    {
        return equipmentSerialNumber;
    }
    public void setLabelId(Long labelId)
    {
        this.labelId = labelId;
    }

    public Long getLabelId()
    {
        return labelId;
    }
    public void setVerificationCode(String verificationCode)
    {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCode()
    {
        return verificationCode;
    }
    public void setEquipmentModel(String equipmentModel)
    {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentModel()
    {
        return equipmentModel;
    }
    public void setEquipmentAdress(String equipmentAdress)
    {
        this.equipmentAdress = equipmentAdress;
    }

    public String getEquipmentAdress()
    {
        return equipmentAdress;
    }
    public void setEquipmentOrganization(String equipmentOrganization)
    {
        this.equipmentOrganization = equipmentOrganization;
    }

    public String getEquipmentOrganization()
    {
        return equipmentOrganization;
    }
    public void setEquipmentStorage(Integer equipmentStorage)
    {
        this.equipmentStorage = equipmentStorage;
    }

    public Integer getEquipmentStorage()
    {
        return equipmentStorage;
    }
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return longitude;
    }
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }
    public void setEquipmentStatus(Integer equipmentStatus)
    {
        this.equipmentStatus = equipmentStatus;
    }

    public Integer getEquipmentStatus()
    {
        return equipmentStatus;
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
                .append("equipmentName", getEquipmentName())
                .append("equipmentType", getEquipmentType())
                .append("deviceType", getDeviceType())
                .append("equipmentSerialNumber", getEquipmentSerialNumber())
                .append("labelId", getLabelId())
                .append("verificationCode", getVerificationCode())
                .append("equipmentModel", getEquipmentModel())
                .append("equipmentAdress", getEquipmentAdress())
                .append("equipmentOrganization", getEquipmentOrganization())
                .append("equipmentStorage", getEquipmentStorage())
                .append("longitude", getLongitude())
                .append("latitude", getLatitude())
                .append("equipmentStatus", getEquipmentStatus())
                .append("villageId", getVillageId())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
