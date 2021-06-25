package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XlPersonnel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人员信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-17
 */
public interface XlPersonnelMapper
{
    /**
     * 查询人员信息
     *
     * @param id 人员信息ID
     * @return 人员信息
     */
    public XlPersonnel selectXlPersonnelById(Long id);

    /**
     * 查询人员信息列表
     *
     * @param xlPersonnel 人员信息
     * @return 人员信息集合
     */
    public List<XlPersonnel> selectXlPersonnelList(XlPersonnel xlPersonnel);

    /**
     * 新增人员信息
     *
     * @param xlPersonnel 人员信息
     * @return 结果
     */
    public int insertXlPersonnel(XlPersonnel xlPersonnel);

    /**
     * 修改人员信息
     *
     * @param xlPersonnel 人员信息
     * @return 结果
     */
    public int updateXlPersonnel(XlPersonnel xlPersonnel);

    /**
     * 删除人员信息
     *
     * @param id 人员信息ID
     * @return 结果
     */
    public int deleteXlPersonnelById(Long id);

    /**
     * 批量删除人员信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlPersonnelByIds(String[] ids);

    //根据身份证号判定人员是否已存在
    public XlPersonnel selectXlPersonnelByIdcard(String idcard);

    //根据选中id查询数据
    public List<XlPersonnel> selectXlPersonnelInIds(String[] ids);
    //查询人员总数
    int queryPersonCount(XlPersonnel xlPersonnel);
    //流动人口和户籍人口
    int queryLiuPopulation(XlPersonnel xlPersonnel);
    //户籍人口
    int queryHuPopulation(XlPersonnel xlPersonnel);
    //人员列表
//    List<XlPersonnel> queryPersonList(XlPersonnel xlPersonnel);
    //查询小区人数
    int queryPersonCountAll(Map<String, Object> thingResult);

//    void updatePersonVillageId(Map<String, Object> thingResult);

//    List<XlPersonnel> selectXlPersonnelListAll();
    //户主信息
    List<XlPersonnel> queryPersonHu(Map<String, Object> params);
    //查询人员关联的房屋id
    String queryPersonVillageCode(Integer nameId);
    //查询人员信息
    Integer queryPersonAllList(Map<String, Object> paramsAll);

    List<XlPersonnel> selectXlPersonnelWork(XlPersonnel xlPersonnel);

    List<XlPersonnel> estatePersonnelList(HashMap map);
}
