package com.ruoyi.system.domain.platform.enterPrise;



/**
 * Copyright 2021 json.cn
 */

import java.io.Serializable;

/**
 * Auto-generated: 2021-05-25 11:21:11
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class enterPriseParm implements Serializable {

    private enterPriseResult Result;
    private String Status;
    private String Message;
    private String OrderNumber;

    public enterPriseResult getResult() {
        return Result;
    }

    public void setResult(enterPriseResult result) {
        Result = result;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public String getStatus() {
        return Status;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    public String getMessage() {
        return Message;
    }

    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }
    public String getOrderNumber() {
        return OrderNumber;
    }

}
