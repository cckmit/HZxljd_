package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;

/**
 * @author FanKaibiao
 * @date 2021-02-23-16:40
 */
public class LicensePlateDTO implements Serializable {

    /**
     * 号牌号码
     */
    private String VIEW_SJH_CPH_HPHM;
    /**
     * 车辆品牌
     */
    private String VIEW_SJH_CPH_CLPP1;
    /**
     * 车辆种类
     */
    private String VIEW_SJH_CPH_HPZL;
    /**
     * 联系方式
     */
    private String VIEW_SJH_CPH_LXFS;
    /**
     * 姓名
     */
    private String VIEW_SJH_CPH_XM;

    public String getVIEW_SJH_CPH_HPHM() {
        return VIEW_SJH_CPH_HPHM;
    }

    public void setVIEW_SJH_CPH_HPHM(String VIEW_SJH_CPH_HPHM) {
        this.VIEW_SJH_CPH_HPHM = VIEW_SJH_CPH_HPHM;
    }

    public String getVIEW_SJH_CPH_CLPP1() {
        return VIEW_SJH_CPH_CLPP1;
    }

    public void setVIEW_SJH_CPH_CLPP1(String VIEW_SJH_CPH_CLPP1) {
        this.VIEW_SJH_CPH_CLPP1 = VIEW_SJH_CPH_CLPP1;
    }

    public String getVIEW_SJH_CPH_HPZL() {
        return VIEW_SJH_CPH_HPZL;
    }

    public void setVIEW_SJH_CPH_HPZL(String VIEW_SJH_CPH_HPZL) {
        this.VIEW_SJH_CPH_HPZL = VIEW_SJH_CPH_HPZL;
    }

    public String getVIEW_SJH_CPH_LXFS() {
        return VIEW_SJH_CPH_LXFS;
    }

    public void setVIEW_SJH_CPH_LXFS(String VIEW_SJH_CPH_LXFS) {
        this.VIEW_SJH_CPH_LXFS = VIEW_SJH_CPH_LXFS;
    }

    public String getVIEW_SJH_CPH_XM() {
        return VIEW_SJH_CPH_XM;
    }

    public void setVIEW_SJH_CPH_XM(String VIEW_SJH_CPH_XM) {
        this.VIEW_SJH_CPH_XM = VIEW_SJH_CPH_XM;
    }
}
