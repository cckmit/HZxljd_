package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HkEarlyWarning.PeopleDisposalAnalysisVO;
import com.ruoyi.system.domain.HkEarlyWarning.PeopleTimeVO;
import com.ruoyi.system.domain.HkEarlyWarning.SysRanksVo;
import com.ruoyi.system.domain.HkEntity.UserInfoDto;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRanks;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 部门管理 数据层
 * 
 * @author ruoyi
 */
public interface SysRanksMapper
{

    /**
     * 一域一档 社区人数
     * @param params
     * @return
     */
    Integer querySysRanksCount(Map<String, Object> params);

    /**
     * 一人一档 在线率
     * @param params
     * @return
     */
    Integer querySysRanksAccountStatus(Map<String, Object> params);

    /**
     * 一人一档 处置分析
     * @param params
     * @return
     */
    List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysis(Map<String, Object> params);

    /**
     * 一人一档 耗时检测
     * @param params
     * @return
     */
    List<PeopleTimeVO> queryPeopleTime(Map<String, Object> params);

    /**
     * 一事一档 队伍统计
     * @param params
     * @return
     */
    Integer queryPeopleType(Map<String, Object> params);

    /**
     * 队伍列表
     * @param ranks
     * @return
     */
    List<SysRanks> selectRanksList(SysRanksVo ranks);

    List<Map<String,Object>> getRegionCountByRanks();

    /**
     * 查询单个人员
     * @param ranks
     * @return
     */
    SysRanks selectRanksInfo(SysRanks ranks);

    /**
     * 新增队伍信息
     * @param ranks
     * @return
     */
    int insertRanks(SysRanks ranks);

    /**
     * 更新队伍信息
     * @param ranks
     * @return
     */
    int updateRanks(SysRanks ranks);

    /**
     * 根据队伍状态
     * @param ranks
     * @return
     */
    int changeStatus(SysRanks ranks);

    int deleteRanksById(Long ranksId);

    int deleteRanksByIds(Long[] ranksIds);

    List<UserInfoDto> selectCanBeChoose(Map<String,Object> param);

    /**
     * 一人一档 效率管理-社区选择
     * @param efficiencyParams
     * @return
     */
    List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysisByDeptName(Map<String, Object> efficiencyParams);
}
