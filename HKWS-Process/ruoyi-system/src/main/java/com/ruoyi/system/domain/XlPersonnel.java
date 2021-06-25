package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 人员信息对象 xl_personnel
 *
 * @author ruoyi
 * @date 2021-05-26
 */
@ApiModel(value = "xl_personnel对象", description = "人员信息")
public class XlPersonnel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty("人员Id")
    private Long id;

    /** 姓名 */
    @ApiModelProperty("人员姓名")
    @Excel(name = "姓名")
    private String name;

    /** 民族 */
    @ApiModelProperty("人员民族")
    @Excel(name = "民族")
    private String nation;

    /** 籍贯 */
    @ApiModelProperty("人员籍贯")
    @Excel(name = "籍贯")
    private String nativePlace;

    private String province;//省
    private String city; //市

    /** 户籍地住址 */
    @ApiModelProperty("人员地址")
    @Excel(name = "户籍地住址")
    private String nativeAddress;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idcard;

    /** 性别(0男  1女 3未知) */
    @Excel(name = "性别(男/女/未知)", readConverterExp ="0=男,1=女,3=未知" )
    private String gender;

    /** 年龄 */
//    @Excel(name = "年龄")
    private String age;

    //出生日期
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name = "出生日期")
    private Date birthDate;

    /** 学历 */
    @Excel(name = "学历(小学,初中,高中等)", readConverterExp = "1=小学,2=初中,3=高中,4=中专,5=大专,6=本科,7=研究生,8=硕士,9=博士")
    private String education;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况", readConverterExp = "1=未婚,2=已婚,3=离婚,4=丧偶")
    private String marry;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String workUnit;

    /** 政治面貌 */
    @Excel(name = "政治面貌", readConverterExp = "1=中共党员,2=预备党员,3=共青团员,4=民主党派,5=群众,6=其他")
    private String polity;

    /** 党组织领导 */
    @Excel(name = "党组织领导")
    private String communist;

    /** 支部名称 */
    @Excel(name = "支部名称")
    private String branch;

    /** 入党时间 */
    @Excel(name = "入党时间")
    private String joinTime;

    /** 网格id */
//    @Excel(name = "网格id")
    private String deptId;

    /** 所属网格 */
    @Excel(name = "所属网格")
    private String deptName;

    /** 小区id */
//    @Excel(name = "小区id")
    private Long villageId;

    /** 小区编号 */
    @Excel(name = "小区编号")
    private String villageCode;

    /** 所属小区 */
    @Excel(name = "所属小区")
    private String villageName;

    /** 所属楼幢 */
    @Excel(name = "所属楼幢")
    private String building;

    /** 所属单元 */
    @Excel(name = "所属单元")
    private String unit;

    /** 所属房屋 */
    @Excel(name = "所属房屋")
    private String room;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 房屋编号 */
    @Excel(name = "房屋编号")
    private String roomCode;

    /** 人脸照片 */
    @Excel(name = "人脸照片")
    private String personnelPhoto;

    /** 房屋类型（如商品房，自建房） */
    @Excel(name = "房屋类型", readConverterExp = "1=商品房,2=自建房")
    private String roomType;

    /** 人员类型（如解放军） */
    @Excel(name = "人员类型", readConverterExp = "1=解放军,2=学生,3=残疾人士")
    private String personnelType;

    /** 居住类型（如流动人口，户籍人口） */
    @Excel(name = "居住类型", readConverterExp = "1=流动人口,2=户籍人口")
    private String liveType;

    /** 与户主关系（户主，住户，租客） */
    @Excel(name = "与户主关系", readConverterExp = "1=户主,2=住户,3=租客")
    private String householderRelation;

    /** 是否产权人 */
    @Excel(name = "是否产权人", readConverterExp = "0=是,1=否")
    private String propertyRight;


    /** 工作检查记录表 */
    private XlWorkRecord xlWorkRecord;

    public XlWorkRecord getXlWorkRecord() {
        return xlWorkRecord;
    }

    public void setXlWorkRecord(XlWorkRecord xlWorkRecord) {
        this.xlWorkRecord = xlWorkRecord;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public String getNation()
    {
        return nation;
    }
    public void setNativePlace(String nativePlace)
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace()
    {
        return nativePlace;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNativeAddress(String nativeAddress)
    {
        this.nativeAddress = nativeAddress;
    }

    public String getNativeAddress()
    {
        return nativeAddress;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getIdcard()
    {
        return idcard;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAge()
    {
        return age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMarry(String marry)
    {
        this.marry = marry;
    }

    public String getMarry()
    {
        return marry;
    }
    public void setWorkUnit(String workUnit)
    {
        this.workUnit = workUnit;
    }

    public String getWorkUnit()
    {
        return workUnit;
    }
    public void setPolity(String polity)
    {
        this.polity = polity;
    }

    public String getPolity()
    {
        return polity;
    }
    public void setCommunist(String communist)
    {
        this.communist = communist;
    }

    public String getCommunist()
    {
        return communist;
    }
    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public String getBranch()
    {
        return branch;
    }
    public void setJoinTime(String joinTime)
    {
        this.joinTime = joinTime;
    }

    public String getJoinTime()
    {
        return joinTime;
    }
    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    public String getDeptId()
    {
        return deptId;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setVillageId(Long villageId)
    {
        this.villageId = villageId;
    }

    public Long getVillageId()
    {
        return villageId;
    }
    public void setVillageCode(String villageCode)
    {
        this.villageCode = villageCode;
    }

    public String getVillageCode()
    {
        return villageCode;
    }
    public void setVillageName(String villageName)
    {
        this.villageName = villageName;
    }

    public String getVillageName()
    {
        return villageName;
    }
    public void setBuilding(String building)
    {
        this.building = building;
    }

    public String getBuilding()
    {
        return building;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setRoom(String room)
    {
        this.room = room;
    }

    public String getRoom()
    {
        return room;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setPersonnelPhoto(String personnelPhoto)
    {
        this.personnelPhoto = personnelPhoto;
    }

    public String getPersonnelPhoto()
    {
        return personnelPhoto;
    }
    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }

    public String getRoomType()
    {
        return roomType;
    }
    public void setPersonnelType(String personnelType)
    {
        this.personnelType = personnelType;
    }

    public String getPersonnelType()
    {
        return personnelType;
    }
    public void setLiveType(String liveType)
    {
        this.liveType = liveType;
    }

    public String getLiveType()
    {
        return liveType;
    }
    public void setHouseholderRelation(String householderRelation)
    {
        this.householderRelation = householderRelation;
    }

    public String getHouseholderRelation()
    {
        return householderRelation;
    }
    public void setPropertyRight(String propertyRight)
    {
        this.propertyRight = propertyRight;
    }

    public String getPropertyRight()
    {
        return propertyRight;
    }
    public void setRoomCode(String roomCode)
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode()
    {
        return roomCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("nation", getNation())
                .append("nativePlace", getNativePlace())
                .append("province", getProvince())
                .append("city", getCity())
                .append("nativeAddress", getNativeAddress())
                .append("phone", getPhone())
                .append("idcard", getIdcard())
                .append("gender", getGender())
                .append("age", getAge())
                .append("birthDate", getBirthDate())
                .append("education", getEducation())
                .append("marry", getMarry())
                .append("workUnit", getWorkUnit())
                .append("polity", getPolity())
                .append("communist", getCommunist())
                .append("branch", getBranch())
                .append("joinTime", getJoinTime())
                .append("deptId", getDeptId())
                .append("deptName", getDeptName())
                .append("villageId", getVillageId())
                .append("villageCode", getVillageCode())
                .append("villageName", getVillageName())
                .append("building", getBuilding())
                .append("unit", getUnit())
                .append("room", getRoom())
                .append("address", getAddress())
                .append("personnelPhoto", getPersonnelPhoto())
                .append("roomType", getRoomType())
                .append("personnelType", getPersonnelType())
                .append("liveType", getLiveType())
                .append("householderRelation", getHouseholderRelation())
                .append("propertyRight", getPropertyRight())
                .append("roomCode", getRoomCode())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
