package com.ruoyi.system.domain.platform.zheLiFang;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.CollectionUtils;


/**
* @author xyq
* @date 2021
* 类说明: 统一地址库返回实体类
*/
public class GatewayUnifyAddress implements Serializable {

	//0 表示成功，其它数字为错误编码
	private int code;
	private String msg;
	private boolean success;
	private DataVo data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public DataVo getData() {
		return data;
	}

	public void setData(DataVo data) {
		this.data = data;
	}

	public static class DataVo {
		//搜索结果总数
		private int count;
		private List<AddrList> addrList;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public List<AddrList> getAddrList() {
			return addrList;
		}

		public void setAddrList(List<AddrList> addrList) {
			this.addrList = addrList;
		}

		public static class AddrList {
			private Loc loc;
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

			public Loc getLoc() {
				return loc;
			}

			public void setLoc(Loc loc) {
				this.loc = loc;
			}

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

			//地址经纬度
			public class Loc {
				
				private List<String> coordinates;
				private String type;

				public List<String> getCoordinates() {
					return coordinates;
				}

				public void setCoordinates(List<String> coordinates) {
					this.coordinates = coordinates;
				}

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}
			}
			
		}

	}

}
