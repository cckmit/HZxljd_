package com.ruoyi.quartz.service;



import com.ruoyi.quartz.domain.Source;


import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description:数据源接入
 * @author: Yang-Teng-Fei
 * @create: 2020-11-02 15:42
 **/
public interface SourceService {



    /**
     * 查询API访问地址
     * @param params
     * @return
     */
    public String findHkAddress(String params);

    /**
     * \查询所有数据源信息
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
    public int deleteHkSource(String ids);

    /**
     * 检查数据源名称是否唯一
     * @param source
     * @return
     */

    public int findHkSourceName(Source source);

    /**
     * \数据源数据库连接测试
     * @param sourceAccess
     * @param sourceHost
     * @param sourcePort
     * @param sourceUsername
     * @param sourcePassword
     * @return
     */
    public Map<String, Object> connection(String sourceAccess,
                                          String sourceHost,
                                          String sourcePort,
                                          String sourceUsername,
                                          String sourcePassword);

    /**
     * 数据源api连接测试
     * @param sourceAddress
     * @return
     */
    public Map<String, Object> apiTest(String sourceAddress);


}
