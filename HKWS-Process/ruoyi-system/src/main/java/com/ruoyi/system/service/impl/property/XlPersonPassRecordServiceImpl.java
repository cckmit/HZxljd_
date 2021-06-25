package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPersonPassRecord;
import com.ruoyi.system.mapper.property.XlPersonPassRecordMapper;
import com.ruoyi.system.service.property.IXlPersonPassRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业--人员进出记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-09
 */
@Service
public class XlPersonPassRecordServiceImpl implements IXlPersonPassRecordService
{
    @Autowired
    private XlPersonPassRecordMapper xlPersonPassRecordMapper;

    /**
     * 查询物业--人员进出记录
     *
     * @param recordId 物业--人员进出记录ID
     * @return 物业--人员进出记录
     */
    @Override
    public XlPersonPassRecord selectXlPersonPassRecordById(Long recordId)
    {
        return xlPersonPassRecordMapper.selectXlPersonPassRecordById(recordId);
    }

    /**
     * 查询物业--人员进出记录列表
     *
     * @param xlPersonPassRecord 物业--人员进出记录
     * @return 物业--人员进出记录
     */
    @Override
    public List<XlPersonPassRecord> selectXlPersonPassRecordList(XlPersonPassRecord xlPersonPassRecord)
    {
        return xlPersonPassRecordMapper.selectXlPersonPassRecordList(xlPersonPassRecord);
    }

    /**
     * 新增物业--人员进出记录
     *
     * @param xlPersonPassRecord 物业--人员进出记录
     * @return 结果
     */
    @Override
    public int insertXlPersonPassRecord(XlPersonPassRecord xlPersonPassRecord)
    {
        xlPersonPassRecord.setCreateTime(DateUtils.getNowDate());
        return xlPersonPassRecordMapper.insertXlPersonPassRecord(xlPersonPassRecord);
    }

    /**
     * 修改物业--人员进出记录
     *
     * @param xlPersonPassRecord 物业--人员进出记录
     * @return 结果
     */
    @Override
    public int updateXlPersonPassRecord(XlPersonPassRecord xlPersonPassRecord)
    {
        xlPersonPassRecord.setUpdateTime(DateUtils.getNowDate());
        return xlPersonPassRecordMapper.updateXlPersonPassRecord(xlPersonPassRecord);
    }

    /**
     * 删除物业--人员进出记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPersonPassRecordByIds(String ids)
    {
        return xlPersonPassRecordMapper.deleteXlPersonPassRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业--人员进出记录信息
     *
     * @param recordId 物业--人员进出记录ID
     * @return 结果
     */
    @Override
    public int deleteXlPersonPassRecordById(Long recordId)
    {
        return xlPersonPassRecordMapper.deleteXlPersonPassRecordById(recordId);
    }
}
