package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlWorkRecordMapper;
import com.ruoyi.system.domain.XlWorkRecord;
import com.ruoyi.system.service.IXlWorkRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--工作检查记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
@Service
public class XlWorkRecordServiceImpl implements IXlWorkRecordService 
{
    @Autowired
    private XlWorkRecordMapper xlWorkRecordMapper;

    /**
     * 查询网格员--工作检查记录
     * 
     * @param workId 网格员--工作检查记录ID
     * @return 网格员--工作检查记录
     */
    @Override
    public XlWorkRecord selectXlWorkRecordById(Long workId)
    {
        return xlWorkRecordMapper.selectXlWorkRecordById(workId);
    }

    /**
     * 查询网格员--工作检查记录列表
     * 
     * @param xlWorkRecord 网格员--工作检查记录
     * @return 网格员--工作检查记录
     */
    @Override
    public List<XlWorkRecord> selectXlWorkRecordList(XlWorkRecord xlWorkRecord)
    {
        return xlWorkRecordMapper.selectXlWorkRecordList(xlWorkRecord);
    }

    /**
     * 新增网格员--工作检查记录
     * 
     * @param xlWorkRecord 网格员--工作检查记录
     * @return 结果
     */
    @Override
    public int insertXlWorkRecord(XlWorkRecord xlWorkRecord)
    {
        return xlWorkRecordMapper.insertXlWorkRecord(xlWorkRecord);
    }

    /**
     * 修改网格员--工作检查记录
     * 
     * @param xlWorkRecord 网格员--工作检查记录
     * @return 结果
     */
    @Override
    public int updateXlWorkRecord(XlWorkRecord xlWorkRecord)
    {
        return xlWorkRecordMapper.updateXlWorkRecord(xlWorkRecord);
    }

    /**
     * 删除网格员--工作检查记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlWorkRecordByIds(String ids)
    {
        return xlWorkRecordMapper.deleteXlWorkRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--工作检查记录信息
     * 
     * @param workId 网格员--工作检查记录ID
     * @return 结果
     */
    @Override
    public int deleteXlWorkRecordById(Long workId)
    {
        return xlWorkRecordMapper.deleteXlWorkRecordById(workId);
    }
}
