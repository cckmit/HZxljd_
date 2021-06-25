package com.ruoyi.system.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 事件分类表"
 */
public class HkEClassification implements Serializable {

    /**
     * 主键"
     */

    private Integer ec_id;
    /**
     * 事件分类状态"
     */

    private String ec_type;
    /**
     * 事件类型
     */
    private String ec_category;
    /**
     * 事件code
     */
    private String ec_name_type;
    /**
     * 事件名称"
     */
    private String ec_name;
    /**
     * 事件创建人"
     */
     private  String ec_ids;

     private boolean flag = false;

    public String getEc_name_type() {
        return ec_name_type;
    }

    public void setEc_name_type(String ec_name_type) {
        this.ec_name_type = ec_name_type;
    }

    public String getEc_ids() {
        return ec_ids;
    }

    public void setEc_ids(String ec_ids) {
        this.ec_ids = ec_ids;
    }

    private String ec_admin;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Date getEc_created_time() {
        return ec_created_time;
    }

    public void setEc_created_time(Date ec_created_time) {
        this.ec_created_time = ec_created_time;
    }

    public String getEc_bei() {
        return ec_bei;
    }

    public void setEc_bei(String ec_bei) {
        this.ec_bei = ec_bei;
    }

    public String ec_bei;
    /**
     * 事件创建时间"
     */
    private Date ec_created_time;
    /**
     * 事件修改时间"
     */
    private Date ec_update_time;

    public String getEc_category() {
        return ec_category;
    }

    public void setEc_category(String ec_category) {
        this.ec_category = ec_category;
    }

    public Integer getEc_id() {
        return ec_id;
    }

    public void setEc_id(Integer ec_id) {
        this.ec_id = ec_id;
    }

    public String getEc_type() {
        return ec_type;
    }

    public void setEc_type(String ec_type) {
        this.ec_type = ec_type;
    }

    public String getEc_name() {
        return ec_name;
    }

    public void setEc_name(String ec_name) {
        this.ec_name = ec_name;
    }

    public String getEc_admin() {
        return ec_admin;
    }

    public void setEc_admin(String ec_admin) {
        this.ec_admin = ec_admin;
    }


    public Date getEc_update_time() {
        return ec_update_time;
    }

    public void setEc_update_time(Date ec_update_time) {
        this.ec_update_time = ec_update_time;
    }
}
