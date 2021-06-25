package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房屋信息对象 xl_room
 * 
 * @author ruoyi
 * @date 2021-05-17
 */
public class XlRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /**
     * 所属社区
     */
    @Excel(name = "所属社区")
    private String communityName;
    /**
     * 居住类型
     */
    private Integer roomLiveType;

    /** 所属网格 */
    @Excel(name = "所属网格")
    private String deptName;

    /** 网格id */
//    @Excel(name = "网格id")
    private String deptId;

    /** 所属小区 */
    @Excel(name = "所属小区")
    private String villageName;

    /** 小区id */
//    @Excel(name = "小区id")
    private String villageId;

    /** 所属楼幢 */
    @Excel(name = "所属楼幢")
    private String building;

    /** 所属单元 */
    @Excel(name = "所属单元")
    private String unit;

    /** 所属房屋（名称） */
    @Excel(name = "所属房屋")
    private String room;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 房屋类型（如商品房，自建房） */
    @Excel(name = "房屋类型", readConverterExp = "1=商品房,2=自建房")
    private String roomType;

    /** 房屋编码 */
    @Excel(name = "房屋编码")
    private String roomCode;

    /** 所属村镇 */
    @Excel(name = "所属村镇")
    private String town;

    /** 村镇id */
//    @Excel(name = "村镇id")
    private String townId;

    /** 户主姓名 */
    @Excel(name = "户主姓名")
    private String householder;

    /** 经济类型（如一般户，低保户） */
    @Excel(name = "经济类型", readConverterExp = "1=一般户,2=贫困残疾户,3=低保户,4=分散供养特困户")
    private String economicType;

    /** 建造时间 */
    @Excel(name = "建造时间")
    private String buildTime;

    /** 建筑层数 */
    @Excel(name = "建筑层数")
    private String floors;

    /** 建筑面积 */
    @Excel(name = "建筑面积")
    private String areas;

    /** 占地面积 */
    @Excel(name = "占地面积")
    private String floorSpace;

    /** 房屋使用情况（如用作经营用房/非用作） */
    @Excel(name = "房屋使用情况", readConverterExp = "1=用作经营用房,2=非用作经营用房")
    private String useType;

    /** 房屋周边情况 */
    @Excel(name = "房屋周边情况", readConverterExp = "1=平地,2=低洼地,3=水边,4=山边,5=地质灾害易发区,6=海边,7=其他")
    private String around;

    /** 砌筑方式 */
    @Excel(name = "砌筑方式", readConverterExp = "1=空斗,2=实砌,3=其他")
    private String buildType;

    /** 构筑类型（如砖石结构,混凝土结构） */
    @Excel(name = "构筑类型", readConverterExp = "1=砖石结构（预制板）,2=砖石结构（非预制板）,3=混凝土结构,4=混杂结构,5=土木结构,6=钢结构,7=其他")
    private String structureType;

    /** 私自加层 */
    @Excel(name = "私自加层", readConverterExp = "0=有,1=无")
    private String adding;

    /** 地下室 */
    @Excel(name = "地下室", readConverterExp = "0=有,1=无")
    private String cellar;

    /** 三无 */
    @Excel(name = "三无", readConverterExp = "0=是,1=否")
    private String threeNo;

    /** 预制多孔板 */
    @Excel(name = "预制多孔板", readConverterExp = "0=有,1=无")
    private String board;

    /** 用地手续（有，无） */
    @Excel(name = "用地手续", readConverterExp = "0=有,1=无")
    private String procedures;

    /** 建设规划手册 */
    @Excel(name = "建设规划手册", readConverterExp = "0=有,1=无")
    private String planNote;

    /** 产权证 */
    @Excel(name = "产权证", readConverterExp = "0=有,1=无")
    private String certificate;

    /** 享受补助 */
    @Excel(name = "享受补助", readConverterExp = "0=是,1=否")
    private String assistance;

    /** 鉴定等级（如未鉴定，A，B） */
    @Excel(name = "鉴定等级", readConverterExp = "1=未鉴定,2=A,3=B,4=C,5=D")
    private String appraisal;

    /** 坐标经度 */
    @Excel(name = "坐标经度")
    private String gisx;

    /** 坐标维度 */
    @Excel(name = "坐标维度")
    private String gisy;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idcard;

    /** 家庭人数 */
    @Excel(name = "家庭人数")
    private String peoples;

    /** 是否改造 */
    @Excel(name = "是否改造", readConverterExp = "0=是,1=否")
    private String remould;

    /** 安全隐患初判（如基本安全） */
    @Excel(name = "安全隐患初判", readConverterExp = "1=基本安全,2=存在风险,3=其他")
    private String danger;

    /** 是否抗震加固 */
    @Excel(name = "是否抗震加固", readConverterExp = "0=是,1=否")
    private String reinforce;

    /** 整治计划情况（如已整治，五整治计划，其他） */
    @Excel(name = "整治计划情况", readConverterExp = "1=已整治,2=无整治计划,3=计划半年内,4=计划一年内,5=其他")
    private String renovate;

    /** 是否为山洪灾害隐患点 */
    @Excel(name = "是否为山洪灾害隐患点", readConverterExp = "0=是,1=否")
    private String waterflood;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getRoomLiveType() {
        return roomLiveType;
    }

    public void setRoomLiveType(Integer roomLiveType) {
        this.roomLiveType = roomLiveType;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setVillageName(String villageName) 
    {
        this.villageName = villageName;
    }

    public String getVillageName() 
    {
        return villageName;
    }
    public void setVillageId(String villageId) 
    {
        this.villageId = villageId;
    }

    public String getVillageId() 
    {
        return villageId;
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
    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
    }

    public String getRoomType() 
    {
        return roomType;
    }
    public void setRoomCode(String roomCode) 
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode() 
    {
        return roomCode;
    }
    public void setTown(String town) 
    {
        this.town = town;
    }

    public String getTown() 
    {
        return town;
    }
    public void setTownId(String townId) 
    {
        this.townId = townId;
    }

    public String getTownId() 
    {
        return townId;
    }
    public void setHouseholder(String householder) 
    {
        this.householder = householder;
    }

    public String getHouseholder() 
    {
        return householder;
    }
    public void setEconomicType(String economicType) 
    {
        this.economicType = economicType;
    }

    public String getEconomicType() 
    {
        return economicType;
    }
    public void setBuildTime(String buildTime) 
    {
        this.buildTime = buildTime;
    }

    public String getBuildTime() 
    {
        return buildTime;
    }
    public void setFloors(String floors) 
    {
        this.floors = floors;
    }

    public String getFloors() 
    {
        return floors;
    }
    public void setAreas(String areas) 
    {
        this.areas = areas;
    }

    public String getAreas() 
    {
        return areas;
    }
    public void setFloorSpace(String floorSpace) 
    {
        this.floorSpace = floorSpace;
    }

    public String getFloorSpace() 
    {
        return floorSpace;
    }
    public void setUseType(String useType) 
    {
        this.useType = useType;
    }

    public String getUseType() 
    {
        return useType;
    }
    public void setAround(String around) 
    {
        this.around = around;
    }

    public String getAround() 
    {
        return around;
    }
    public void setBuildType(String buildType) 
    {
        this.buildType = buildType;
    }

    public String getBuildType() 
    {
        return buildType;
    }
    public void setStructureType(String structureType) 
    {
        this.structureType = structureType;
    }

    public String getStructureType() 
    {
        return structureType;
    }
    public void setAdding(String adding) 
    {
        this.adding = adding;
    }

    public String getAdding() 
    {
        return adding;
    }
    public void setCellar(String cellar) 
    {
        this.cellar = cellar;
    }

    public String getCellar() 
    {
        return cellar;
    }
    public void setThreeNo(String threeNo) 
    {
        this.threeNo = threeNo;
    }

    public String getThreeNo() 
    {
        return threeNo;
    }
    public void setBoard(String board) 
    {
        this.board = board;
    }

    public String getBoard() 
    {
        return board;
    }
    public void setProcedures(String procedures) 
    {
        this.procedures = procedures;
    }

    public String getProcedures() 
    {
        return procedures;
    }
    public void setPlanNote(String planNote) 
    {
        this.planNote = planNote;
    }

    public String getPlanNote() 
    {
        return planNote;
    }
    public void setCertificate(String certificate) 
    {
        this.certificate = certificate;
    }

    public String getCertificate() 
    {
        return certificate;
    }
    public void setAssistance(String assistance) 
    {
        this.assistance = assistance;
    }

    public String getAssistance() 
    {
        return assistance;
    }
    public void setAppraisal(String appraisal) 
    {
        this.appraisal = appraisal;
    }

    public String getAppraisal() 
    {
        return appraisal;
    }
    public void setGisx(String gisx) 
    {
        this.gisx = gisx;
    }

    public String getGisx() 
    {
        return gisx;
    }
    public void setGisy(String gisy) 
    {
        this.gisy = gisy;
    }

    public String getGisy() 
    {
        return gisy;
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
    public void setPeoples(String peoples) 
    {
        this.peoples = peoples;
    }

    public String getPeoples() 
    {
        return peoples;
    }
    public void setRemould(String remould) 
    {
        this.remould = remould;
    }

    public String getRemould() 
    {
        return remould;
    }
    public void setDanger(String danger) 
    {
        this.danger = danger;
    }

    public String getDanger() 
    {
        return danger;
    }
    public void setReinforce(String reinforce) 
    {
        this.reinforce = reinforce;
    }

    public String getReinforce() 
    {
        return reinforce;
    }
    public void setRenovate(String renovate) 
    {
        this.renovate = renovate;
    }

    public String getRenovate() 
    {
        return renovate;
    }
    public void setWaterflood(String waterflood) 
    {
        this.waterflood = waterflood;
    }

    public String getWaterflood() 
    {
        return waterflood;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deptName", getDeptName())
            .append("deptId", getDeptId())
            .append("villageName", getVillageName())
            .append("villageId", getVillageId())
            .append("building", getBuilding())
            .append("unit", getUnit())
            .append("room", getRoom())
            .append("address", getAddress())
            .append("roomType", getRoomType())
            .append("roomCode", getRoomCode())
            .append("town", getTown())
            .append("townId", getTownId())
            .append("householder", getHouseholder())
            .append("economicType", getEconomicType())
            .append("buildTime", getBuildTime())
            .append("floors", getFloors())
            .append("areas", getAreas())
            .append("floorSpace", getFloorSpace())
            .append("useType", getUseType())
            .append("around", getAround())
            .append("buildType", getBuildType())
            .append("structureType", getStructureType())
            .append("adding", getAdding())
            .append("cellar", getCellar())
            .append("threeNo", getThreeNo())
            .append("board", getBoard())
            .append("procedures", getProcedures())
            .append("planNote", getPlanNote())
            .append("certificate", getCertificate())
            .append("assistance", getAssistance())
            .append("appraisal", getAppraisal())
            .append("gisx", getGisx())
            .append("gisy", getGisy())
            .append("phone", getPhone())
            .append("idcard", getIdcard())
            .append("peoples", getPeoples())
            .append("remould", getRemould())
            .append("danger", getDanger())
            .append("reinforce", getReinforce())
            .append("renovate", getRenovate())
            .append("waterflood", getWaterflood())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
