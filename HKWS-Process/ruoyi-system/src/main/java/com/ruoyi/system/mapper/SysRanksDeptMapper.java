package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysRanksDept;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户与角色关联表 数据层
 * 
 * @author ruoyi
 */
public interface SysRanksDeptMapper
{
    /**
     * 通过用户ID查询用户和角色关联
     * 
     * @param ranksId 队伍ID
     * @return 用户和角色关联列表
     */
    public List<SysRanksDept> selectRanksDeptByRanksId(Long ranksId);

    /**
     * 通过用户ID删除用户和角色关联
     * 
     * @param ranksId 队伍ID
     * @return 结果
     */
    public int deleteRanksDeptByRanksId(Long ranksId);

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRanksDept(Long[] ids);

    /**
     * 通过部门ID查询部门下的队伍数量
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int countRanksDeptByDeptId(Long deptId);

    /**
     * 批量新增队伍信息
     * 
     * @param ranksDeptList 队伍部门列表
     * @return 结果
     */
    public int batchRanksDept(List<SysRanksDept> ranksDeptList);

    /**
     * 删除队伍和部门关联信息
     * 
     * @param ranksDept 队伍和部门关联信息
     * @return 结果
     */
    public int deleteRanksDeptInfo(SysRanksDept ranksDept);

    /**
     * 批量取消授权用户角色
     * 
     * @param deptId 部门ID
     * @param ranksIds 需要删除的队伍数据ID
     * @return 结果
     */
    public int deleteRanksDeptInfos(@Param("deptId") Long deptId, @Param("ranksId") Long[] ranksIds);

    //添加角色
    void insertRanksDept(SysRanksDept sysRanksDept);
}
