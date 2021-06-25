package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出租房信息对象 xl_lease
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
public class XlLease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 房屋室号名称 */
    @Excel(name = "房屋室号名称")
    private String room;

    /** 房东姓名 */
    @Excel(name = "房东姓名")
    private String leaseName;

    /** 房东身份证 */
    @Excel(name = "房东身份证号")
    private String leaseIdentityNumber;

    /** 房东联系电话 */
    @Excel(name = "房东联系电话")
    private String leaseLandladyPhone;

    /** 出租房地址 */
    @Excel(name = "出租房地址")
    private String leaseAddress;

    /** 房屋类型码(1商品房,2自建房) */
    private Integer roomTypeStatus;

    /** 房屋类型(商品房,自建房) */
    @Excel(name = "房屋类型(商品房,自建房)")
    private String roomType;

    /** 居住类型码(1出租,2自住) */
    private Integer leaseTypeStatus;

    /** 居住类型 */
    @Excel(name = "居住类型")
    private String leaseType;

    /** 房间数量 */
    @Excel(name = "房间数量")
    private String leaseNumber;

    /** 居住人数 */
    @Excel(name = "居住人数")
    private String leaseResidentsNumber;

    /** 房屋面积 */
    @Excel(name = "房屋面积")
    private String leaseArea;

    /** 所属社区 */
    @Excel(name = "所属社区")
    private String belongingCommunity;

    /** 社区编码 */
    private String communityCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoom(String room) 
    {
        this.room = room;
    }

    public String getRoom() 
    {
        return room;
    }
    public void setLeaseName(String leaseName) 
    {
        this.leaseName = leaseName;
    }

    public String getLeaseName() 
    {
        return leaseName;
    }
    public void setLeaseIdentityNumber(String leaseIdentityNumber) 
    {
        this.leaseIdentityNumber = leaseIdentityNumber;
    }

    public String getLeaseIdentityNumber() 
    {
        return leaseIdentityNumber;
    }
    public void setLeaseLandladyPhone(String leaseLandladyPhone) 
    {
        this.leaseLandladyPhone = leaseLandladyPhone;
    }

    public String getLeaseLandladyPhone() 
    {
        return leaseLandladyPhone;
    }
    public void setLeaseAddress(String leaseAddress) 
    {
        this.leaseAddress = leaseAddress;
    }

    public String getLeaseAddress() 
    {
        return leaseAddress;
    }
    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
    }

    public String getRoomType() 
    {
        return roomType;
    }
    public void setLeaseType(String leaseType) 
    {
        this.leaseType = leaseType;
    }

    public String getLeaseType() 
    {
        return leaseType;
    }
    public void setLeaseNumber(String leaseNumber) 
    {
        this.leaseNumber = leaseNumber;
    }

    public String getLeaseNumber() 
    {
        return leaseNumber;
    }
    public void setLeaseResidentsNumber(String leaseResidentsNumber) 
    {
        this.leaseResidentsNumber = leaseResidentsNumber;
    }

    public String getLeaseResidentsNumber() 
    {
        return leaseResidentsNumber;
    }
    public void setLeaseArea(String leaseArea) 
    {
        this.leaseArea = leaseArea;
    }

    public String getLeaseArea() 
    {
        return leaseArea;
    }
    public void setBelongingCommunity(String belongingCommunity) 
    {
        this.belongingCommunity = belongingCommunity;
    }

    public String getBelongingCommunity() 
    {
        return belongingCommunity;
    }
    public void setCommunityCode(String communityCode) 
    {
        this.communityCode = communityCode;
    }

    public String getCommunityCode() 
    {
        return communityCode;
    }

    public Integer getRoomTypeStatus() {
        return roomTypeStatus;
    }

    public void setRoomTypeStatus(Integer roomTypeStatus) {
        this.roomTypeStatus = roomTypeStatus;
    }

    public Integer getLeaseTypeStatus() {
        return leaseTypeStatus;
    }

    public void setLeaseTypeStatus(Integer leaseTypeStatus) {
        this.leaseTypeStatus = leaseTypeStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("room", getRoom())
            .append("leaseName", getLeaseName())
            .append("leaseIdentityNumber", getLeaseIdentityNumber())
            .append("leaseLandladyPhone", getLeaseLandladyPhone())
            .append("leaseAddress", getLeaseAddress())
            .append("roomTypeStatus", getRoomTypeStatus())
            .append("roomType", getRoomType())
            .append("leaseTypeStatus", getLeaseTypeStatus())
            .append("leaseType", getLeaseType())
            .append("leaseNumber", getLeaseNumber())
            .append("leaseResidentsNumber", getLeaseResidentsNumber())
            .append("leaseArea", getLeaseArea())
            .append("belongingCommunity", getBelongingCommunity())
            .append("communityCode", getCommunityCode())
            .toString();
    }
}
