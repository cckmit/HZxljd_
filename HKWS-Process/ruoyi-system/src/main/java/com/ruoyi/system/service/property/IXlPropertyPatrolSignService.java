package com.ruoyi.system.service.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolSign;

import java.util.List;

/**
 * 物业-巡更打卡记录Service接口
 *
 * @author ruoyi
 * @date 2021-06-08
 */
public interface IXlPropertyPatrolSignService
{


    /**
     * 查询物业-巡更打卡记录
     *
     * @param signId 物业-巡更打卡记录ID
     * @return 物业-巡更打卡记录
     */
    public XlPropertyPatrolSign selectXlPropertyPatrolSignById(Long signId);

    /**
     * 查询物业-巡更打卡记录列表
     *
     * @param xlPropertyPatrolSign 物业-巡更打卡记录
     * @return 物业-巡更打卡记录集合
     */
    public List<XlPropertyPatrolSign> selectXlPropertyPatrolSignList(XlPropertyPatrolSign xlPropertyPatrolSign);

    /**
     * 新增物业-巡更打卡记录
     *
     * @param xlPropertyPatrolSign 物业-巡更打卡记录
     * @return 结果
     */
    public int insertXlPropertyPatrolSign(XlPropertyPatrolSign xlPropertyPatrolSign);

    /**
     * 修改物业-巡更打卡记录
     *
     * @param xlPropertyPatrolSign 物业-巡更打卡记录
     * @return 结果
     */
    public int updateXlPropertyPatrolSign(XlPropertyPatrolSign xlPropertyPatrolSign);

    /**
     * 批量删除物业-巡更打卡记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolSignByIds(String ids);

    /**
     * 删除物业-巡更打卡记录信息
     *
     * @param signId 物业-巡更打卡记录ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolSignById(Long signId);


    /**
     * 查询当前物业下巡更打卡
     *
     * @param patrolPropertyId 物业id
     * @param patrolProperty 物业名称
     * @return 物业-巡更打卡记录
     */
    public XlPropertyPatrolSign selectByPatrolProperty(Long patrolPropertyId, String patrolProperty);

}
