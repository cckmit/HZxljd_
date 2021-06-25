package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XlAppealRecord;

/**
 * 居民/物业--申诉Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-20
 */
public interface XlAppealRecordMapper 
{
    /**
     * 查询居民/物业--申诉
     * 
     * @param id 居民/物业--申诉ID
     * @return 居民/物业--申诉
     */
    public XlAppealRecord selectXlAppealRecordById(Long id);

    /**
     * 查询居民/物业--申诉列表
     * 
     * @param xlAppealRecord 居民/物业--申诉
     * @return 居民/物业--申诉集合
     */
    public List<XlAppealRecord> selectXlAppealRecordList(XlAppealRecord xlAppealRecord);

    /**
     * 新增居民/物业--申诉
     * 
     * @param xlAppealRecord 居民/物业--申诉
     * @return 结果
     */
    public int insertXlAppealRecord(XlAppealRecord xlAppealRecord);

    /**
     * 修改居民/物业--申诉
     * 
     * @param xlAppealRecord 居民/物业--申诉
     * @return 结果
     */
    public int updateXlAppealRecord(XlAppealRecord xlAppealRecord);

    /**
     * 删除居民/物业--申诉
     * 
     * @param id 居民/物业--申诉ID
     * @return 结果
     */
    public int deleteXlAppealRecordById(Long id);

    /**
     * 批量删除居民/物业--申诉
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlAppealRecordByIds(String[] ids);
}
