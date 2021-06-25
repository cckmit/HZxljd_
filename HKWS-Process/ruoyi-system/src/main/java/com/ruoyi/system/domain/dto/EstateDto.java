package com.ruoyi.system.domain.dto;

/**
 * 类名称:EstateDto
 * 类描述:统计物业信息数量
 * 创建时间 : 2021/6/17 11:48
 */

public class EstateDto {

    /**
     * 物业名称
     */
    private String estateName;
    /***
     * 待处理事件数量
     */
    private Integer eventStatusOne;
    /***
     * 处理中事件数量
     */
    private Integer eventStatusTwo;
    /***
     * 已处理事件数量
     */
    private Integer eventStatusThree;
    /***
     * 智慧监测事件数量
     */
    private Integer eventSourceOne;
    /***
     * 意见反馈事件数量
     */
    private Integer eventSourceTwo;
    /***
     * 报修维护事件数量
     */
    private Integer eventSourceThree;
    /***
     * 整改工程事件数量
     */
    private Integer eventSourceFour;
    /***
     * 巡更巡防事件数量
     */
    private Integer eventSourceFive;
    /***
     * 楼幢数量
     */
    private Integer buildingNumber;
    /***
     * 房屋数量
     */
    private Integer roomNumber;
    /***
     * 业主数量
     */
    private Integer rightNumber;
    /***
     * 车辆数量
     */
    private Integer carNumber;
    /***
     * 设备数量
     */
    private Integer equipmentNumber;



    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public Integer getEventStatusOne() {
        return eventStatusOne;
    }

    public void setEventStatusOne(Integer eventStatusOne) {
        this.eventStatusOne = eventStatusOne;
    }

    public Integer getEventStatusTwo() {
        return eventStatusTwo;
    }

    public void setEventStatusTwo(Integer eventStatusTwo) {
        this.eventStatusTwo = eventStatusTwo;
    }

    public Integer getEventStatusThree() {
        return eventStatusThree;
    }

    public void setEventStatusThree(Integer eventStatusThree) {
        this.eventStatusThree = eventStatusThree;
    }

    public Integer getEventSourceOne() {
        return eventSourceOne;
    }

    public void setEventSourceOne(Integer eventSourceOne) {
        this.eventSourceOne = eventSourceOne;
    }

    public Integer getEventSourceThree() {
        return eventSourceThree;
    }

    public void setEventSourceThree(Integer eventSourceThree) {
        this.eventSourceThree = eventSourceThree;
    }

    public Integer getEventSourceFour() {
        return eventSourceFour;
    }

    public void setEventSourceFour(Integer eventSourceFour) {
        this.eventSourceFour = eventSourceFour;
    }

    public Integer getEventSourceFive() {
        return eventSourceFive;
    }

    public void setEventSourceFive(Integer eventSourceFive) {
        this.eventSourceFive = eventSourceFive;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRightNumber() {
        return rightNumber;
    }

    public void setRightNumber(Integer rightNumber) {
        this.rightNumber = rightNumber;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(Integer equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Integer getEventSourceTwo() {
        return eventSourceTwo;
    }

    public void setEventSourceTwo(Integer eventSourceTwo) {
        this.eventSourceTwo = eventSourceTwo;
    }
}
