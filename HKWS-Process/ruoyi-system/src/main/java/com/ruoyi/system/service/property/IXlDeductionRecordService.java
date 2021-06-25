package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlDeductionRecord;

import java.util.List;

/**
 * 物业--考核扣分Service接口
 *
 * @author ruoyi
 * @date 2021-05-26
 */
public interface IXlDeductionRecordService
{
    /**
     * 查询物业--考核扣分
     *
     * @param id 物业--考核扣分ID
     * @return 物业--考核扣分
     */
    public XlDeductionRecord selectXlDeductionRecordById(Long id);

    /**
     * 查询物业--考核扣分列表
     *
     * @param xlDeductionRecord 物业--考核扣分
     * @return 物业--考核扣分集合
     */
    public List<XlDeductionRecord> selectXlDeductionRecordList(XlDeductionRecord xlDeductionRecord);

    /**
     * 新增物业--考核扣分
     *
     * @param xlDeductionRecord 物业--考核扣分
     * @return 结果
     */
    public int insertXlDeductionRecord(XlDeductionRecord xlDeductionRecord);

    /**
     * 修改物业--考核扣分
     *
     * @param xlDeductionRecord 物业--考核扣分
     * @return 结果
     */
    public int updateXlDeductionRecord(XlDeductionRecord xlDeductionRecord);

    /**
     * 批量删除物业--考核扣分
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlDeductionRecordByIds(String ids);

    /**
     * 删除物业--考核扣分信息
     *
     * @param id 物业--考核扣分ID
     * @return 结果
     */
    public int deleteXlDeductionRecordById(Long id);

    /**
     * 通过事件id查询扣分记录
     * @param eventId
     * @return
     */
    public XlDeductionRecord selectDeductionRecordByEventId(Long eventId);

    /**
     * 通过事件id修改扣分记录
     * @param xlDeductionRecord
     * @return
     */
    public int updateDeductionRecordByEventId(XlDeductionRecord xlDeductionRecord);

    /**
     * 关联查询
     * @param xlDeductionRecord
     * @return
     */
    public List<XlDeductionRecord> selectXlDeductionRecordVoList(XlDeductionRecord xlDeductionRecord);

    /**
     * 关联主键查询
     * @param id
     * @return
     */
    public XlDeductionRecord selectXlDeductionRecordVoById(Long id);

    /**
     * 物业考核
     */
    public void propertyEventExamine();
}
