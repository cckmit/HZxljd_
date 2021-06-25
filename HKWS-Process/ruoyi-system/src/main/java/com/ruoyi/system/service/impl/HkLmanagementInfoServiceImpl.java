package com.ruoyi.system.service.impl;

import java.util.*;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.domain.HkEarlyWarning.HkLmInfoVo;
import com.ruoyi.system.mapper.HkEClassificationMapper;
import com.ruoyi.system.mapper.SysRegionMapper;
import com.ruoyi.system.mapper.SysRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkLmanagementInfoMapper;
import com.ruoyi.system.service.IHkLmanagementInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 自定义标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
@Service
public class HkLmanagementInfoServiceImpl implements IHkLmanagementInfoService
{
    @Autowired
    private HkLmanagementInfoMapper customLmMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRegionMapper regionMapper;

    @Autowired
    private HkEClassificationMapper eClassificationMapper;

    /**
     * 查询自定义标签
     * 
     * @param lmId 自定义标签ID
     * @return 自定义标签
     */
    @Override
    public HkLmanagementInfo selectHkLmanagementInfoById(Long lmId)
    {
        return customLmMapper.selectHkLmanagementInfoById(lmId);
    }

    @Override
    public HkLmInfoVo selectHkLmById(Long lmId) {
        HkLmInfoVo vo = new HkLmInfoVo();
        HkLmanagementInfo hkLmanagementInfo = customLmMapper.selectHkLmanagementInfoById(lmId);
        if(hkLmanagementInfo == null){
            return vo;
        }
        BeanUtils.copyProperties(hkLmanagementInfo,vo);
        List<HkEClassification> hkEClassifications = customLmMapper.queryLmEventType(lmId);
        if(hkEClassifications.size() > 0 && hkEClassifications.get(0) != null){
            vo.setEclassList(hkEClassifications);
        }
        Map<String,Object> param = new HashMap<>();
        param.put("lmId",lmId);
        List<SysRegion> sysRegions = customLmMapper.queryLmRegion(param);
        if(sysRegions.size() > 0 &&sysRegions.get(0) != null){
            vo.setRegionList(sysRegions);
        }
        List<SysRole> sysRoles = customLmMapper.queryLmRole(lmId);
        if(sysRoles.size() > 0 && sysRoles.get(0) != null){
            vo.setRoleList(sysRoles);
        }
        return vo;
    }

    /**
     * 查询自定义标签列表
     * 
     * @param hkLmanagementInfo 自定义标签
     * @return 自定义标签
     */
    @Override
    public List<HkLmInfoVo> selectHkLmList(HkLmanagementInfo hkLmanagementInfo)
    {
        List<HkLmInfoVo> result = new ArrayList<>();
        List<HkLmanagementInfo> list = customLmMapper.selectHkLmanagementInfoList(hkLmanagementInfo);
        if(list != null && list.size() > 0){
            for(HkLmanagementInfo dto : list){
                HkLmInfoVo vo = new HkLmInfoVo();
                BeanUtils.copyProperties(dto,vo);
                List<HkEClassification> hkEClassifications = customLmMapper.queryLmEventType(dto.getLmId());
                if(hkEClassifications.size() > 0 && hkEClassifications.get(0) != null){
                    vo.setEclassList(hkEClassifications);
                }
                Map<String,Object> param = new HashMap<>();
                param.put("lmId",dto.getLmId());
                param.put("level",3);
                List<SysRegion> sysRegions = customLmMapper.queryLmRegion(param);
                if(sysRegions.size() > 0 &&sysRegions.get(0) != null){
                    vo.setRegionList(sysRegions);
                }
                List<SysRole> sysRoles = customLmMapper.queryLmRole(dto.getLmId());
                if(sysRoles.size() > 0 && sysRoles.get(0) != null){
                    vo.setRoleList(sysRoles);
                }
                result.add(vo);
            }
        }
        return result;
    }

    @Override
    public List<HkLmanagementInfo> selectHkLmanagementInfoList(HkLmanagementInfo hkLmanagementInfo) {
        return customLmMapper.selectHkLmanagementInfoList(hkLmanagementInfo);
    }

    /**
     * 新增自定义标签
     * 
     * @param hkLmanagementInfo 自定义标签
     * @return 结果
     */
    @Override
    public int insertHkLmanagementInfo(HkLmanagementInfo hkLmanagementInfo)
    {
        hkLmanagementInfo.setCreateTime(DateUtils.getNowDate());
        return customLmMapper.insertHkLmanagementInfo(hkLmanagementInfo);
    }

    /**
     * 修改自定义标签
     * 
     * @param vo 自定义标签
     * @return 结果
     */
    @Override
    public int updateHkLmanagementInfo(HkLmInfoVo vo)
    {
        HkLmanagementInfo info = new HkLmanagementInfo();
        BeanUtils.copyProperties(vo,info);
        /*List<SysRole> roleList = vo.getRoleList();
        List<SysRegion> regionList = vo.getRegionList();
        List<HkEClassification> eclassList = vo.getEclassList();
        StringBuilder sb1 = new StringBuilder();
        for(SysRole role : roleList){
            sb1.append(role.getRoleId()).append(",");
        }
        if (StringUtils.isNotEmpty(sb1.toString())){
            info.setLmAuth(sb1.substring(0,sb1.length()-1));
        }
        StringBuilder sb2 = new StringBuilder();
        for(SysRegion region : regionList){
            sb2.append(region.getRegionId()).append(",");
        }
        if (StringUtils.isNotEmpty(sb2.toString())){
            info.setLmRegion(sb2.substring(0,sb2.length()-1));
        }
        StringBuilder sb3 = new StringBuilder();
        for(HkEClassification eclass : eclassList){
            sb3.append(eclass.getEc_name_type()).append(",");
        }
        if (StringUtils.isNotEmpty(sb3.toString())){
            info.setLmEventType(sb3.substring(0,sb3.length()-1));
        }*/
        info.setUpdateTime(DateUtils.getNowDate());
        return customLmMapper.updateHkLmanagementInfo(info);
    }

    /**
     * 删除自定义标签对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkLmanagementInfoByIds(String ids)
    {
        return customLmMapper.deleteHkLmanagementInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除自定义标签信息
     * 
     * @param lmId 自定义标签ID
     * @return 结果
     */
    @Override
    public int deleteHkLmanagementInfoById(Long lmId)
    {
        return customLmMapper.deleteHkLmanagementInfoById(lmId);
    }

    @Override
    public String checkLmNameUnique(String lmName, Long lmId) {
        int count = customLmMapper.checkLmNameUnique(lmName,lmId);
        if (count > 0)
        {
            return UserConstants.CUSTOM_LM_NAME_NOT_UNIQUE;
        }
        return UserConstants.CUSTOM_LM_NAME_UNIQUE;
    }

    @Override
    public List<SysRole> queryLmRole(Long lmId) {
        List<SysRole> sysRoles = customLmMapper.queryLmRole(lmId);
        List<SysRole> roles = roleMapper.selectRoleList(new SysRole());
        for (SysRole role : roles) {
            for (SysRole userRole : sysRoles) {
                if(null == userRole){
                    break;
                }
                if (role.getRoleId().longValue() == userRole.getRoleId().longValue()) {
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    @Override
    public List<SysRegion> queryLmRegion(Long lmId) {
        Map<String,Object> param = new HashMap<>();
        param.put("lmId",lmId);
        List<SysRegion> sysRegions = customLmMapper.queryLmRegion(param);
        if(sysRegions != null && sysRegions.size() > 0 && sysRegions.get(0) != null){
            return sysRegions;
        }
        return new ArrayList<>();
    }

    @Override
    public List<HkEClassification> queryLmEventType(Long lmId) {
        List<HkEClassification> lmEclassList = customLmMapper.queryLmEventType(lmId);
        List<HkEClassification> eclassList = eClassificationMapper.queryEventEClassifications();
        for(HkEClassification eclass : eclassList){
            for(HkEClassification lmEclass : lmEclassList){
                if(null == lmEclass){
                    break;
                }
                if(eclass.getEc_name_type().equals(lmEclass.getEc_name_type())){
                    eclass.setFlag(true);
                    break;
                }
            }
        }
        return eclassList;
    }

    @Override
    public List<Ztree> lmRegionTreeData(Long lmId) {
        HkLmanagementInfo hkLmanagementInfo = customLmMapper.selectHkLmanagementInfoById(lmId);
        String lmRegion = hkLmanagementInfo.getLmRegion();
        List<SysRegion> sysRegions = regionMapper.selectSysRegionList(new SysRegion());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        if (!StringUtils.isEmpty(lmRegion))
        {
            Map<String,Object> param = new HashMap<>();
            param.put("lmId",lmId);
            List<SysRegion> lmRegionList = customLmMapper.queryLmRegion(param);
            List<String> stringList = new ArrayList<>();
            for(SysRegion region : lmRegionList){
                if(null == region){
                    break;
                }
                stringList.add(region.getRegionId()+region.getRegionName());
            }
            ztrees = initZtree(sysRegions, stringList);
        }
        else
        {
            ztrees = initZtree(sysRegions, null);
        }
        return ztrees;
    }

    @Override
    public List<HkLmanagementInfo> queryLmByEvent(Long eventId) {
        return customLmMapper.queryLmByEvent(eventId);
    }


    /**
     * 对象转部门树
     *
     * @param regionList 区域列表
     * @param lmRegionList 标签已存在区域列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysRegion> regionList, List<String> lmRegionList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(lmRegionList);
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
                    ztree.setChecked(lmRegionList.contains(region.getRegionId() + region.getRegionName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

}
