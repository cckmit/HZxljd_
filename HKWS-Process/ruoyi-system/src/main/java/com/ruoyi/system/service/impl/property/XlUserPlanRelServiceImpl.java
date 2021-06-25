package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.property.XlUserPlanRel;
import com.ruoyi.system.mapper.property.XlUserPlanRelMapper;
import com.ruoyi.system.service.property.IXlUserPlanRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业-巡更员与巡更计划关系Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-04
 */
@Service
public class XlUserPlanRelServiceImpl implements IXlUserPlanRelService
{
    @Autowired
    private XlUserPlanRelMapper xlUserPlanRelMapper;

    /**
     * 查询物业-巡更员与巡更计划关系
     *
     * @param id 物业-巡更员与巡更计划关系ID
     * @return 物业-巡更员与巡更计划关系
     */
    @Override
    public XlUserPlanRel selectXlUserPlanRelById(Long id)
    {
        return xlUserPlanRelMapper.selectXlUserPlanRelById(id);
    }

    /**
     * 查询物业-巡更员与巡更计划关系列表
     *
     * @param xlUserPlanRel 物业-巡更员与巡更计划关系
     * @return 物业-巡更员与巡更计划关系
     */
    @Override
    public List<XlUserPlanRel> selectXlUserPlanRelList(XlUserPlanRel xlUserPlanRel)
    {
        return xlUserPlanRelMapper.selectXlUserPlanRelList(xlUserPlanRel);
    }

    /**
     * 新增物业-巡更员与巡更计划关系
     *
     * @param xlUserPlanRel 物业-巡更员与巡更计划关系
     * @return 结果
     */
    @Override
    public int insertXlUserPlanRel(XlUserPlanRel xlUserPlanRel)
    {
        return xlUserPlanRelMapper.insertXlUserPlanRel(xlUserPlanRel);
    }

    /**
     * 修改物业-巡更员与巡更计划关系
     *
     * @param xlUserPlanRel 物业-巡更员与巡更计划关系
     * @return 结果
     */
    @Override
    public int updateXlUserPlanRel(XlUserPlanRel xlUserPlanRel)
    {
        return xlUserPlanRelMapper.updateXlUserPlanRel(xlUserPlanRel);
    }

    /**
     * 删除物业-巡更员与巡更计划关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlUserPlanRelByIds(String ids)
    {
        return xlUserPlanRelMapper.deleteXlUserPlanRelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更员与巡更计划关系信息
     *
     * @param id 物业-巡更员与巡更计划关系ID
     * @return 结果
     */
    @Override
    public int deleteXlUserPlanRelById(Long id)
    {
        return xlUserPlanRelMapper.deleteXlUserPlanRelById(id);
    }

    /**
     * 通过巡更计划删除关联
     * @param planId
     * @return
     */
    @Override
    public int deleteXlUserPlanRelByPlanId(Long planId) {
        return xlUserPlanRelMapper.deleteXlUserPlanRelByPlanId(planId);
    }
}
