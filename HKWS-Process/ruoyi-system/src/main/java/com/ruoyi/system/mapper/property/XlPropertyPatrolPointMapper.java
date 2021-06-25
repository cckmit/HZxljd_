package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolPoint;

import java.util.List;

/**
 * 物业-巡更点Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-27
 */
public interface XlPropertyPatrolPointMapper
{
    /**
     * 查询物业-巡更点
     *
     * @param pointId 物业-巡更点ID
     * @return 物业-巡更点
     */
    public XlPropertyPatrolPoint selectXlPropertyPatrolPointById(Long pointId);

    /**
     * 查询物业-巡更点列表
     *
     * @param XlPropertyPatrolPoint 物业-巡更点
     * @return 物业-巡更点集合
     */
    public List<XlPropertyPatrolPoint> selectXlPropertyPatrolPointList(XlPropertyPatrolPoint XlPropertyPatrolPoint);

    /**
     * 新增物业-巡更点
     *
     * @param XlPropertyPatrolPoint 物业-巡更点
     * @return 结果
     */
    public int insertXlPropertyPatrolPoint(XlPropertyPatrolPoint XlPropertyPatrolPoint);

    /**
     * 修改物业-巡更点
     *
     * @param XlPropertyPatrolPoint 物业-巡更点
     * @return 结果
     */
    public int updateXlPropertyPatrolPoint(XlPropertyPatrolPoint XlPropertyPatrolPoint);

    /**
     * 删除物业-巡更点
     *
     * @param pointId 物业-巡更点ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolPointById(Long pointId);

    /**
     * 批量删除物业-巡更点
     *
     * @param pointIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolPointByIds(String[] pointIds);

    /**
     * 删除巡更点 仅修改删除标识 保留数据 单删
     * @param pointId
     * @return
     */
    public int deletePointById(Long pointId);

    /**
     * 删除巡更点 仅修改删除标识 保留数据 批删
     * @param pointIds
     * @return
     */
    public int deletePointByIds(String[] pointIds);
}
