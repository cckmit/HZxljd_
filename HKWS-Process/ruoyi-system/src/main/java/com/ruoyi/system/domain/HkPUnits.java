package com.ruoyi.system.domain;



import java.util.Date;


public class HkPUnits {


    private Integer pu_id;

    private String pu_name;

    private Date pu_create_time;

    private Date pu_update_time;

    public Integer getPu_id() {
        return pu_id;
    }

    public void setPu_id(Integer pu_id) {
        this.pu_id = pu_id;
    }

    public String getPu_name() {
        return pu_name;
    }

    public void setPu_name(String pu_name) {
        this.pu_name = pu_name;
    }

    public Date getPu_create_time() {
        return pu_create_time;
    }

    public void setPu_create_time(Date pu_create_time) {
        this.pu_create_time = pu_create_time;
    }

    public Date getPu_update_time() {
        return pu_update_time;
    }

    public void setPu_update_time(Date pu_update_time) {
        this.pu_update_time = pu_update_time;
    }
}
