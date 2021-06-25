package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 房屋管理对象 hk_rent_house_info
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public class HkRentHouseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 房屋编号 */
    @Excel(name = "房屋编号")
    private String houseCode;

    /** 房东姓名 */
    @Excel(name = "房东姓名")
    private String houseOwnerName;

    /** 房东电话 */
    @Excel(name = "房东电话")
    private String houseOwnerPhone;

    /** 性别 */
    @Excel(name = "性别")
    private Integer houseOwnerSex;

    /** 房屋详细地址 */
    @Excel(name = "房屋详细地址")
    private String houseAddress;

    /** 证件种类 */
    @Excel(name = "证件种类")
    private Integer houseOwnerIdType;

    /** 证件号 */
    @Excel(name = "证件号")
    private String houseOwnerId;

    /** 所属市 */
    @Excel(name = "所属市")
    private String cityName;

    /** 所属区域 */
    @Excel(name = "所属区")
    private String regionName;

    /** 所属区域 */
    @Excel(name = "所属社区")
    private String communityName;

    /** 租赁状态 */
    @Excel(name = "租赁状态")
    private String houseStatus;

    /**经度**/
    private String longitude;

    /**纬度**/
    private String latitude;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseCode(String houseCode) 
    {
        this.houseCode = houseCode;
    }

    public String getHouseCode() 
    {
        return houseCode;
    }
    public void setHouseOwnerName(String houseOwnerName) 
    {
        this.houseOwnerName = houseOwnerName;
    }

    public String getHouseOwnerName() 
    {
        return houseOwnerName;
    }
    public void setHouseOwnerPhone(String houseOwnerPhone) 
    {
        this.houseOwnerPhone = houseOwnerPhone;
    }

    public String getHouseOwnerPhone() 
    {
        return houseOwnerPhone;
    }
    public void setHouseOwnerSex(Integer houseOwnerSex) 
    {
        this.houseOwnerSex = houseOwnerSex;
    }

    public Integer getHouseOwnerSex() 
    {
        return houseOwnerSex;
    }
    public void setHouseAddress(String houseAddress) 
    {
        this.houseAddress = houseAddress;
    }

    public String getHouseAddress() 
    {
        return houseAddress;
    }
    public void setHouseOwnerIdType(Integer houseOwnerIdType) 
    {
        this.houseOwnerIdType = houseOwnerIdType;
    }

    public Integer getHouseOwnerIdType() 
    {
        return houseOwnerIdType;
    }
    public void setHouseOwnerId(String houseOwnerId) 
    {
        this.houseOwnerId = houseOwnerId;
    }

    public String getHouseOwnerId() 
    {
        return houseOwnerId;
    }
    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("houseCode", getHouseCode())
            .append("houseOwnerName", getHouseOwnerName())
            .append("houseOwnerPhone", getHouseOwnerPhone())
            .append("houseOwnerSex", getHouseOwnerSex())
            .append("houseAddress", getHouseAddress())
            .append("houseOwnerIdType", getHouseOwnerIdType())
            .append("houseOwnerId", getHouseOwnerId())
            .append("regionName", getRegionName())
            .toString();
    }
}
