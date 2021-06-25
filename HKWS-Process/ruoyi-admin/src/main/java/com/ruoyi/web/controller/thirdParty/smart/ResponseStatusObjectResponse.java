package com.ruoyi.web.controller.thirdParty.smart;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ResponseStatusObjectRespone
 *
 * @author lcl
 * @date: 2021/4/23
 **/
public class ResponseStatusObjectResponse {

    @JsonProperty("RequestURL")
    private String requestURL;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("StatusString")
    private String StatusString;

    @JsonProperty("ID")
    private String iD;

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusString() {
        return StatusString;
    }

    public void setStatusString(String statusString) {
        StatusString = statusString;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }
}
