package com.ruoyi.system.service;

import com.ruoyi.system.domain.HkEClassification;

import java.util.List;

public interface HkEClassificationService {
    //创建事件
    Integer create(HkEClassification eClassification);

    //查看事件
    List<HkEClassification> selectByEClass(String ecname, String ectype, String ecid,String ecCategory) throws Exception;


    //根据主键查询
    HkEClassification findById(Integer id);

    //主键更新
    void updateById(HkEClassification eClassification);

    //主键删除
    void deleteById(Integer id);

    int checkRoleAllowed(HkEClassification hkEClassification);
    //验证唯一性
    String checkRoleNameUnique(HkEClassification hkEClassification);

    HkEClassification selectRoleById(String ec_id);

    int updateRole(HkEClassification hkEClassification);

    int deleteRoleByIds(String ids);

    List<HkEClassification> finby();
    /**
     * 批量删除参数配置信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigByIds(String ids);

    // 查询事件类型
    public List<HkEClassification> eventType();

    /**
     * 查询当前事件类型信息
     * @param actionType
     * @return
     */
    public HkEClassification findHkEClassification(String actionType);
    //查询事件分类表
    List<HkEClassification> findEclass();

    /**
     * 一域一档 事件类型列表
     * @return
     */
    List<HkEClassification> queryEventEClassifications();

    //根据事件类型码获取事件分类
    List<HkEClassification> selectHkEClassByEcCategory(String ecCategory);
}
