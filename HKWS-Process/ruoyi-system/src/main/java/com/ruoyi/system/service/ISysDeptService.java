package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRanks;
import com.ruoyi.system.domain.SysRole;

import java.util.List;

/**
 * 部门管理 服务层
 * 
 * @author ruoyi
 */
public interface ISysDeptService
{
    /**
     * 查询部门管理数据
     * 
     * @param dept 部门信息
     * @return 部门信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查询部门管理树
     * 
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectDeptTree(SysDept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(SysRole role);


    public List<Ztree> assignDeptTreeData(EventAssignDeptVo vo);

    /**
     * 根据队伍ID查询菜单
     *
     * @param ranks 队伍对象
     * @return 菜单列表
     */
    public List<Ztree> ranksDeptTreeData(SysRanks ranks);

    /**
     * 查询部门人数
     * 
     * @param parentId 父部门ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询部门是否存在用户
     * 
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除部门管理信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 根据部门ID查询信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 校验部门名称是否唯一
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);

    /**
     * 查询1级的id
     * @param sysDept
     * @return
     */
    List<SysDept> findChangeSysDept(SysDept sysDept);

    /**
     * 添加区域信息
     * @param sysDept
     * @return
     */
    int insertSysDept(SysDept sysDept);
    //查询是否有父级id
    List<SysDept> findsysDeptUuid(String parentIndexCode);
    //查询这个区域是否存在
    int findSysDeptCount(String indexCode);

    List<PercentResult> getUserByDeptLevel();

    Long insertSysDeptAll(SysDept sysDept);
    //查询交办部门的事件
    int queryDeptName(String deptName);
    //查询部门下拉框
    List<SysDept> queryDeptNameAll(SysDept sysDept);
   /* //查询各村社的id
    Integer queryCommunityName();
    //查询社区
    List<SysDept> queryDeptNameAll(SysDept sysDept);
*/
//    List<SysDept> queryDeptNameAllList(Integer deptId);
}
