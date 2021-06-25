package com.ruoyi.system.mapper.honey;

import com.ruoyi.system.domain.honey.XlMemorandum;

import java.util.List;


/**
 * 网格移动端--备忘录Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-10
 */
public interface XlMemorandumMapper
{
    /**
     * 查询网格移动端--备忘录
     *
     * @param id 网格移动端--备忘录ID
     * @return 网格移动端--备忘录
     */
    public XlMemorandum selectXlMemorandumById(Long id);

    /**
     * 查询网格移动端--备忘录列表
     *
     * @param xlMemorandum 网格移动端--备忘录
     * @return 网格移动端--备忘录集合
     */
    public List<XlMemorandum> selectXlMemorandumList(XlMemorandum xlMemorandum);

    /**
     * 新增网格移动端--备忘录
     *
     * @param xlMemorandum 网格移动端--备忘录
     * @return 结果
     */
    public int insertXlMemorandum(XlMemorandum xlMemorandum);

    /**
     * 修改网格移动端--备忘录
     *
     * @param xlMemorandum 网格移动端--备忘录
     * @return 结果
     */
    public int updateXlMemorandum(XlMemorandum xlMemorandum);

    /**
     * 删除网格移动端--备忘录
     *
     * @param id 网格移动端--备忘录ID
     * @return 结果
     */
    public int deleteXlMemorandumById(Long id);

    /**
     * 批量删除网格移动端--备忘录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlMemorandumByIds(String[] ids);
}
