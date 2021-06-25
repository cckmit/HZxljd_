package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.domain.honey.PropertyEventVo;
import com.ruoyi.system.mapper.XlPropertyEventMapper;
import com.ruoyi.system.service.IXlPropertyEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 物业--事件信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-20
 */
@Service
public class XlPropertyEventServiceImpl implements IXlPropertyEventService
{
    @Autowired
    private XlPropertyEventMapper xlPropertyEventMapper;

    /**
     * 查询物业--事件信息
     *
     * @param eventId 物业--事件信息ID
     * @return 物业--事件信息
     */
    @Override
    public XlPropertyEvent selectXlPropertyEventById(Long eventId)
    {
        return xlPropertyEventMapper.selectXlPropertyEventById(eventId);
    }

    /**
     * 查询物业--事件信息列表
     *
     * @param xlPropertyEvent 物业--事件信息
     * @return 物业--事件信息
     */
    @Override
    public List<XlPropertyEvent> selectXlPropertyEventList(XlPropertyEvent xlPropertyEvent)
    {
        return xlPropertyEventMapper.selectXlPropertyEventList(xlPropertyEvent);
    }

    /**
     * 新增物业--事件信息
     *
     * @param xlPropertyEvent 物业--事件信息
     * @return 结果
     */
    @Override
    public int insertXlPropertyEvent(XlPropertyEvent xlPropertyEvent)
    {
        xlPropertyEvent.setCreateTime(DateUtils.getNowDate());
        return xlPropertyEventMapper.insertXlPropertyEvent(xlPropertyEvent);
    }

    /**
     * 修改物业--事件信息
     *
     * @param xlPropertyEvent 物业--事件信息
     * @return 结果
     */
    @Override
    public int updateXlPropertyEvent(XlPropertyEvent xlPropertyEvent)
    {
        xlPropertyEvent.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyEventMapper.updateXlPropertyEvent(xlPropertyEvent);
    }

    /**
     * 删除物业--事件信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyEventByIds(String ids)
    {
        return xlPropertyEventMapper.deleteXlPropertyEventByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业--事件信息信息
     *
     * @param eventId 物业--事件信息ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyEventById(Long eventId)
    {
        return xlPropertyEventMapper.deleteXlPropertyEventById(eventId);
    }

    @Override
    public List<PropertyEventVo> selectPropertyEventVoList(PropertyEventVo propertyEventVo) {
        return xlPropertyEventMapper.selectPropertyEventVoList(propertyEventVo);
    }

    @Override
    public PropertyEventVo selectPropertyEventVo(Long id) {
        return xlPropertyEventMapper.selectPropertyEventVo(id);
    }

    @Override
    public List<PropertyEventVo> selectPropertyEventVoProjectList(Integer[] villageId, PropertyEventVo propertyEventVo) {
        HashMap map=new HashMap();
        map.put("villageId",villageId);
        map.put("event",propertyEventVo);
        return xlPropertyEventMapper.selectPropertyEventVoProjectList(map);
    }
}
