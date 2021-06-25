package com.ruoyi.quartz.service;

import java.util.List;

import com.ruoyi.quartz.domain.HkSourceFieldConfig;
import com.ruoyi.quartz.domain.Source;

/**
 * 数据接入字段配置Service接口
 * 
 * @author liuf
 * @date 2021-01-14
 */
public interface IHkSourceFieldConfigService 
{
	
	/**
	 * 根据表名，获取表对应的字段列表
	 * @param tableName
	 * @return
	 */
	public List<HkSourceFieldConfig> getHkSourceFieldConfigByTable(String tableName);
	
	
	/**
	 * 获取数据源对应的字段列表
	 * @param sourceId
	 * @return
	 */
	public List<HkSourceFieldConfig> getHkSourceFieldConfigBySourceId(Integer sourceId);
	
    /**
     * 查询数据接入字段配置
     * 
     * @param id 数据接入字段配置ID
     * @return 数据接入字段配置
     */
    public HkSourceFieldConfig selectHkSourceFieldConfigById(Long id);

    /**
     * 查询数据接入字段配置列表
     * 
     * @param hkSourceFieldConfig 数据接入字段配置
     * @return 数据接入字段配置集合
     */
    public List<HkSourceFieldConfig> selectHkSourceFieldConfigList(HkSourceFieldConfig hkSourceFieldConfig);

    /**
     * 新增数据接入字段配置
     * 
     * @param hkSourceFieldConfig 数据接入字段配置
     * @return 结果
     */
    public int insertHkSourceFieldConfig(HkSourceFieldConfig hkSourceFieldConfig);

    /**
     * 修改数据接入字段配置
     * 
     * @param hkSourceFieldConfig 数据接入字段配置
     * @return 结果
     */
    public int updateHkSourceFieldConfig(HkSourceFieldConfig hkSourceFieldConfig);

    /**
     * 批量删除数据接入字段配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkSourceFieldConfigByIds(String ids);

    /**
     * 删除数据接入字段配置信息
     * 
     * @param id 数据接入字段配置ID
     * @return 结果
     */
    public int deleteHkSourceFieldConfigById(Long id);
}
