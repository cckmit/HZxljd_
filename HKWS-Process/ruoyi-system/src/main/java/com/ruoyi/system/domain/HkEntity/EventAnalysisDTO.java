package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;
import java.util.List;

/**
 * 事件报文解析实体类
 * @author: Lijiajia8
 * @date: 2020/4/30 9:42
 * @since: jdk1.8
 */
public class EventAnalysisDTO implements Serializable {
    /** 组件标识 */
    private String componentId;

    /** 事件详情 */
    private EventInfoDTO eventInfo;

    /** 事件处理记录 */
    private List<EventProcessRecordDTO> processRecord;

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public EventInfoDTO getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfoDTO eventInfo) {
        this.eventInfo = eventInfo;
    }

    public List<EventProcessRecordDTO> getProcessRecord() {
        return processRecord;
    }

    public void setProcessRecord(List<EventProcessRecordDTO> processRecord) {
        this.processRecord = processRecord;
    }

    public EventAnalysisDTO() {
    }

    public EventAnalysisDTO(String componentId, EventInfoDTO eventInfo, List<EventProcessRecordDTO> processRecord) {
        this.componentId = componentId;
        this.eventInfo = eventInfo;
        this.processRecord = processRecord;
    }

    @Override
    public String toString() {
        return "EventAnalysisDTO{" +
                "componentId='" + componentId + '\'' +
                ", eventInfo=" + eventInfo +
                ", processRecord=" + processRecord +
                '}';
    }


}
