package com.ruoyi.system.domain;



import java.io.Serializable;
import java.util.Date;


/**
 * (HkRentHouseDoor)表实体类
 *
 * @author makejava
 * @since 2021-04-09 11:32:37
 */
@SuppressWarnings("serial")
public class HkRentHouseDoor implements Serializable {

    private Integer id;
    //房源编号
    private String houseCode;
    //1开门  2关门 3异常
    private String doorStatus;
    //发生时间
    private Date processTime;
    //事件接受时间
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(String doorStatus) {
        this.doorStatus = doorStatus;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */

}
