package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.HkEntity.EventBackProcessRecordVo;
import com.ruoyi.system.domain.HkEventProcessRecord;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public interface HkEventProcessRecordMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public HkEventProcessRecord selectHkEventProcessRecordById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param hkEventProcessRecord 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HkEventProcessRecord> selectHkEventProcessRecordList(HkEventProcessRecord hkEventProcessRecord);

    public List<HkEventProcessRecord> queryProcessRecordByParam(Map<String,Object> param);

    List<EventBackProcessRecordVo> queryProcessRecordList(String eventId);
    /**
     * 新增【请填写功能名称】
     * 
     * @param hkEventProcessRecord 【请填写功能名称】
     * @return 结果
     */
    public int insertHkEventProcessRecord(HkEventProcessRecord hkEventProcessRecord);

    /**
     * 修改【请填写功能名称】
     * 
     * @param hkEventProcessRecord 【请填写功能名称】
     * @return 结果
     */
    public int updateHkEventProcessRecord(HkEventProcessRecord hkEventProcessRecord);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteHkEventProcessRecordById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkEventProcessRecordByIds(String[] ids);

    HkEventProcessRecord queryLastRecordByEventId(String eventId);
}
