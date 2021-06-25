package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XlVillageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 小区信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-24
 */
public interface XlVillageMapper
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
     * 查询小区信息列表和所属社区
     *
     * @param xlVillageModel 小区信息
     * @return 小区信息集合
     */

    List<XlVillageModel> selectXlVillageLists(XlVillageModel xlVillageModel);

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
     * 删除小区信息
     *
     * @param id 小区信息ID
     * @return 结果
     */
    public int deleteXlVillageById(Long id);

    /**
     * 批量删除小区信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlVillageByIds(String[] ids);

    /**
     * 校验小区信息信息
     *
     * @param xlVillageModelCode 小区信息ID
     * @return 结果
     */
    int checkVillageCodeUnique(String xlVillageModelCode);
    /**
     * 校验小区信息信息
     *
     * @param xlVillageModelName 小区信息名称
     * @return 结果
     */
    int checkVillageNameUnique(String xlVillageModelName);
    /**
     * 查询所有的网格名称
     *
     * @return 结果
     */
    List<XlVillageModel> selectdeptNames();
    //小区总数
    int queryVillageCount();

    List<XlVillageModel> selectXlVillageByPropertyName(String propertyName);

    List<XlVillageModel> selectNames();

    Integer[] selectVillageId(@Param("propertyId") String propertyId,@Param("propertyName") String propertyName);

    //查询社区居委会
    List<XlVillageModel> queryVillageList();
    //查询小区业委会
    List<XlVillageModel> queryVillageComList();
    //查询物业负责人
    List<XlVillageModel> queryPropertyList();
    //查询小区id
    int queryVillageId(XlVillageModel xlVillageModel);

    List<XlVillageModel> queryvillageName(XlVillageModel xlVillageModel);

    /**
     * 根据网格id查询小区id和名称
     * @param deptId
     * @return
     */
    List<Map<String,Object>> findVillageIdsNames(@Param("deptId") Integer deptId);
}
