package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.Daping.PercentResult;
import com.ruoyi.system.domain.HkEarlyWarning.*;
import com.ruoyi.system.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.system.domain.SysDept;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 部门管理 数据层
 * 
 * @author ruoyi
 */
public interface SysDeptMapper
{
    /**
     * 查询部门人数
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int selectDeptCount(SysDept dept);

    /**
     * 查询部门是否存在用户
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 查询部门管理数据
     * 
     * @param dept 部门信息
     * @return 部门信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 删除部门管理信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 修改子元素关系
     * 
     * @param depts 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

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
     * @param deptName 部门名称
     * @param parentId 父部门ID
     * @return 结果
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * 根据角色ID查询部门
     *
     * @param roleId 角色ID
     * @return 部门列表
     */
    public List<String> selectRoleDeptTree(Long roleId);

    /**
     * 根据队伍ID查询部门
     *
     * @param rankId 队伍ID
     * @return 部门列表
     */
    public List<String> selectRanksDeptTree(Long rankId);

    public List<String> selectAssignDeptTree(@Param("deptArr") String[] deptArr);

    /**
     * 修改所在部门的父级部门状态
     * 
     * @param dept 部门
     */
    public void updateDeptStatus(SysDept dept);

    /**
     * 根据ID查询所有子部门
     * @param deptId 部门ID
     * @return 部门列表
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);

    /**
     * 一级改变查询二级
     * @param sysDept
     * @return
     */
    List<SysDept> findChangeSysDept(SysDept sysDept);

    /**
     * 保存区域信息
     * @param sysDept
     */
    int insertSysDept(SysDept sysDept);
    //查询是否有父级id
    List<SysDept> findsysDeptUuid(String parentIndexCode);
    //查询这个区域是否存在
    int findSysDeptCount(String indexCode);

    List<Map<String,Object>> queryAllDeptByUser(Long deptId);

    List<PercentResult> getUserByDeptLevel();

    Long insertSysDeptAll(SysDept sysDept);
    //查询部门id
    int queryDeptName(String deptName);
    //部门下拉框
    List<SysDept> queryDeptNameAll(SysDept sysDept);
    /*//查询各村社的id
    Integer queryCommunityName();
    //查询网格
    List<SysDept> queryDeptNameAll(SysDept sysDept);
    //查询社区
    List<SysDept> queryDeptNameAllList(Integer deptId);*/
}
