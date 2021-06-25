package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;

/**
 * 事件处理结果
 * @author: Lijiajia8
 * @date: 2020/4/30 11:27
 * @since: jdk1.8
 */
public class EventProcessResultDTO  implements Serializable {
    /** 处理结果类型 */
    private Integer resultType;

    /** 处理结果类型名称 */
    private String resultTypeName;

    /** 处理结果 */
    private String result;

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public String getResultTypeName() {
        return resultTypeName;
    }

    public void setResultTypeName(String resultTypeName) {
        this.resultTypeName = resultTypeName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
