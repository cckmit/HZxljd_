package com.ruoyi.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.HkEarlyWarning.PeopleDisposalAnalysisVO;
import com.ruoyi.system.domain.HkEarlyWarning.PeopleTimeVO;
import com.ruoyi.system.domain.HkEarlyWarning.SysRanksVo;
import com.ruoyi.system.domain.HkEntity.UserInfoDto;
import com.ruoyi.system.domain.HkEntity.UserPostRegionVo;
import com.ruoyi.system.mapper.SysRanksDeptMapper;
import com.ruoyi.system.mapper.SysRanksMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserPostRegionMapper;
import com.ruoyi.system.service.ISysRanksService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ruoyi
 */
@Service
public class SysRanksServiceImpl implements ISysRanksService
{
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRanksMapper ranksMapper;

    @Autowired
    private SysUserPostRegionMapper userPostRegionMapper;


    @Override
    public Integer querySysRanksCount(Map<String, Object> params) {
        return ranksMapper.querySysRanksCount(params);
    }

    @Override
    public Integer querySysRanksAccountStatus(Map<String, Object> params) {
        return ranksMapper.querySysRanksAccountStatus(params);
    }

    @Override
    public List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysis(Map<String, Object> params) {
        return ranksMapper.queryPeopleDisposalAnalysis(params);
    }

    @Override
    public List<PeopleTimeVO> queryPeopleTime(Map<String, Object> params) {
        return ranksMapper.queryPeopleTime(params);
    }

    @Override
    public Integer queryPeopleType(Map<String, Object> params) {
        return ranksMapper.queryPeopleType(params);
    }

    /**
     * 队伍列表
     * @param ranks 队伍信息
     * @return
     */
    @Override
    public List<SysRanks> selectRanksList(SysRanksVo ranks) {
        List<SysRanks> sysRanks = ranksMapper.selectRanksList(ranks);
        return sysRanks;
    }

    @Override
    public List<Map<String,Object>> getSomeOneNoRegion() {
        List<Map<String,Object>> list = ranksMapper.getRegionCountByRanks();
        List<Map<String,Object>> result = new ArrayList<>();
        for(Map<String,Object> map : list){
            /*Map<String,Object> item = new HashMap<>();*/
            if(StringUtils.isEmpty(map.get("deptName")+"") || Integer.parseInt(map.get("regionCount")+"") == 0){
                result.add(map);
            }
        }
        return result;
    }

    @Override
    public List<SysRanksVo> queryRanksList(SysRanksVo vo) {
        List<SysRanksVo> ranksVos = new ArrayList<>();
        List<SysRanks> sysRanksList = ranksMapper.selectRanksList(vo);
        if(sysRanksList != null && sysRanksList.size() > 0){
            for(SysRanks ranks : sysRanksList){
                SysRanksVo ranksVo = new SysRanksVo();
                BeanUtils.copyProperties(ranks,ranksVo);

                ranksVos.add(ranksVo);
            }
        }
        return ranksVos;
    }

    @Override
    public List<UserInfoDto> selectCanBeChoose(Map<String,Object> param) {
        List<UserInfoDto> sysRanks = ranksMapper.selectCanBeChoose(param);
        if(sysRanks != null && sysRanks.size() > 0){
            for(UserInfoDto user : sysRanks){
                Map<String,List<UserPostRegionVo>> userPostRegionStr = new HashMap<>();
                List<UserPostRegionVo> sysUserPostRegionList = userPostRegionMapper.queryUserPostRegionInfo((long) user.getUserId());
                if(sysUserPostRegionList != null && sysUserPostRegionList.size() > 0){
                    //职能对应区域集合
                    userPostRegionStr = sysUserPostRegionList.stream().collect(
                            Collectors.groupingBy(
                                    post ->post.getPostId().toString() //根据岗位id分组
                            ));
                    user.setUserParams(userPostRegionStr);
                }
            }
        }
        return sysRanks;
    }


    @Override
    public PageInfo<SysRanks> queryRanks(SysRanksVo ranks) {
        PageHelper.startPage(ranks.getPageNum(),ranks.getPageSize());
        List<SysRanks> list = ranksMapper.selectRanksList(ranks);
        PageInfo<SysRanks> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insertRanks(SysRanksVo ranks) {
        return ranksMapper.insertRanks(ranks);
    }

    /**
     * 更新队伍信息
     * @param ranks
     * @return
     */
    @Override
    public int updateRanks(SysRanksVo ranks) {
        return ranksMapper.updateRanks(ranks);
    }

    /**
     * 删除队伍信息
     * @return
     */
    @Override
    public int deleteRanksByIds(String ids) {
        Long[] ranksIds = Convert.toLongArray(ids);
        return ranksMapper.deleteRanksByIds(ranksIds);
    }

    @Override
    public int deleteRanksById(Long id) {
        return ranksMapper.deleteRanksById(id);
    }

    @Override
    public SysRanks selectRanksInfo(Long ranksId) {
        SysRanks ranks = new SysRanks();
        ranks.setRanksId(ranksId);
        return ranksMapper.selectRanksInfo(ranks);
    }

    /**
     * 更新队伍状态
     * @param ranks 队伍信息
     * @return
     */
    @Override
    public int changeStatus(SysRanks ranks) {
        return ranksMapper.changeStatus(ranks);
    }

    @Override
    public List<PeopleDisposalAnalysisVO> queryPeopleDisposalAnalysisByDeptName(Map<String, Object> efficiencyParams) {
        return ranksMapper.queryPeopleDisposalAnalysisByDeptName(efficiencyParams);
    }

}
