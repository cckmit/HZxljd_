package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.property.XlPropertyAuditHouse;
import com.ruoyi.system.mapper.property.XlPropertyAuditHouseMapper;
import com.ruoyi.system.service.property.IXlPropertyAuditHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业-房屋审核Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-01
 */
@Service
public class XlPropertyAuditHouseServiceImpl implements IXlPropertyAuditHouseService
{
    @Autowired
    private XlPropertyAuditHouseMapper xlPropertyAuditHouseMapper;

    /**
     * 查询物业-房屋审核
     *
     * @param auditId 物业-房屋审核ID
     * @return 物业-房屋审核
     */
    @Override
    public XlPropertyAuditHouse selectXlPropertyAuditHouseById(Long auditId)
    {
        return xlPropertyAuditHouseMapper.selectXlPropertyAuditHouseById(auditId);
    }

    /**
     * 查询物业-房屋审核列表
     *
     * @param xlPropertyAuditHouse 物业-房屋审核
     * @return 物业-房屋审核
     */
    @Override
    public List<XlPropertyAuditHouse> selectXlPropertyAuditHouseList(XlPropertyAuditHouse xlPropertyAuditHouse)
    {
        return xlPropertyAuditHouseMapper.selectXlPropertyAuditHouseList(xlPropertyAuditHouse);
    }

    /**
     * 新增物业-房屋审核
     *
     * @param xlPropertyAuditHouse 物业-房屋审核
     * @return 结果
     */
    @Override
    public int insertXlPropertyAuditHouse(XlPropertyAuditHouse xlPropertyAuditHouse)
    {
        xlPropertyAuditHouse.setCreateTime(DateUtils.getNowDate());
        return xlPropertyAuditHouseMapper.insertXlPropertyAuditHouse(xlPropertyAuditHouse);
    }

    /**
     * 修改物业-房屋审核
     *
     * @param xlPropertyAuditHouse 物业-房屋审核
     * @return 结果
     */
    @Override
    public int updateXlPropertyAuditHouse(XlPropertyAuditHouse xlPropertyAuditHouse)
    {
        xlPropertyAuditHouse.setUpdateTime(DateUtils.getNowDate());
        return xlPropertyAuditHouseMapper.updateXlPropertyAuditHouse(xlPropertyAuditHouse);
    }

    /**
     * 删除物业-房屋审核对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyAuditHouseByIds(String ids)
    {
        return xlPropertyAuditHouseMapper.deleteXlPropertyAuditHouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-房屋审核信息
     *
     * @param auditId 物业-房屋审核ID
     * @return 结果
     */
    @Override
    public int deleteXlPropertyAuditHouseById(Long auditId)
    {
        return xlPropertyAuditHouseMapper.deleteXlPropertyAuditHouseById(auditId);
    }
}