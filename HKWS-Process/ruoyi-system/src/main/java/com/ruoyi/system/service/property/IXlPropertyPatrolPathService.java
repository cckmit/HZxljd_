package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolPath;

import java.util.List;

/**
 * 物业-巡更路线Service接口
 *
 * @author ruoyi
 * @date 2021-05-27
 */
public interface IXlPropertyPatrolPathService
{
    /**
     * 查询物业-巡更路线
     *
     * @param pathId 物业-巡更路线ID
     * @return 物业-巡更路线
     */
    public XlPropertyPatrolPath selectXlPropertyPatrolPathById(Long pathId);

    /**
     * 查询物业-巡更路线列表
     *
     * @param xlPropertyPatrolPath 物业-巡更路线
     * @return 物业-巡更路线集合
     */
    public List<XlPropertyPatrolPath> selectXlPropertyPatrolPathList(XlPropertyPatrolPath xlPropertyPatrolPath);

    /**
     * 新增物业-巡更路线
     *
     * @param xlPropertyPatrolPath 物业-巡更路线
     * @return 结果
     */
    public int insertXlPropertyPatrolPath(XlPropertyPatrolPath xlPropertyPatrolPath);

    /**
     * 修改物业-巡更路线
     *
     * @param xlPropertyPatrolPath 物业-巡更路线
     * @return 结果
     */
    public int updateXlPropertyPatrolPath(XlPropertyPatrolPath xlPropertyPatrolPath);

    /**
     * 批量删除物业-巡更路线
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolPathByIds(String ids);

    /**
     * 删除物业-巡更路线信息
     *
     * @param pathId 物业-巡更路线ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolPathById(Long pathId);

    /**
     * 查询巡更点与巡更路线的联合信息
     * @param xlPropertyPatrolPath
     * @return
     */
    public List<XlPropertyPatrolPath> selectPathAndPointList(XlPropertyPatrolPath xlPropertyPatrolPath);

    /**
     * 通过巡更路线id查询巡更点与巡更路线的联合信息
     * @param pathId
     * @return
     */
    public XlPropertyPatrolPath selectPathAndPointById(Long pathId);

    /**
     * 删除巡更路线 仅修改巡更路线的删除标识，保留数据 单删
     * @param pathId
     * @return
     */
    public int deletePathById(Long pathId);

    /**
     * 删除巡更路线 仅修改巡更路线的删除标识，保留数据 批删
     * @param pathIds
     * @return
     */
    public int deletePathByIds(String ids);
}
