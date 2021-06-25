package com.ruoyi.system.domain.unifyAdress;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 xl_unify_address_info
 * 
 * @author ruoyi
 * @date 2021-06-20
 */
public class XlUnifyAddressInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long unifyId;

    /** 标准地址编码 */
    @Excel(name = "标准地址编码")
    private String unifyCode;

    /** 结果地址 */
    @Excel(name = "结果地址")
    private String unifyAddr;

    /** 地址层级（1.市 2.县 3 街道 4 社区 5.行政组 6.自然村
7.专业区 8.街路巷 9.门牌 10.小区 11.建筑物 12.楼牌 1
3.单元 14.楼层 15.户室） */
    @Excel(name = "地址层级", readConverterExp = "1=.市,2=.县,3=,街=道,4=,社=区,5=.行政组,6=.自然村 7.专业区,8=.街路巷,9=.门牌,1=0.小区,1=1.建筑物,1=2.楼牌,1= 3.单元,1=4.楼层,1=5.户室")
    private Integer unifyLv;

    /** 地址结果评分 */
    @Excel(name = "地址结果评分")
    private String unifyScore;

    /** 经度 */
    @Excel(name = "经度")
    private String unifyLon;

    /** 纬度 */
    @Excel(name = "纬度")
    private String unifyLat;

    /** 地址经纬度json */
    @Excel(name = "地址经纬度json")
    private String unifyLoc;

    /** 地址空间面信息 */
    @Excel(name = "地址空间面信息")
    private String unifyShape;

    /** 城市 */
    @Excel(name = "城市")
    private String unifyCity;

    /** 县 */
    @Excel(name = "县")
    private String unifyCounty;

    /** 街道 */
    @Excel(name = "街道")
    private String unifyTown;

    /** 社区 */
    @Excel(name = "社区")
    private String unifyCommunity;

    /** 行政组 */
    @Excel(name = "行政组")
    private String unifySquad;

    /** 自然村 */
    @Excel(name = "自然村")
    private String unifyVillage;

    /** 专业区 */
    @Excel(name = "专业区")
    private String unifySzone;

    /** 街路巷 */
    @Excel(name = "街路巷")
    private String unifyStreet;

    /** 门牌 */
    @Excel(name = "门牌")
    private String unifyDoor;

    /** 小区 */
    @Excel(name = "小区")
    private String unifyResregion;

    /** 建筑物 */
    @Excel(name = "建筑物")
    private String unifyBuilding;

    /** 楼牌 */
    @Excel(name = "楼牌")
    private String unifyBuildingNum;

    /** 单元 */
    @Excel(name = "单元")
    private String unifyUnit;

    /** 楼层 */
    @Excel(name = "楼层")
    private String unifyFloor;

    /** 户室 */
    @Excel(name = "户室")
    private String unifyRoom;

    /** 房间所属楼层 */
    @Excel(name = "房间所属楼层")
    private String roomFloor;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    public void setUnifyId(Long unifyId) 
    {
        this.unifyId = unifyId;
    }

    public Long getUnifyId() 
    {
        return unifyId;
    }
    public void setUnifyCode(String unifyCode) 
    {
        this.unifyCode = unifyCode;
    }

    public String getUnifyCode() 
    {
        return unifyCode;
    }
    public void setUnifyAddr(String unifyAddr) 
    {
        this.unifyAddr = unifyAddr;
    }

    public String getUnifyAddr() 
    {
        return unifyAddr;
    }
    public void setUnifyLv(Integer unifyLv) 
    {
        this.unifyLv = unifyLv;
    }

    public Integer getUnifyLv() 
    {
        return unifyLv;
    }

    public String getUnifyScore() {
        return unifyScore;
    }

    public void setUnifyScore(String unifyScore) {
        this.unifyScore = unifyScore;
    }

    public void setUnifyLon(String unifyLon)
    {
        this.unifyLon = unifyLon;
    }

    public String getUnifyLon() 
    {
        return unifyLon;
    }
    public void setUnifyLat(String unifyLat) 
    {
        this.unifyLat = unifyLat;
    }

    public String getUnifyLat() 
    {
        return unifyLat;
    }
    public void setUnifyLoc(String unifyLoc) 
    {
        this.unifyLoc = unifyLoc;
    }

    public String getUnifyLoc() 
    {
        return unifyLoc;
    }
    public void setUnifyShape(String unifyShape) 
    {
        this.unifyShape = unifyShape;
    }

    public String getUnifyShape() 
    {
        return unifyShape;
    }
    public void setUnifyCity(String unifyCity) 
    {
        this.unifyCity = unifyCity;
    }

    public String getUnifyCity() 
    {
        return unifyCity;
    }
    public void setUnifyCounty(String unifyCounty) 
    {
        this.unifyCounty = unifyCounty;
    }

    public String getUnifyCounty() 
    {
        return unifyCounty;
    }
    public void setUnifyTown(String unifyTown) 
    {
        this.unifyTown = unifyTown;
    }

    public String getUnifyTown() 
    {
        return unifyTown;
    }
    public void setUnifyCommunity(String unifyCommunity) 
    {
        this.unifyCommunity = unifyCommunity;
    }

    public String getUnifyCommunity() 
    {
        return unifyCommunity;
    }
    public void setUnifySquad(String unifySquad) 
    {
        this.unifySquad = unifySquad;
    }

    public String getUnifySquad() 
    {
        return unifySquad;
    }
    public void setUnifyVillage(String unifyVillage) 
    {
        this.unifyVillage = unifyVillage;
    }

    public String getUnifyVillage() 
    {
        return unifyVillage;
    }
    public void setUnifySzone(String unifySzone) 
    {
        this.unifySzone = unifySzone;
    }

    public String getUnifySzone() 
    {
        return unifySzone;
    }
    public void setUnifyStreet(String unifyStreet) 
    {
        this.unifyStreet = unifyStreet;
    }

    public String getUnifyStreet() 
    {
        return unifyStreet;
    }
    public void setUnifyDoor(String unifyDoor) 
    {
        this.unifyDoor = unifyDoor;
    }

    public String getUnifyDoor() 
    {
        return unifyDoor;
    }
    public void setUnifyResregion(String unifyResregion) 
    {
        this.unifyResregion = unifyResregion;
    }

    public String getUnifyResregion() 
    {
        return unifyResregion;
    }
    public void setUnifyBuilding(String unifyBuilding) 
    {
        this.unifyBuilding = unifyBuilding;
    }

    public String getUnifyBuilding() 
    {
        return unifyBuilding;
    }
    public void setUnifyBuildingNum(String unifyBuildingNum) 
    {
        this.unifyBuildingNum = unifyBuildingNum;
    }

    public String getUnifyBuildingNum() 
    {
        return unifyBuildingNum;
    }
    public void setUnifyUnit(String unifyUnit) 
    {
        this.unifyUnit = unifyUnit;
    }

    public String getUnifyUnit() 
    {
        return unifyUnit;
    }
    public void setUnifyFloor(String unifyFloor) 
    {
        this.unifyFloor = unifyFloor;
    }

    public String getUnifyFloor() 
    {
        return unifyFloor;
    }
    public void setUnifyRoom(String unifyRoom) 
    {
        this.unifyRoom = unifyRoom;
    }

    public String getUnifyRoom() 
    {
        return unifyRoom;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("unifyId", getUnifyId())
            .append("unifyCode", getUnifyCode())
            .append("unifyAddr", getUnifyAddr())
            .append("unifyLv", getUnifyLv())
            .append("unifyScore", getUnifyScore())
            .append("unifyLon", getUnifyLon())
            .append("unifyLat", getUnifyLat())
            .append("unifyLoc", getUnifyLoc())
            .append("unifyShape", getUnifyShape())
            .append("unifyCity", getUnifyCity())
            .append("unifyCounty", getUnifyCounty())
            .append("unifyTown", getUnifyTown())
            .append("unifyCommunity", getUnifyCommunity())
            .append("unifySquad", getUnifySquad())
            .append("unifyVillage", getUnifyVillage())
            .append("unifySzone", getUnifySzone())
            .append("unifyStreet", getUnifyStreet())
            .append("unifyDoor", getUnifyDoor())
            .append("unifyResregion", getUnifyResregion())
            .append("unifyBuilding", getUnifyBuilding())
            .append("unifyBuildingNum", getUnifyBuildingNum())
            .append("unifyUnit", getUnifyUnit())
            .append("unifyFloor", getUnifyFloor())
            .append("unifyRoom", getUnifyRoom())
            .append("roomFloor", getRoomFloor())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
