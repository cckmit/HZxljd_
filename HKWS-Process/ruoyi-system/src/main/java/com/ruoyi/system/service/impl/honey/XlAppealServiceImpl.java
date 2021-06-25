package com.ruoyi.system.service.impl.honey;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.honey.XlAppealMapper;
import com.ruoyi.system.domain.honey.XlAppeal;
import com.ruoyi.system.service.honey.IXlAppealService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--申诉Service业务层处理
 *
 * @author ruoyi
 * @date 2021-05-28
 */
@Service
public class XlAppealServiceImpl implements IXlAppealService
{
    @Autowired
    private XlAppealMapper xlAppealMapper;

    /**
     * 查询网格员--申诉
     *
     * @param id 网格员--申诉ID
     * @return 网格员--申诉
     */
    @Override
    public XlAppeal selectXlAppealById(Long id)
    {
        return xlAppealMapper.selectXlAppealById(id);
    }

    /**
     * 查询网格员--申诉列表
     *
     * @param xlAppeal 网格员--申诉
     * @return 网格员--申诉
     */
    @Override
    public List<XlAppeal> selectXlAppealList(XlAppeal xlAppeal)
    {
        return xlAppealMapper.selectXlAppealList(xlAppeal);
    }

    /**
     * 新增网格员--申诉
     *
     * @param xlAppeal 网格员--申诉
     * @return 结果
     */
    @Override
    public int insertXlAppeal(XlAppeal xlAppeal)
    {
        return xlAppealMapper.insertXlAppeal(xlAppeal);
    }

    /**
     * 修改网格员--申诉
     *
     * @param xlAppeal 网格员--申诉
     * @return 结果
     */
    @Override
    public int updateXlAppeal(XlAppeal xlAppeal)
    {
        return xlAppealMapper.updateXlAppeal(xlAppeal);
    }

    /**
     * 删除网格员--申诉对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlAppealByIds(String ids)
    {
        return xlAppealMapper.deleteXlAppealByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--申诉信息
     *
     * @param id 网格员--申诉ID
     * @return 结果
     */
    @Override
    public int deleteXlAppealById(Long id)
    {
        return xlAppealMapper.deleteXlAppealById(id);
    }
}
