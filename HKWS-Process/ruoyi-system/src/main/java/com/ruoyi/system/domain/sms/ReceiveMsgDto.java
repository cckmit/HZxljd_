package com.ruoyi.system.domain.sms;

import java.io.Serializable;

/**
 * 普通短信
 */
public class ReceiveMsgDto implements Serializable {

    /**状态码**/
    private String reportStatus;
    /**回执手机号**/
    private String mobile;
    /**提交时间**/
    private String submitDate;
    /**接受时间**/
    private String receiveDate;
    /**发送失败状态码**/
    private String errorCode;
    /**消息批次号**/
    private String msgGroup;

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(String msgGroup) {
        this.msgGroup = msgGroup;
    }
}
