package com.ruoyi.system.domain.honey;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author: Wu
 * @date: 2021-06-10 15:39
 * @description:
 */
public class HousingStatistics extends BaseEntity {
    /**
     * 常住人口
     */
    private Long livePeopleCont;
    /**
     * 流动人口
     */
    private Long movingPeopleCont;
    /**
     * 重点人口
     */
    private Long keyPointPeopleCont;
    /**
     * 房屋信息
     */
    private Long housInfoCont;
    /**
     * 店铺信息
     */
    private Long shopInfoCont;
    /**
     * 企业信息
     */
    private Long companyInfoCont;
    /**
     * 救援物资
     */
    private Long reliefMateriaCont;

    public Long getLivePeopleCont() {
        return livePeopleCont;
    }

    public void setLivePeopleCont(Long livePeopleCont) {
        this.livePeopleCont = livePeopleCont;
    }

    public Long getMovingPeopleCont() {
        return movingPeopleCont;
    }

    public void setMovingPeopleCont(Long movingPeopleCont) {
        this.movingPeopleCont = movingPeopleCont;
    }

    public Long getKeyPointPeopleCont() {
        return keyPointPeopleCont;
    }

    public void setKeyPointPeopleCont(Long keyPointPeopleCont) {
        this.keyPointPeopleCont = keyPointPeopleCont;
    }

    public Long getHousInfoCont() {
        return housInfoCont;
    }

    public void setHousInfoCont(Long housInfoCont) {
        this.housInfoCont = housInfoCont;
    }

    public Long getShopInfoCont() {
        return shopInfoCont;
    }

    public void setShopInfoCont(Long shopInfoCont) {
        this.shopInfoCont = shopInfoCont;
    }

    public Long getCompanyInfoCont() {
        return companyInfoCont;
    }

    public void setCompanyInfoCont(Long companyInfoCont) {
        this.companyInfoCont = companyInfoCont;
    }

    public Long getReliefMateriaCont() {
        return reliefMateriaCont;
    }

    public void setReliefMateriaCont(Long reliefMateriaCont) {
        this.reliefMateriaCont = reliefMateriaCont;
    }

    @Override
    public String toString() {
        return "HousingStatistics{" +
                "livePeopleCont=" + livePeopleCont +
                ", movingPeopleCont=" + movingPeopleCont +
                ", keyPointPeopleCont=" + keyPointPeopleCont +
                ", housInfoCont=" + housInfoCont +
                ", shopInfoCont=" + shopInfoCont +
                ", companyInfoCont=" + companyInfoCont +
                ", reliefMateriaCont=" + reliefMateriaCont +
                '}';
    }
}
