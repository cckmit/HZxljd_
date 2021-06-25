package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlAppealRecordMapper;
import com.ruoyi.system.domain.XlAppealRecord;
import com.ruoyi.system.service.IXlAppealRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 居民/物业--申诉Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-20
 */
@Service
public class XlAppealRecordServiceImpl implements IXlAppealRecordService 
{
    @Autowired
    private XlAppealRecordMapper xlAppealRecordMapper;

    /**
     * 查询居民/物业--申诉
     * 
     * @param id 居民/物业--申诉ID
     * @return 居民/物业--申诉
     */
    @Override
    public XlAppealRecord selectXlAppealRecordById(Long id)
    {
        return xlAppealRecordMapper.selectXlAppealRecordById(id);
    }

    /**
     * 查询居民/物业--申诉列表
     * 
     * @param xlAppealRecord 居民/物业--申诉
     * @return 居民/物业--申诉
     */
    @Override
    public List<XlAppealRecord> selectXlAppealRecordList(XlAppealRecord xlAppealRecord)
    {
        return xlAppealRecordMapper.selectXlAppealRecordList(xlAppealRecord);
    }

    /**
     * 新增居民/物业--申诉
     * 
     * @param xlAppealRecord 居民/物业--申诉
     * @return 结果
     */
    @Override
    public int insertXlAppealRecord(XlAppealRecord xlAppealRecord)
    {
        return xlAppealRecordMapper.insertXlAppealRecord(xlAppealRecord);
    }

    /**
     * 修改居民/物业--申诉
     * 
     * @param xlAppealRecord 居民/物业--申诉
     * @return 结果
     */
    @Override
    public int updateXlAppealRecord(XlAppealRecord xlAppealRecord)
    {
        return xlAppealRecordMapper.updateXlAppealRecord(xlAppealRecord);
    }

    /**
     * 删除居民/物业--申诉对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlAppealRecordByIds(String ids)
    {
        return xlAppealRecordMapper.deleteXlAppealRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除居民/物业--申诉信息
     * 
     * @param id 居民/物业--申诉ID
     * @return 结果
     */
    @Override
    public int deleteXlAppealRecordById(Long id)
    {
        return xlAppealRecordMapper.deleteXlAppealRecordById(id);
    }
}
