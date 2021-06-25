package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XlWorkRecord;

/**
 * 网格员--工作检查记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
public interface XlWorkRecordMapper 
{
    /**
     * 查询网格员--工作检查记录
     * 
     * @param workId 网格员--工作检查记录ID
     * @return 网格员--工作检查记录
     */
    public XlWorkRecord selectXlWorkRecordById(Long workId);

    /**
     * 查询网格员--工作检查记录列表
     * 
     * @param xlWorkRecord 网格员--工作检查记录
     * @return 网格员--工作检查记录集合
     */
    public List<XlWorkRecord> selectXlWorkRecordList(XlWorkRecord xlWorkRecord);

    /**
     * 新增网格员--工作检查记录
     * 
     * @param xlWorkRecord 网格员--工作检查记录
     * @return 结果
     */
    public int insertXlWorkRecord(XlWorkRecord xlWorkRecord);

    /**
     * 修改网格员--工作检查记录
     * 
     * @param xlWorkRecord 网格员--工作检查记录
     * @return 结果
     */
    public int updateXlWorkRecord(XlWorkRecord xlWorkRecord);

    /**
     * 删除网格员--工作检查记录
     * 
     * @param workId 网格员--工作检查记录ID
     * @return 结果
     */
    public int deleteXlWorkRecordById(Long workId);

    /**
     * 批量删除网格员--工作检查记录
     * 
     * @param workIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlWorkRecordByIds(String[] workIds);
}
