package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.domain.property.XlDeductionRecord;
import com.ruoyi.system.mapper.XlPropertyEventMapper;
import com.ruoyi.system.mapper.property.XlDeductionRecordMapper;
import com.ruoyi.system.service.property.IXlDeductionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 物业--考核扣分Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-26
 */
@Service
public class XlDeductionRecordServiceImpl implements IXlDeductionRecordService
{
    @Autowired
    private XlDeductionRecordMapper xlDeductionRecordMapper;

    @Autowired
    private XlPropertyEventMapper xlPropertyEventMapper;

    /**
     * 查询物业--考核扣分
     *
     * @param id 物业--考核扣分ID
     * @return 物业--考核扣分
     */
    @Override
    public XlDeductionRecord selectXlDeductionRecordById(Long id)
    {
        return xlDeductionRecordMapper.selectXlDeductionRecordById(id);
    }

    /**
     * 查询物业--考核扣分列表
     *
     * @param xlDeductionRecord 物业--考核扣分
     * @return 物业--考核扣分
     */
    @Override
    public List<XlDeductionRecord> selectXlDeductionRecordList(XlDeductionRecord xlDeductionRecord)
    {
        return xlDeductionRecordMapper.selectXlDeductionRecordList(xlDeductionRecord);
    }

    /**
     * 新增物业--考核扣分
     *
     * @param xlDeductionRecord 物业--考核扣分
     * @return 结果
     */
    @Override
    public int insertXlDeductionRecord(XlDeductionRecord xlDeductionRecord)
    {
        xlDeductionRecord.setCreateTime(DateUtils.getNowDate());
        return xlDeductionRecordMapper.insertXlDeductionRecord(xlDeductionRecord);
    }

    /**
     * 修改物业--考核扣分
     *
     * @param xlDeductionRecord 物业--考核扣分
     * @return 结果
     */
    @Override
    public int updateXlDeductionRecord(XlDeductionRecord xlDeductionRecord)
    {
        xlDeductionRecord.setUpdateTime(DateUtils.getNowDate());
        return xlDeductionRecordMapper.updateXlDeductionRecord(xlDeductionRecord);
    }

    /**
     * 删除物业--考核扣分对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlDeductionRecordByIds(String ids)
    {
        return xlDeductionRecordMapper.deleteXlDeductionRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业--考核扣分信息
     *
     * @param id 物业--考核扣分ID
     * @return 结果
     */
    @Override
    public int deleteXlDeductionRecordById(Long id)
    {
        return xlDeductionRecordMapper.deleteXlDeductionRecordById(id);
    }

    /**
     * 通过事件id查询扣分记录
     * @param eventId
     * @return
     */
    @Override
    public XlDeductionRecord selectDeductionRecordByEventId(Long eventId) {
        return xlDeductionRecordMapper.selectDeductionRecordByEventId(eventId);
    }

    /**
     * 通过事件id修改扣分记录
     * @param xlDeductionRecord
     * @return
     */
    @Override
    public int updateDeductionRecordByEventId(XlDeductionRecord xlDeductionRecord) {
        return xlDeductionRecordMapper.updateDeductionRecordByEventId(xlDeductionRecord);
    }

    /**
     * 关联查询
     * @param xlDeductionRecord
     * @return
     */
    @Override
    public List<XlDeductionRecord> selectXlDeductionRecordVoList(XlDeductionRecord xlDeductionRecord) {
        return xlDeductionRecordMapper.selectXlDeductionRecordVoList(xlDeductionRecord);
    }

    /**
     * 关联主键查询
     * @param id
     * @return
     */
    @Override
    public XlDeductionRecord selectXlDeductionRecordVoById(Long id) {
        return xlDeductionRecordMapper.selectXlDeductionRecordVoById(id);
    }

    /**
     * 物业考核
     */
    @Override
    @Transactional
    public void propertyEventExamine() {
        //查询所有待处理事件
        XlPropertyEvent xlPropertyEvent = new XlPropertyEvent();
        xlPropertyEvent.setEventStatus(1); //待处理
        //待处理事件集
        List<XlPropertyEvent> xlPropertyEventList =
                xlPropertyEventMapper.selectXlPropertyEventList(xlPropertyEvent);
        //根据事件的来源和事件的类型执行不同的考核标准
        for(XlPropertyEvent event: xlPropertyEventList){
            XlDeductionRecord xlDeductionRecord = new XlDeductionRecord();
            //事件
            Long eventId = event.getEventId();
            xlDeductionRecord.setEventId(eventId);
            //事件来源
            Integer eventSource = event.getEventSource();
            //事件类型
            Integer eventType = event.getEventType();
            //事件上报时间
            Date reportTime = event.getReportTime();
            //创建时间和修改时间
            xlDeductionRecord.setCreateTime(DateUtils.getNowDate());
            xlDeductionRecord.setUpdateTime(DateUtils.getNowDate());
            //当前时间
            Date currentTiem = new Date();
            //时间差
            Double difference = DateUtils.getHour(currentTiem, reportTime);
            //扣分记录
            XlDeductionRecord record =
                    xlDeductionRecordMapper.selectDeductionRecordByEventId(eventId);
            //扣分
            if(eventSource == 1 || eventSource == 2){ // 智慧监测事件 意见反馈
                if(difference > 0.5 && difference <= 2.0){ // 30分钟以上未处理
                    //一档扣分 扣0.01分
                    xlDeductionRecord.setDeductionNumber("0.01");
                    xlDeductionRecord.setAssessmentResults("一档扣分");
                    setRecord(record, xlDeductionRecord);
                }
                if(difference > 2.0 && difference <= 24.0) {//2小时以上未处理
                    //二档扣分 扣0.02分
                    xlDeductionRecord.setDeductionNumber("0.02");
                    xlDeductionRecord.setAssessmentResults("二档扣分");
                    setRecord(record, xlDeductionRecord);
                }
                if(difference > 24.0){ //24小时以上未处理
                    //三档扣分 扣0.03分
                    xlDeductionRecord.setDeductionNumber("0.03");
                    xlDeductionRecord.setAssessmentResults("三档扣分");
                    setRecord(record, xlDeductionRecord);
                }
            }
            if(eventSource == 3){ //报修维护
                if(difference > 2 && difference <= 24){ // 2小时以上未处理
                    //一档扣分 扣0.01分
                    xlDeductionRecord.setDeductionNumber("0.01");
                    xlDeductionRecord.setAssessmentResults("一档扣分");
                    setRecord(record, xlDeductionRecord);
                }
                if(difference > 24 && difference <= 72) {//24小时以上未处理
                    //二档扣分 扣0.02分
                    xlDeductionRecord.setDeductionNumber("0.02");
                    xlDeductionRecord.setAssessmentResults("二档扣分");
                    setRecord(record, xlDeductionRecord);
                }
                if(difference > 72){ //72小时以上未处理
                    //三档扣分 扣0.03分
                    xlDeductionRecord.setDeductionNumber("0.03");
                    xlDeductionRecord.setAssessmentResults("三档扣分");
                    setRecord(record, xlDeductionRecord);
                }
            }
        }
    }

    //扣分设置
    private void setRecord(XlDeductionRecord oldRecord, XlDeductionRecord newRecord){
        if(null != oldRecord){ //判断是否已有扣分记录
            //已有扣分记录 修改
            xlDeductionRecordMapper.updateDeductionRecordByEventId(newRecord);
        }else{
            //无扣分记录 新增
            xlDeductionRecordMapper.insertXlDeductionRecord(newRecord);
        }
    }

}
