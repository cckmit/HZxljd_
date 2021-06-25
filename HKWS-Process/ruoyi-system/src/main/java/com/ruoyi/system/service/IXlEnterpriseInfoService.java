package com.ruoyi.system.service;

import com.ruoyi.system.domain.XlEnterpriseInfo;

import java.util.List;
import java.util.Map;

/**
 * 公共管理--企业信息Service接口
 *
 * @author ruoyi
 * @date 2021-05-20
 */
public interface IXlEnterpriseInfoService
{
    /**
     * 查询公共管理--企业信息
     *
     * @param id 公共管理--企业信息ID
     * @return 公共管理--企业信息
     */
    public XlEnterpriseInfo selectXlEnterpriseInfoById(Long id);
    /**
     * 查询公共管理--企业信息
     *
     * @param ids 公共管理--企业信息IDs
     * @return 公共管理--企业信息
     */
    public List<XlEnterpriseInfo> selectXlEnterpriseInfoInIds(String[] ids);

    /**
     * 查询公共管理--企业信息列表
     *
     * @param xlEnterpriseInfo 公共管理--企业信息
     * @return 公共管理--企业信息集合
     */
    public List<XlEnterpriseInfo> selectXlEnterpriseInfoList(XlEnterpriseInfo xlEnterpriseInfo);

    /**
     * 新增公共管理--企业信息
     *
     * @param xlEnterpriseInfo 公共管理--企业信息
     * @return 结果
     */
    public int insertXlEnterpriseInfo(XlEnterpriseInfo xlEnterpriseInfo);

    /**
     * 修改公共管理--企业信息
     *
     * @param xlEnterpriseInfo 公共管理--企业信息
     * @return 结果
     */
    public int updateXlEnterpriseInfo(XlEnterpriseInfo xlEnterpriseInfo);

    /**
     * 批量删除公共管理--企业信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlEnterpriseInfoByIds(String ids);

    /**
     * 删除公共管理--企业信息信息
     *
     * @param id 公共管理--企业信息ID
     * @return 结果
     */
    public int deleteXlEnterpriseInfoById(Long id);

    //查询企业名称是否存在
    public String checkEnterpriseNameUnique(String enterpriseName);

    /**
     * 导入企业单位数据
     *
     * @param XlEnterpriseInfo 企业数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    String importEnterpriseInfo(List<XlEnterpriseInfo> XlEnterpriseInfo, boolean isUpdateSupport);

    List<XlEnterpriseInfo> selectenterpriseType();

    void updateenterprisesCode(XlEnterpriseInfo xlEnterpriseInfo);

    void updateenterprises(XlEnterpriseInfo xlEnterpriseInfo);

    void updateenterprisesNumber(XlEnterpriseInfo xlEnterpriseInfo);
    //企业总数
    int queryEnterpriseAll(XlEnterpriseInfo xlEnterpriseInfo);
    //上市企业总数
    int queryListedEnterprise(XlEnterpriseInfo xlEnterpriseInfo);
    //查询企业信息
    List<XlEnterpriseInfo> selectXlEnterpriseInfo(Map<String,Object> result);
    //查询个体工商户总数
    int queryListGeTiEnterprise(XlEnterpriseInfo xlEnterpriseInfo);
/*    //商铺下拉
    List<XlEnterpriseInfo> queryGeTiList();*/

}
