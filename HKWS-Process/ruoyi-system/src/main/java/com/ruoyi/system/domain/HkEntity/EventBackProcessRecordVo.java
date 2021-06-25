package com.ruoyi.system.domain.HkEntity;

import java.io.Serializable;
import java.util.Date;

public class EventBackProcessRecordVo implements Serializable {

    /**处置人id**/
    private String  processUserId;
    /**处置时间**/
    private Date    processTime;
    /**状态（1重新指派 2 指派，3签收，4已处置 5退回,6中心处置，7忽略，8异常报送）**/
    private String  processStatus;
    /**处置结果**/
    private String  processResult;
    /**处置意见**/
    private String  processOpinion;

    public String getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(String processUserId) {
        this.processUserId = processUserId;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessResult() {
        return processResult;
    }

    public void setProcessResult(String processResult) {
        this.processResult = processResult;
    }

    public String getProcessOpinion() {
        return processOpinion;
    }

    public void setProcessOpinion(String processOpinion) {
        this.processOpinion = processOpinion;
    }
}
