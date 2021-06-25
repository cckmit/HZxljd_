package com.ruoyi.system.domain.DuanXin;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author FanKaibiao
 * @date 2021-03-02-16:22
 * 发送短信相应实体
 */
public class SendRes  extends BaseEntity {

    private String rspcod;	//响应状态码
    private String msgGroup;	//消息批次号，由云MAS平台生成，用于验证短信提交报告和状态报告的一致性（取值msgGroup）注:如果数据验证不通过msgGroup为空
    private boolean success;	//数据校验结果

    public String getRspcod() {
        return rspcod;
    }

    public void setRspcod(String rspcod) {
        this.rspcod = rspcod;
    }

    public String getMsgGroup() {
        return msgGroup;
    }

    public void setMsgGroup(String msgGroup) {
        this.msgGroup = msgGroup;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
