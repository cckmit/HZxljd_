package com.ruoyi.quartz.mapper;

import com.ruoyi.quartz.domain.Source;


import java.util.List;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-11-02 15:43
 **/
public interface SourceMapper {

    /**
     * 查询API访问地址
     * @param params
     * @return
     */
    public Source findHkAddress(String params);
    /**
     * 查询数据源所有信息
     * @param source
     * @return
     */
    public List<Source> querySourceInfo(Source source);

    /**
     * 添加数据源信息
     * @param source
     * @return
     */
    public int addHkSource(Source source);
    /**
     * 回显当前数据源数据
     * @param id
     * @return
     */
    public Source findHkSource(Integer id);

    /**
     * 修改数据源信息
     * @param source
     * @return
     */
    public int updateHkSource(Source source);


    /**
     * 批量删除数据源信息
     * @param ids
     * @return
     */
    public int deleteHkSource(String[] ids);
    /**
     * 检查数据源名称是否唯一
     * @param source
     * @return
     */

    public int findHkSourceName(Source source);

}
