package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlSubdivideMapper;
import com.ruoyi.system.domain.XlSubdivide;
import com.ruoyi.system.service.IXlSubdivideService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--考核细分项Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-31
 */
@Service
public class XlSubdivideServiceImpl implements IXlSubdivideService 
{
    @Autowired
    private XlSubdivideMapper xlSubdivideMapper;

    /**
     * 查询网格员--考核细分项
     * 
     * @param subdivideId 网格员--考核细分项ID
     * @return 网格员--考核细分项
     */
    @Override
    public XlSubdivide selectXlSubdivideById(Long subdivideId)
    {
        return xlSubdivideMapper.selectXlSubdivideById(subdivideId);
    }

    /**
     * 查询网格员--考核细分项列表
     * 
     * @param xlSubdivide 网格员--考核细分项
     * @return 网格员--考核细分项
     */
    @Override
    public List<XlSubdivide> selectXlSubdivideList(XlSubdivide xlSubdivide)
    {
        return xlSubdivideMapper.selectXlSubdivideList(xlSubdivide);
    }

    /**
     * 新增网格员--考核细分项
     * 
     * @param xlSubdivide 网格员--考核细分项
     * @return 结果
     */
    @Override
    public int insertXlSubdivide(XlSubdivide xlSubdivide)
    {
        return xlSubdivideMapper.insertXlSubdivide(xlSubdivide);
    }

    /**
     * 修改网格员--考核细分项
     * 
     * @param xlSubdivide 网格员--考核细分项
     * @return 结果
     */
    @Override
    public int updateXlSubdivide(XlSubdivide xlSubdivide)
    {
        return xlSubdivideMapper.updateXlSubdivide(xlSubdivide);
    }

    /**
     * 删除网格员--考核细分项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlSubdivideByIds(String ids)
    {
        return xlSubdivideMapper.deleteXlSubdivideByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--考核细分项信息
     * 
     * @param subdivideId 网格员--考核细分项ID
     * @return 结果
     */
    @Override
    public int deleteXlSubdivideById(Long subdivideId)
    {
        return xlSubdivideMapper.deleteXlSubdivideById(subdivideId);
    }

    @Override
    public List<XlSubdivide> selectXlSubdivideByAssessmentId(Long assessmentId) {
        return xlSubdivideMapper.selectXlSubdivideByAssessmentId(assessmentId);
    }

    @Override
    public List<String> selectDeptNamesBySubdivideId(Long subdivideId) {
        return xlSubdivideMapper.selectDeptNamesBySubdivideId(subdivideId);
    }
}
