package com.ruoyi.system.domain.HkEarlyWarning;

import java.io.Serializable;

/**
 * 一期一档事件返回字段
 */
public class HkEventStageVo implements Serializable {

    /**日期类型**/
    private String dateType;
    /**区域**/
    private String regionName;
    /**事件总数量**/
    private Integer eventCount;
    /**完结数量**/
    private Integer doneCount;
    /**正在处置数**/
    private Integer doingCount;
    /**研判数量**/
    private Integer judgeCount;

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getDoneCount() {
        return doneCount;
    }

    public void setDoneCount(Integer doneCount) {
        this.doneCount = doneCount;
    }

    public Integer getDoingCount() {
        return doingCount;
    }

    public void setDoingCount(Integer doingCount) {
        this.doingCount = doingCount;
    }

    public Integer getJudgeCount() {
        return judgeCount;
    }

    public void setJudgeCount(Integer judgeCount) {
        this.judgeCount = judgeCount;
    }
}
