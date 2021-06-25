package com.ruoyi.system.domain;

import java.io.Serializable;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * 授权管理表
 */
public class HkAManagement implements Serializable {

    /**
     * 主键
     */

    private Integer amid;
    /**
     * 对象接入码
     */
    private String amcode;
    /**
     * 对象接入名称
     */
    private String amname;
    /**
     * 对象接入状态
     */
    private String amtype;
    /**
     * 创建人
     */
    private String amadmin;
    /**
     * 加密类型
     */
  private String   amsecrettype;
    /**
     * 加密公钥
     */

    private String  amsecretkey;
    /**
     * 加密私钥
     */
    private String amsecreprivate;
    /**
     * 生效时间
     */

    private String ameffectivedate;
    /**
     * 失效日期
     */

    private String amexpirationdate;
    /**
     * 创建时间
     */




    private String amcreatedate;

    private int months;


    public Integer getAmid() {
        return amid;
    }

    public void setAmid(Integer amid) {
        this.amid = amid;
    }

    public String getAmcode() {
        return amcode;
    }

    public void setAmcode(String amcode) {
        this.amcode = amcode;
    }

    public String getAmname() {
        return amname;
    }

    public void setAmname(String amname) {
        this.amname = amname;
    }

    public String getAmtype() {
        return amtype;
    }

    public void setAmtype(String amtype) {
        this.amtype = amtype;
    }

    public String getAmadmin() {
        return amadmin;
    }

    public void setAmadmin(String amadmin) {
        this.amadmin = amadmin;
    }

    public String getAmsecrettype() {
        return amsecrettype;
    }

    public void setAmsecrettype(String amsecrettype) {
        this.amsecrettype = amsecrettype;
    }

    public String getAmsecretkey() {
        return amsecretkey;
    }

    public void setAmsecretkey(String amsecretkey) {
        this.amsecretkey = amsecretkey;
    }

    public String getAmsecreprivate() {
        return amsecreprivate;
    }

    public void setAmsecreprivate(String amsecreprivate) {
        this.amsecreprivate = amsecreprivate;
    }

    public String getAmeffectivedate() {
        return ameffectivedate;
    }

    public void setAmeffectivedate(String ameffectivedate) {
        this.ameffectivedate = ameffectivedate;
    }

    public String getAmexpirationdate() {
        return amexpirationdate;
    }

    public void setAmexpirationdate(String amexpirationdate) {
        this.amexpirationdate = amexpirationdate;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getAmcreatedate() {
        return amcreatedate;
    }

    public void setAmcreatedate(String amcreatedate) {
        this.amcreatedate = amcreatedate;
    }

    public int getMonths() {
        return months;
    }
}
