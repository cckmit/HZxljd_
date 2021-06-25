package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XlEstateManagement;
import com.ruoyi.system.domain.dto.EstateDto;

import java.util.List;
import java.util.Map;

/**
 * 街道管理--物业信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-20
 */
public interface XlEstateManagementMapper
{
    /**
     * 查询街道管理--物业信息
     *
     * @param id 街道管理--物业信息ID
     * @return 街道管理--物业信息
     */
    public XlEstateManagement selectXlEstateManagementById(Long id);
    /**
     * 查询街道管理--物业信息
     *
     * @param quartersName 小区名称
     * @return 街道管理--物业信息
     */
    public XlEstateManagement selectXlEstateManagementByquartersName(String quartersName);

    /**
     * 查询街道管理--物业信息列表
     *
     * @param xlEstateManagement 街道管理--物业信息
     * @return 街道管理--物业信息集合
     */
    public List<XlEstateManagement> selectXlEstateManagementList(XlEstateManagement xlEstateManagement);

    /**
     * 新增街道管理--物业信息
     *
     * @param xlEstateManagement 街道管理--物业信息
     * @return 结果
     */
    public int insertXlEstateManagement(XlEstateManagement xlEstateManagement);

    /**
     * 修改街道管理--物业信息
     *
     * @param xlEstateManagement 街道管理--物业信息
     * @return 结果
     */
    public int updateXlEstateManagement(XlEstateManagement xlEstateManagement);

    /**
     * 删除街道管理--物业信息
     *
     * @param id 街道管理--物业信息ID
     * @return 结果
     */
    public int deleteXlEstateManagementById(Long id);

    /**
     * 批量删除街道管理--物业信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlEstateManagementByIds(String[] ids);
    //查询物业星级
    int queryPropert(Map<String,Object> thingResult);

    /**根据物业ID统计信息的方法
     *
     * @param id
     * @return
     */
    public List<EstateDto> selectXlEstateManagementCountById( Integer id);

    List<XlEstateManagement> selectXlEstateManagementInIds(String[] ids);
    //查询物业平均星级
    List<XlEstateManagement> queryPropertEfficiency();
    //查询物业下拉框
    List<XlEstateManagement> queryPropertyDownName(XlEstateManagement xlEstateManagement);

}
