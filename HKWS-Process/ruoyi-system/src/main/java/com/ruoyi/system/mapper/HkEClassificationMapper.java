package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HkEClassificationMapper {
    //添加事件分类
    int insert(HkEClassification eClassification);

    //查看事件
    List<HkEClassification> selectByEClass(Map<String, Object> map) throws Exception;


    //根据ID查看信息
    HkEClassification selectByPrimaryKey(Integer id);


    //修改信息
    int updateByPrimaryKeySelective(HkEClassification eClassification);


    //根据主键删除
    int deleteByPrimaryKey(Integer id);

    //根据信息修改事件状态
    void changeStatus(HkEClassification hkEClassification);

    //验证角色唯一性
    public Integer checkRoleNameUnique(String ec_ids);

    HkEClassification selectRoleById(String ec_id);

    int updateRole(HkEClassification hkEClassification);

    int deleteRoleByIds(@Param("ids") String ids);

    List<HkEClassification> finby();
    /**
     * 批量删除
     * @param configIds
     * @return
     */
    public int deleteConfigByIds(String[] configIds);

    // 查询事件类型
    public List<HkEClassification> eventType();

    /**
     * 查询当前事件类型信息
     * @param actionType
     * @return
     */
    public HkEClassification findHkEClassification(String actionType);
    //查询事件分组
    List<HkEClassification> findEclass();

    /**
     * 一域一档 事件类型列表
     * @return
     */
    List<HkEClassification> queryEventEClassifications();

    //根据事件类型码获取事件分类
    List<HkEClassification> selectHkEClassByEcCategory(@Param("ecCategory") String ecCategory);
}
