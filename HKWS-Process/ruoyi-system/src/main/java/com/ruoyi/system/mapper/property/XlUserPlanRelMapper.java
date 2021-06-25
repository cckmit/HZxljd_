package com.ruoyi.system.mapper.property;

import com.ruoyi.system.domain.property.XlUserPlanRel;

import java.util.List;

/**
 * 物业-巡更员与巡更计划关系Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-04
 */
public interface XlUserPlanRelMapper
{
    /**
     * 查询物业-巡更员与巡更计划关系
     *
     * @param id 物业-巡更员与巡更计划关系ID
     * @return 物业-巡更员与巡更计划关系
     */
    public XlUserPlanRel selectXlUserPlanRelById(Long id);

    /**
     * 查询物业-巡更员与巡更计划关系列表
     *
     * @param xlUserPlanRel 物业-巡更员与巡更计划关系
     * @return 物业-巡更员与巡更计划关系集合
     */
    public List<XlUserPlanRel> selectXlUserPlanRelList(XlUserPlanRel xlUserPlanRel);

    /**
     * 新增物业-巡更员与巡更计划关系
     *
     * @param xlUserPlanRel 物业-巡更员与巡更计划关系
     * @return 结果
     */
    public int insertXlUserPlanRel(XlUserPlanRel xlUserPlanRel);

    /**
     * 修改物业-巡更员与巡更计划关系
     *
     * @param xlUserPlanRel 物业-巡更员与巡更计划关系
     * @return 结果
     */
    public int updateXlUserPlanRel(XlUserPlanRel xlUserPlanRel);

    /**
     * 删除物业-巡更员与巡更计划关系
     *
     * @param id 物业-巡更员与巡更计划关系ID
     * @return 结果
     */
    public int deleteXlUserPlanRelById(Long id);

    /**
     * 批量删除物业-巡更员与巡更计划关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlUserPlanRelByIds(String[] ids);

    /**
     * 通过巡更计划删除关联
     * @param planId
     * @return
     */
    public int deleteXlUserPlanRelByPlanId(Long planId);
}
