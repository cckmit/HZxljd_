package com.ruoyi.system.service.impl.honey;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.honey.XlMemorandum;
import com.ruoyi.system.mapper.honey.XlMemorandumMapper;
import com.ruoyi.system.service.honey.IXlMemorandumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网格移动端--备忘录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-10
 */
@Service
public class XlMemorandumServiceImpl implements IXlMemorandumService
{
    @Autowired
    private XlMemorandumMapper xlMemorandumMapper;

    /**
     * 查询网格移动端--备忘录
     *
     * @param id 网格移动端--备忘录ID
     * @return 网格移动端--备忘录
     */
    @Override
    public XlMemorandum selectXlMemorandumById(Long id)
    {
        return xlMemorandumMapper.selectXlMemorandumById(id);
    }

    /**
     * 查询网格移动端--备忘录列表
     *
     * @param xlMemorandum 网格移动端--备忘录
     * @return 网格移动端--备忘录
     */
    @Override
    public List<XlMemorandum> selectXlMemorandumList(XlMemorandum xlMemorandum)
    {
        return xlMemorandumMapper.selectXlMemorandumList(xlMemorandum);
    }

    /**
     * 新增网格移动端--备忘录
     *
     * @param xlMemorandum 网格移动端--备忘录
     * @return 结果
     */
    @Override
    public int insertXlMemorandum(XlMemorandum xlMemorandum)
    {
        xlMemorandum.setCreateTime(DateUtils.getNowDate());
        return xlMemorandumMapper.insertXlMemorandum(xlMemorandum);
    }

    /**
     * 修改网格移动端--备忘录
     *
     * @param xlMemorandum 网格移动端--备忘录
     * @return 结果
     */
    @Override
    public int updateXlMemorandum(XlMemorandum xlMemorandum)
    {
        xlMemorandum.setUpdateTime(DateUtils.getNowDate());
        return xlMemorandumMapper.updateXlMemorandum(xlMemorandum);
    }

    /**
     * 删除网格移动端--备忘录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlMemorandumByIds(String ids)
    {
        return xlMemorandumMapper.deleteXlMemorandumByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格移动端--备忘录信息
     *
     * @param id 网格移动端--备忘录ID
     * @return 结果
     */
    @Override
    public int deleteXlMemorandumById(Long id)
    {
        return xlMemorandumMapper.deleteXlMemorandumById(id);
    }
}
