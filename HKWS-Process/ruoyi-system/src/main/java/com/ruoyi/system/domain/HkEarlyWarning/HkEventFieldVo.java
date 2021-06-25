package com.ruoyi.system.domain.HkEarlyWarning;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.utils.StringUtils;

import java.io.Serializable;

/**
 * 一域一档事件列表返回字段
 */
public class HkEventFieldVo implements Serializable {

    /**区域code**/
    private String regionCode;
    /**区域**/
    @Excel(name="社区名称")
    private String regionName;
    /**事件数量**/
    @Excel(name="事件总数（件）")
    private Integer eventCount;
    /**研判数量**/
    @Excel(name="研判数量（件）")
    private Integer judgeCount;
    /**正在处置数**/
    @Excel(name="正在处置数（件）")
    private Integer doingCount;
    /**完结数量**/
    @Excel(name="完结总数（件）")
    private Integer doneCount;
    /**流转率**/
    @Excel(name="流转率（%）")
    private String transferRate;
    /**共治率**/
    @Excel(name="共治率（%）")
    private String sharedGoverRate;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getEventCount() {
        return eventCount == null?0:eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getDoneCount() {
        return doneCount==null?0:doneCount;
    }

    public void setDoneCount(Integer doneCount) {
        this.doneCount = doneCount;
    }

    public Integer getDoingCount() {
        return doingCount==null?0:doingCount;
    }

    public void setDoingCount(Integer doingCount) {
        this.doingCount = doingCount;
    }

    public Integer getJudgeCount() {
        return judgeCount==null?0:judgeCount;
    }

    public void setJudgeCount(Integer judgeCount) {
        this.judgeCount = judgeCount;
    }

    public String getTransferRate() {
        if(StringUtils.isEmpty(transferRate)){
            transferRate = "0.00";
        }
        return transferRate;
    }

    public void setTransferRate(String transferRate) {
        this.transferRate = transferRate;
    }

    public String getSharedGoverRate() {
        if(StringUtils.isEmpty(sharedGoverRate)){
            sharedGoverRate = "0.00";
        }
        return sharedGoverRate;
    }

    public void setSharedGoverRate(String sharedGoverRate) {
        this.sharedGoverRate = sharedGoverRate;
    }
}
