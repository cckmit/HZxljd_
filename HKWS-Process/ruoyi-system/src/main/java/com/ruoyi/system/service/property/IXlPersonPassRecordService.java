package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlPersonPassRecord;

import java.util.List;

/**
 * 物业--人员进出记录Service接口
 *
 * @author ruoyi
 * @date 2021-06-09
 */
public interface IXlPersonPassRecordService
{
    /**
     * 查询物业--人员进出记录
     *
     * @param recordId 物业--人员进出记录ID
     * @return 物业--人员进出记录
     */
    public XlPersonPassRecord selectXlPersonPassRecordById(Long recordId);

    /**
     * 查询物业--人员进出记录列表
     *
     * @param xlPersonPassRecord 物业--人员进出记录
     * @return 物业--人员进出记录集合
     */
    public List<XlPersonPassRecord> selectXlPersonPassRecordList(XlPersonPassRecord xlPersonPassRecord);

    /**
     * 新增物业--人员进出记录
     *
     * @param xlPersonPassRecord 物业--人员进出记录
     * @return 结果
     */
    public int insertXlPersonPassRecord(XlPersonPassRecord xlPersonPassRecord);

    /**
     * 修改物业--人员进出记录
     *
     * @param xlPersonPassRecord 物业--人员进出记录
     * @return 结果
     */
    public int updateXlPersonPassRecord(XlPersonPassRecord xlPersonPassRecord);

    /**
     * 批量删除物业--人员进出记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPersonPassRecordByIds(String ids);

    /**
     * 删除物业--人员进出记录信息
     *
     * @param recordId 物业--人员进出记录ID
     * @return 结果
     */
    public int deleteXlPersonPassRecordById(Long recordId);
}
