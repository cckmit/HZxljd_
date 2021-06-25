package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlPatrolPlanMapper;
import com.ruoyi.system.domain.XlPatrolPlan;
import com.ruoyi.system.service.IXlPatrolPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--巡查计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
@Service
public class XlPatrolPlanServiceImpl implements IXlPatrolPlanService 
{
    @Autowired
    private XlPatrolPlanMapper xlPatrolPlanMapper;

    /**
     * 查询网格员--巡查计划
     * 
     * @param id 网格员--巡查计划ID
     * @return 网格员--巡查计划
     */
    @Override
    public XlPatrolPlan selectXlPatrolPlanById(Long id)
    {
        return xlPatrolPlanMapper.selectXlPatrolPlanById(id);
    }

    /**
     * 查询网格员--巡查计划列表
     * 
     * @param xlPatrolPlan 网格员--巡查计划
     * @return 网格员--巡查计划
     */
    @Override
    public List<XlPatrolPlan> selectXlPatrolPlanList(XlPatrolPlan xlPatrolPlan)
    {
        return xlPatrolPlanMapper.selectXlPatrolPlanList(xlPatrolPlan);
    }

    /**
     * 新增网格员--巡查计划
     * 
     * @param xlPatrolPlan 网格员--巡查计划
     * @return 结果
     */
    @Override
    public int insertXlPatrolPlan(XlPatrolPlan xlPatrolPlan)
    {
        return xlPatrolPlanMapper.insertXlPatrolPlan(xlPatrolPlan);
    }

    /**
     * 修改网格员--巡查计划
     * 
     * @param xlPatrolPlan 网格员--巡查计划
     * @return 结果
     */
    @Override
    public int updateXlPatrolPlan(XlPatrolPlan xlPatrolPlan)
    {
        return xlPatrolPlanMapper.updateXlPatrolPlan(xlPatrolPlan);
    }

    /**
     * 删除网格员--巡查计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPatrolPlanByIds(String ids)
    {
        return xlPatrolPlanMapper.deleteXlPatrolPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--巡查计划信息
     * 
     * @param id 网格员--巡查计划ID
     * @return 结果
     */
    @Override
    public int deleteXlPatrolPlanById(Long id)
    {
        return xlPatrolPlanMapper.deleteXlPatrolPlanById(id);
    }
}
