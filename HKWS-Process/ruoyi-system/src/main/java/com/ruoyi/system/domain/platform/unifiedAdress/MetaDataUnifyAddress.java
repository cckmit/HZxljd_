package com.ruoyi.system.domain.platform.unifiedAdress;


import java.io.Serializable;

/**
 * 元数据  同一地址库
 * @author xyq
 *
 */
public class MetaDataUnifyAddress implements Serializable {

	//门牌
	private String door;
	//结果地址对应的标准地址编码
	private String code;
	//街道
	private String town;
	//市
	private String city;
	//县
	private String county;
	/**
	 * 地址层级（1.市 2.县 3 街道 4 社区 5.行政组 6.自然村
	 *7.专业区 8.街路巷 9.门牌 10.小区 11.建筑物 12.楼牌 1
	 *3.单元 14.楼层 15.户室）
	 */
	private Integer lv;
	//社区
	private String community;
	//楼牌
	private String building_num;
	//建筑物
	private String building;
	//户室
	private String room;
	//小区
	private String resregion;
	//专业区
	private String szone;
	//单元
	private String unit;
	//行政组
	private String squad;
	//街路巷
	private String street;
	//结果地址
	private String addr;
	//自然村
	private String village;
	//楼层
	private String floor;
	//房间所属楼层
	private int room_floor;
	//地址结果评分
	private double score;
	//地址空间面信息
	private String shape;
	private String lat;
	private String lng;

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getLv() {
		return lv;
	}

	public void setLv(Integer lv) {
		this.lv = lv;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getBuilding_num() {
		return building_num;
	}

	public void setBuilding_num(String building_num) {
		this.building_num = building_num;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getResregion() {
		return resregion;
	}

	public void setResregion(String resregion) {
		this.resregion = resregion;
	}

	public String getSzone() {
		return szone;
	}

	public void setSzone(String szone) {
		this.szone = szone;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSquad() {
		return squad;
	}

	public void setSquad(String squad) {
		this.squad = squad;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getRoom_floor() {
		return room_floor;
	}

	public void setRoom_floor(int room_floor) {
		this.room_floor = room_floor;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
}
