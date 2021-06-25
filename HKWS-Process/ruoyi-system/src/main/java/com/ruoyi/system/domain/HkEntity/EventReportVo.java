package com.ruoyi.system.domain.HkEntity;


import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;

import java.io.Serializable;

/**
 * 事件详情
 * @author: Lijiajia8
 * @date: 2020/4/30 9:51
 * @since: jdk1.8
 */
public class EventReportVo implements Serializable {

    /** 事件信息 */
    private HkEventInfo event;

    /** 点位 */
    private PointDTO point;

    public HkEventInfo getEvent() {
        return event;
    }

    public void setEvent(HkEventInfo event) {
        this.event = event;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }
}
