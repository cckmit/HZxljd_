package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlPropertyPatrolSign;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物业-巡更打卡记录Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-08
 */
public interface XlPropertyPatrolSignMapper
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
     * 删除物业-巡更打卡记录
     *
     * @param signId 物业-巡更打卡记录ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolSignById(Long signId);

    /**
     * 批量删除物业-巡更打卡记录
     *
     * @param signIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPropertyPatrolSignByIds(String[] signIds);

    XlPropertyPatrolSign selectByPatrolProperty(@Param("patrolPropertyId") Long patrolPropertyId,@Param("patrolProperty") String patrolProperty);
}
