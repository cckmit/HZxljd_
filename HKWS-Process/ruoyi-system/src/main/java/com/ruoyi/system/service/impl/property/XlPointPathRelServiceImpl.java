package com.ruoyi.system.service.impl.property;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.property.XlPointPathRel;
import com.ruoyi.system.mapper.property.XlPointPathRelMapper;
import com.ruoyi.system.service.property.IXlPointPathRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物业-巡更点与巡更路线关系Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-03
 */
@Service
public class XlPointPathRelServiceImpl implements IXlPointPathRelService
{
    @Autowired
    private XlPointPathRelMapper XlPointPathRelMapper;

    /**
     * 查询物业-巡更点与巡更路线关系
     *
     * @param id 物业-巡更点与巡更路线关系ID
     * @return 物业-巡更点与巡更路线关系
     */
    @Override
    public XlPointPathRel selectXlPointPathRelById(Long id)
    {
        return XlPointPathRelMapper.selectXlPointPathRelById(id);
    }

    /**
     * 查询物业-巡更点与巡更路线关系列表
     *
     * @param XlPointPathRel 物业-巡更点与巡更路线关系
     * @return 物业-巡更点与巡更路线关系
     */
    @Override
    public List<XlPointPathRel> selectXlPointPathRelList(XlPointPathRel XlPointPathRel)
    {
        return XlPointPathRelMapper.selectXlPointPathRelList(XlPointPathRel);
    }

    /**
     * 新增物业-巡更点与巡更路线关系
     *
     * @param XlPointPathRel 物业-巡更点与巡更路线关系
     * @return 结果
     */
    @Override
    public int insertXlPointPathRel(XlPointPathRel XlPointPathRel)
    {
        return XlPointPathRelMapper.insertXlPointPathRel(XlPointPathRel);
    }

    /**
     * 修改物业-巡更点与巡更路线关系
     *
     * @param XlPointPathRel 物业-巡更点与巡更路线关系
     * @return 结果
     */
    @Override
    public int updateXlPointPathRel(XlPointPathRel XlPointPathRel)
    {
        return XlPointPathRelMapper.updateXlPointPathRel(XlPointPathRel);
    }

    /**
     * 删除物业-巡更点与巡更路线关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlPointPathRelByIds(String ids)
    {
        return XlPointPathRelMapper.deleteXlPointPathRelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物业-巡更点与巡更路线关系信息
     *
     * @param id 物业-巡更点与巡更路线关系ID
     * @return 结果
     */
    @Override
    public int deleteXlPointPathRelById(Long id)
    {
        return XlPointPathRelMapper.deleteXlPointPathRelById(id);
    }

    /**
     * 通过巡更路线id删除巡更关联
     * @param pathId
     * @return
     */
    @Override
    public int deleteXlPointPathRelByPathId(Long pathId) {
        return XlPointPathRelMapper.deleteXlPointPathRelByPathId(pathId);
    }


}
