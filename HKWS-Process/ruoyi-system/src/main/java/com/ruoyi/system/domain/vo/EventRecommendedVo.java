package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;

public class EventRecommendedVo {

    private HkEventInfo hkEventInfo;

    private CenterConfirmUserVo centerConfirmUserVo;

    public HkEventInfo getHkEventInfo() {
        return hkEventInfo;
    }

    public void setHkEventInfo(HkEventInfo hkEventInfo) {
        this.hkEventInfo = hkEventInfo;
    }

    public CenterConfirmUserVo getCenterConfirmUserVo() {
        return centerConfirmUserVo;
    }

    public void setCenterConfirmUserVo(CenterConfirmUserVo centerConfirmUserVo) {
        this.centerConfirmUserVo = centerConfirmUserVo;
    }
}
