package com.ruoyi.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XlInspectionTeamMapper;
import com.ruoyi.system.domain.XlInspectionTeam;
import com.ruoyi.system.service.IXlInspectionTeamService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网格员--检查组信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-22
 */
@Service
public class XlInspectionTeamServiceImpl implements IXlInspectionTeamService 
{
    @Autowired
    private XlInspectionTeamMapper xlInspectionTeamMapper;

    /**
     * 查询网格员--检查组信息
     * 
     * @param teamId 网格员--检查组信息ID
     * @return 网格员--检查组信息
     */
    @Override
    public XlInspectionTeam selectXlInspectionTeamById(Long teamId)
    {
        return xlInspectionTeamMapper.selectXlInspectionTeamById(teamId);
    }

    /**
     * 查询网格员--检查组信息列表
     * 
     * @param xlInspectionTeam 网格员--检查组信息
     * @return 网格员--检查组信息
     */
    @Override
    public List<XlInspectionTeam> selectXlInspectionTeamList(XlInspectionTeam xlInspectionTeam)
    {
        return xlInspectionTeamMapper.selectXlInspectionTeamList(xlInspectionTeam);
    }

    /**
     * 新增网格员--检查组信息
     * 
     * @param xlInspectionTeam 网格员--检查组信息
     * @return 结果
     */
    @Override
    public Long insertXlInspectionTeam(XlInspectionTeam xlInspectionTeam)
    {
        xlInspectionTeamMapper.insertXlInspectionTeam(xlInspectionTeam);
        return xlInspectionTeam.getTeamId();
    }

    /**
     * 修改网格员--检查组信息
     * 
     * @param xlInspectionTeam 网格员--检查组信息
     * @return 结果
     */
    @Override
    public int updateXlInspectionTeam(XlInspectionTeam xlInspectionTeam)
    {
        return xlInspectionTeamMapper.updateXlInspectionTeam(xlInspectionTeam);
    }

    /**
     * 删除网格员--检查组信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteXlInspectionTeamByIds(String ids)
    {
        return xlInspectionTeamMapper.deleteXlInspectionTeamByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网格员--检查组信息信息
     * 
     * @param teamId 网格员--检查组信息ID
     * @return 结果
     */
    @Override
    public int deleteXlInspectionTeamById(Long teamId)
    {
        return xlInspectionTeamMapper.deleteXlInspectionTeamById(teamId);
    }

    @Override
    public void insertTeamAndCheck(Long teamId, String id) {
        Map<String, String> map = new HashMap<>();
        String steamId = teamId.toString();
        map.put("teamId",steamId);
        map.put("id",id);
         xlInspectionTeamMapper.insertTeamAndCheck(map);
    }

    @Override
    public List<Integer> selectChecksByTeamId(Long teamId) {
        return xlInspectionTeamMapper.selectChecksByTeamId(teamId);
    }

    @Override
    public int deleteTeamAndChecksByTeamId(Long teamId) {
        return xlInspectionTeamMapper.deleteTeamAndChecksByTeamId(teamId);
    }
}
