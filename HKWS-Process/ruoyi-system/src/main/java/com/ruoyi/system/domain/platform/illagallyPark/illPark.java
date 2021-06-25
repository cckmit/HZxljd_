package com.ruoyi.system.domain.platform.illagallyPark;


import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2021-05-19 17:1:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class illPark implements Serializable {

    private String recordid;
    private String plateno;
    private String parkingAddress;
    private String status;
    private int emphasesArea;
    private String source;
    private String name;
    private String orgname;
    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }
    public String getRecordid() {
        return recordid;
    }

    public void setPlateno(String plateno) {
        this.plateno = plateno;
    }
    public String getPlateno() {
        return plateno;
    }



    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public int getEmphasesArea() {
        return emphasesArea;
    }

    public void setEmphasesArea(int emphasesArea) {
        this.emphasesArea = emphasesArea;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getSource() {
        return source;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
    public String getOrgname() {
        return orgname;
    }

}

