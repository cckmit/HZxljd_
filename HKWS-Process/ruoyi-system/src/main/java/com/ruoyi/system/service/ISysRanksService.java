package com.ruoyi.system.service;

import com.github.pagehelper.PageInfo;
import com.ruoyi.system.domain.HkEarlyWarning.PeopleDisposalAnalysisVO;
import com.ruoyi.system.domain.HkEarlyWarning.PeopleTimeVO;
import com.ruoyi.system.domain.HkEntity.UserInfoDto;
import com.ruoyi.system.domain.SysRanks;
import com.ruoyi.system.domain.HkEarlyWarning.SysRanksVo;
import java.util.List;
import com.ruoyi.system.domain.HkEarlyWarning.PeopleTypeVO;
import java.util.Map;

/**
 * 队伍信息 服务处
 * @author zjf
 */
public interface ISysRanksService {

    /**
     * 一域一档 社区人数
     * @param params
     * @return
     */
    public Integer querySysRanksCount(Map<String,Object> params);

    /**
     * 一人一档 在线率
     * @param params
     * @return
     */
    public Integer querySysRanksAccountStatus(Map<String, Object> params);

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
     * 查询队伍管理数据
     *
     * @param ranks 队伍信息
     * @return 队伍信息集合
     */
    public List<SysRanks> selectRanksList(SysRanksVo ranks);


    List<Map<String,Object>> getSomeOneNoRegion();


    public List<SysRanksVo> queryRanksList(SysRanksVo ranks);


    public PageInfo<SysRanks> queryRanks(SysRanksVo ranks);

    List<UserInfoDto> selectCanBeChoose(Map<String,Object> map);


    /**
     * 新增队伍信息
     * @param ranks
     * @return
     */
    public int insertRanks(SysRanksVo ranks);


    /**
     * 新增队伍信息
     * @param ranks
     * @return
     */
    public int updateRanks(SysRanksVo ranks);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteRanksByIds(String ids);

    /**
     * 单个删除
     * @param id
     * @return
     */
    public int deleteRanksById(Long id);

    /**
     * 根据用户ID查询队伍信息
     * @param userId
     * @return
     */
    SysRanks selectRanksInfo(Long userId);

    /**
     * 队伍状态修改
     *
     * @param ranks 队伍信息
     * @return 结果
     */
    public int changeStatus(SysRanks ranks);

    /**
     * 一人一档 效率管理-社区选择
     * @param efficiencyParams
     * @return
     */
    List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysisByDeptName(Map<String, Object> efficiencyParams);
}
