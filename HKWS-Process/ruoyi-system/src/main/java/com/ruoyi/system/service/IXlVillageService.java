package com.ruoyi.system.service;

import com.ruoyi.system.domain.XlVillageModel;

import java.util.List;
import java.util.Map;

/**
 * 小区信息Service接口
 *
 * @author ruoyi
 * @date 2021-05-24
 */
public interface IXlVillageService
{
    /**
     * 查询小区信息
     *
     * @param id 小区信息ID
     * @return 小区信息
     */
    public XlVillageModel selectXlVillageById(Long id);

    /**
     * 查询小区信息列表
     *
     * @param xlVillageModel 小区信息
     * @return 小区信息集合
     */
    public List<XlVillageModel> selectXlVillageList(XlVillageModel xlVillageModel);
    /**
     * 查询小区信息列表和小区所属社区
     *
     * @param xlVillageModel 小区信息
     * @return 小区信息集合
     */
    public List<XlVillageModel> selectXlVillageLists(XlVillageModel xlVillageModel);

    /**
     * 新增小区信息
     *
     * @param xlVillageModel 小区信息
     * @return 结果
     */
    public int insertXlVillage(XlVillageModel xlVillageModel);

    /**
     * 修改小区信息
     *
     * @param xlVillageModel 小区信息
     * @return 结果
     */
    public int updateXlVillage(XlVillageModel xlVillageModel);

    /**
     * 批量删除小区信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlVillageByIds(String ids);

    /**
     * 删除小区信息信息
     *
     * @param id 小区信息ID
     * @return 结果
     */
    public int deleteXlVillageById(Long id);


    /**
     * 校验小区信息信息
     *
     * @param xlVillageModelCode 小区信息ID
     * @return 结果
     */
    String checkVillageCodeUnique(String xlVillageModelCode);

    /**
     * 校验小区信息信息
     *
     * @param xlVillageModelName 小区信息名称
     * @return 结果
     */
    String checkVillageNameUnique(String xlVillageModelName);

    /**
     * 查询所有的网格名称
     *
     * @return 结果
     */
    List<XlVillageModel> selectdeptNames();

    //导入小区信息
    public String importVillage(List<XlVillageModel> xlPersonnelList, boolean updateSupport);
    //小区信息
    int queryVillageCount();

    List<XlVillageModel> selectXlVillageByPropertyName(String propertyName);

    List<XlVillageModel> selectNames();

    Integer[] selectVillageId(String propertyId, String propertyName);

    //查询居委会信息
    List<XlVillageModel> queryVillageList();
    //查询小区业委会
    List<XlVillageModel> queryVillageComList();
    //查询小区物业信息
    List<XlVillageModel> queryPropertyList();
    //查询小区id
    int queryVillageId(XlVillageModel xlVillageModel);
    //查询小区名称
    List<XlVillageModel> queryvillageName(XlVillageModel xlVillageModel);
    //查询id
//    List<XlVillageModel> selectVillageId(String villageName);

    List<Map<String,Object>> findVillageIdsNames(Integer deptId);
}
