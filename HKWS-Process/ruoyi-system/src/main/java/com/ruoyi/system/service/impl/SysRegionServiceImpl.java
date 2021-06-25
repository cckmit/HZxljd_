package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.HkEarlyWarning.RegionChangeVO;
import com.ruoyi.system.domain.HkEarlyWarning.RegionLoadVO;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.dto.RegionDto;
import com.ruoyi.system.mapper.HkMapCoverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRegionMapper;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.service.ISysRegionService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 区域Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-09
 */
@Service
public class SysRegionServiceImpl implements ISysRegionService 
{

    @Autowired
    private SysRegionMapper sysRegionMapper;

    @Autowired
    private HkMapCoverMapper hkMapCoverMapper;

    /**
     * 查询区域
     * 
     * @param regionId 区域ID
     * @return 区域
     */
    @Override
    public SysRegion selectSysRegionById(Long regionId)
    {
        return sysRegionMapper.selectSysRegionById(regionId);
    }

    /**
     * 查询部门人数
     * @param parentId 部门ID
     * @return 结果
     */
    @Override
    public int selectRegionCount(Long parentId)
    {
        SysRegion region = new SysRegion();
        region.setParentId(parentId.toString());
        return sysRegionMapper.selectRegionCount(region);
    }


    /**
     * 校验区域名称是否唯一
     * @param region 区域信息
     * @return 结果
     */
    @Override
    public String checkRegionNameUnique(SysRegion region)
    {
        String parentId = region.getParentId();
        Long regionId = StringUtils.isNull(region.getRegionId()) ? -1L : region.getRegionId();
        SysRegion info = sysRegionMapper.checkRegionNameUnique(region.getRegionName(), Long.valueOf(parentId).longValue());
        if (StringUtils.isNotNull(info) && info.getRegionId().longValue() != regionId.longValue())
        {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }

    @Override
    public List<Ztree> selectRegionTree(SysRegion region) {
        List<SysRegion> deptList = sysRegionMapper.selectSysRegionList(region);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    /**
     * 对象转区域树
     * @param regionList 区域列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysRegion> regionList)
    {
        return initZtree(regionList, null);
    }

    /**
     * 对象转区域树
     *
     * @param regionList 区域列表
     * @param userRegionList 用户已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysRegion> regionList, List<String> userRegionList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(userRegionList);
        for (SysRegion region : regionList)
        {
            if (UserConstants.DEPT_NORMAL.equals(region.getStatus()))
            {
                String parentId = region.getParentId();
                Ztree ztree = new Ztree();
                ztree.setId(region.getRegionId());
                ztree.setpId(Long.valueOf(parentId).longValue());
                ztree.setName(region.getRegionName());
                ztree.setTitle(region.getRegionName());
                if (isCheck)
                {
                    ztree.setChecked(userRegionList.contains(region.getRegionId() + region.getRegionName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

    /**
     * 查询区域列表
     * 
     * @param sysRegion 区域
     * @return 区域
     */
    @Override
    public List<SysRegion> selectSysRegionList(SysRegion sysRegion)
    {
        return sysRegionMapper.selectSysRegionList(sysRegion);
    }

    /**
     * 新增区域
     * 
     * @param sysRegion 区域
     * @return 结果
     */
    @Override
    public int insertSysRegion(SysRegion sysRegion)
    {
        sysRegion.setCreateTime(DateUtils.getNowDate());
        return sysRegionMapper.insertSysRegion(sysRegion);
    }

    /**
     * 修改区域
     * 
     * @param sysRegion 区域
     * @return 结果
     */
    @Override
    public int updateSysRegion(SysRegion sysRegion)
    {
        sysRegion.setUpdateTime(DateUtils.getNowDate());
        return sysRegionMapper.updateSysRegion(sysRegion);
    }

    /**
     * 删除区域对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRegionByIds(String ids)
    {
        return sysRegionMapper.deleteSysRegionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除区域信息
     * 
     * @param regionId 区域ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteSysRegionById(Long regionId)
    {
        hkMapCoverMapper.updateDelFlagByParentId(regionId);
        return sysRegionMapper.deleteSysRegionById(regionId);
    }

    @Override
    public List<SysRegion> findSysRegionList() {
        return sysRegionMapper.findSysRegionList();
    }

    @Override
    public List<Map<String, Object>> getSomeRegionNoUser() {
        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String, Object>> ranksCountByRegion = sysRegionMapper.getRanksCountByRegion();
        for(Map<String,Object> map : ranksCountByRegion){
            if(Integer.parseInt(map.get("userCount")+"") == 0){
                result.add(map);
            }
        }
        return result;
    }

    @Override
    public Long queryParentRegionByRegionId(Long regionId) {
        return sysRegionMapper.queryParentRegionByRegionId(regionId);
    }

    @Override
    public String queryRegionAncestorsByRegion(Integer regionId) {
        String result = "";
        List<String> stringList = sysRegionMapper.queryRegionAncestorsByRegion(regionId);
        for(int i=0;i<stringList.size();i++){
            if(i > 0){
                result += " / "+stringList.get(i);
            }else{
                result = stringList.get(i);
            }
        }
        return result;
    }

    @Override
    public List<RegionDto> queryRegionTree() {
        return hkMapCoverMapper.getAllRegions();
    }

    @Override
    public int queryRegionCountByParam(Map<String, Object> param) {
        return sysRegionMapper.queryRegionCountByParam(param);
    }

    @Override
    public List<RegionChangeVO> queryRegionChange(Map<String, Object> params) {
        return sysRegionMapper.queryRegionChange(params);
    }

    @Override
    public List<RegionLoadVO> queryRegionLoad(Map<String, Object> params) {
        List<RegionLoadVO> eventCounts = sysRegionMapper.queryRegionLoad(params);
        List<RegionLoadVO> userCounts = sysRegionMapper.queryUserCountByRegion(params);
        for(RegionLoadVO vo : eventCounts){
            for(RegionLoadVO subVo : userCounts){
                if(vo.getRegionName().equals(subVo.getRegionName())){
                    vo.setUserCount(subVo.getUserCount());
                }
            }
        }
        return eventCounts;
    }

    @Override
    public List<SysRegion> queryRegionNames() {
        return sysRegionMapper.queryRegionNames();
    }

    @Override
    public int queryVillageCommunity() {
        return sysRegionMapper.queryVillageCommunity();
    }

    @Override
    public int queryGridALl() {
        return sysRegionMapper.queryGridALl();
    }

    @Override
    public List<SysRegion> selectRegionList() {
        return sysRegionMapper.selectRegionList();
    }

    @Override
    public String queryCommunityName(String deptId) {
        return sysRegionMapper.queryCommunityName(deptId);
    }

    @Override
    public List<SysRegion> queryCommunitList(SysRegion sysRegion) {
        return sysRegionMapper.queryCommunitList(sysRegion);
    }

    @Override
    public List<SysRegion> queryCommunitWangList(SysRegion sysRegion) {
        return sysRegionMapper.queryCommunitWangList(sysRegion);
    }

    @Override
    public List<SysRegion> queryGrilName(SysRegion sysRegion) {
        return sysRegionMapper.queryGrilName(sysRegion);
    }

    @Override
    public List<SysRegion> queryCommunitWangListAll(SysRegion sysRegion) {
        return sysRegionMapper.queryCommunitWangListAll(sysRegion);
    }
}
