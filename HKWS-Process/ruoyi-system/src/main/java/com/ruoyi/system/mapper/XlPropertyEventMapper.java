package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XlPropertyEvent;
import com.ruoyi.system.domain.honey.PropertyEventVo;

import java.util.HashMap;
import java.util.List;

/**
 * 物业--事件信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-20
 */
public interface XlPropertyEventMapper
{

    /**
     * 查询物业--事件信息列表-----关联village表
     *
     * @param propertyEventVo 物业--事件信息
     * @return 物业--事件信息集合
     */
    public List<PropertyEventVo> selectPropertyEventVoList(PropertyEventVo propertyEventVo);
    /**
     * 查询物业--事件信息
     *
     * @param eventId 物业--事件信息ID
     * @return 物业--事件信息
     */
    public XlPropertyEvent selectXlPropertyEventById(Long eventId);

    /**
     * 查询物业--事件信息列表
     *
     * @param xlPropertyEvent 物业--事件信息
     * @return 物业--事件信息集合
     */
    public List<XlPropertyEvent> selectXlPropertyEventList(XlPropertyEvent xlPropertyEvent);

    /**
     * 新增物业--事件信息
     *
     * @param xlPropertyEvent 物业--事件信息
     * @return 结果
     */
    public int insertXlPropertyEvent(XlPropertyEvent xlPropertyEvent);

    /**
     * 修改物业--事件信息
     *
     * @param xlPropertyEvent 物业--事件信息
     * @return 结果
     */
    public int updateXlPropertyEvent(XlPropertyEvent xlPropertyEvent);

    /**
     * 删除物业--事件信息
     *
     * @param id 物业--事件信息ID
     * @return 结果
     */
    public int deleteXlPropertyEventById(Long id);

    /**
     * 批量删除物业--事件信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyEventByIds(String[] ids);

    /**
     * 事件信息处理流程
     *
     * @return 结果
     */
    public PropertyEventVo selectPropertyEventVo(Long id);

    List<PropertyEventVo> selectPropertyEventVoProjectList(HashMap map);
}
