package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.XlInspectionTeam;

/**
 * 网格员--检查组信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
public interface XlInspectionTeamMapper 
{
    /**
     * 查询网格员--检查组信息
     * 
     * @param teamId 网格员--检查组信息ID
     * @return 网格员--检查组信息
     */
    public XlInspectionTeam selectXlInspectionTeamById(Long teamId);

    /**
     * 查询网格员--检查组信息列表
     * 
     * @param xlInspectionTeam 网格员--检查组信息
     * @return 网格员--检查组信息集合
     */
    public List<XlInspectionTeam> selectXlInspectionTeamList(XlInspectionTeam xlInspectionTeam);

    /**
     * 新增网格员--检查组信息
     * 
     * @param xlInspectionTeam 网格员--检查组信息
     * @return 结果
     */
    public Long insertXlInspectionTeam(XlInspectionTeam xlInspectionTeam);

    /**
     * 修改网格员--检查组信息
     * 
     * @param xlInspectionTeam 网格员--检查组信息
     * @return 结果
     */
    public int updateXlInspectionTeam(XlInspectionTeam xlInspectionTeam);

    /**
     * 删除网格员--检查组信息
     * 
     * @param teamId 网格员--检查组信息ID
     * @return 结果
     */
    public int deleteXlInspectionTeamById(Long teamId);

    /**
     * 批量删除网格员--检查组信息
     * 
     * @param teamIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlInspectionTeamByIds(String[] teamIds);

    //新增检查组检查项关联表数据
    public void insertTeamAndCheck(Map<String, String> map);

    //根据检查组id获取检查项ids
    public List<Integer> selectChecksByTeamId(Long teamId);

    //更新时删除关联表数据
    public int deleteTeamAndChecksByTeamId(Long teamId);
}
