package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlCarPassRecord;
import com.ruoyi.system.mapper.property.XlCarPassRecordMapper;
import com.ruoyi.system.service.property.IXlCarPassRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业--车辆进出记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-09
 */
@Service
public class XlCarPassRecordServiceImpl implements IXlCarPassRecordService
{
    @Autowired
    private XlCarPassRecordMapper xlCarPassRecordMapper;

    /**
     * 查询物业--车辆进出记录
     *
     * @param recordId 物业--车辆进出记录ID
     * @return 物业--车辆进出记录
     */
    @Override
    public XlCarPassRecord selectXlCarPassRecordById(Long recordId)
    {
        return xlCarPassRecordMapper.selectXlCarPassRecordById(recordId);
    }

    /**
     * 查询物业--车辆进出记录列表
     *
     * @param xlCarPassRecord 物业--车辆进出记录
     * @return 物业--车辆进出记录
     */
    @Override
    public List<XlCarPassRecord> selectXlCarPassRecordList(XlCarPassRecord xlCarPassRecord)
    {
        return xlCarPassRecordMapper.selectXlCarPassRecordList(xlCarPassRecord);
    }

    /**
     * 新增物业--车辆进出记录
     *
     * @param xlCarPassRecord 物业--车辆进出记录
     * @return 结果
     */
    @Override
    public int insertXlCarPassRecord(XlCarPassRecord xlCarPassRecord)
    {
        return xlCarPassRecordMapper.insertXlCarPassRecord(xlCarPassRecord);
    }

    /**
     * 修改物业--车辆进出记录
     *
     * @param xlCarPassRecord 物业--车辆进出记录
     * @return 结果
     */
    @Override
    public int updateXlCarPassRecord(XlCarPassRecord xlCarPassRecord)
    {
        xlCarPassRecord.setUpdateTime(DateUtils.getNowDate());
        return xlCarPassRecordMapper.updateXlCarPassRecord(xlCarPassRecord);
    }

    /**
     * 删除物业--车辆进出记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlCarPassRecordByIds(String ids)
    {
        return xlCarPassRecordMapper.deleteXlCarPassRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业--车辆进出记录信息
     *
     * @param recordId 物业--车辆进出记录ID
     * @return 结果
     */
    @Override
    public int deleteXlCarPassRecordById(Long recordId)
    {
        return xlCarPassRecordMapper.deleteXlCarPassRecordById(recordId);
    }
}
