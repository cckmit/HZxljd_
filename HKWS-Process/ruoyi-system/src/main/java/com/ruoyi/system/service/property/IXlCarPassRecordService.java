package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlCarPassRecord;

import java.util.List;

/**
 * 物业--车辆进出记录Service接口
 *
 * @author ruoyi
 * @date 2021-06-09
 */
public interface IXlCarPassRecordService
{
    /**
     * 查询物业--车辆进出记录
     *
     * @param recordId 物业--车辆进出记录ID
     * @return 物业--车辆进出记录
     */
    public XlCarPassRecord selectXlCarPassRecordById(Long recordId);

    /**
     * 查询物业--车辆进出记录列表
     *
     * @param xlCarPassRecord 物业--车辆进出记录
     * @return 物业--车辆进出记录集合
     */
    public List<XlCarPassRecord> selectXlCarPassRecordList(XlCarPassRecord xlCarPassRecord);

    /**
     * 新增物业--车辆进出记录
     *
     * @param xlCarPassRecord 物业--车辆进出记录
     * @return 结果
     */
    public int insertXlCarPassRecord(XlCarPassRecord xlCarPassRecord);

    /**
     * 修改物业--车辆进出记录
     *
     * @param xlCarPassRecord 物业--车辆进出记录
     * @return 结果
     */
    public int updateXlCarPassRecord(XlCarPassRecord xlCarPassRecord);

    /**
     * 批量删除物业--车辆进出记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlCarPassRecordByIds(String ids);

    /**
     * 删除物业--车辆进出记录信息
     *
     * @param recordId 物业--车辆进出记录ID
     * @return 结果
     */
    public int deleteXlCarPassRecordById(Long recordId);
}
