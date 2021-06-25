package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.HkMapCover;
import com.ruoyi.system.mapper.HkMapCoverMapper;
import com.ruoyi.system.service.IHkMapCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl
 * @ClassName: HkMapCoverServiceImpl
 * @Author: guohailong
 * @Description: 地图覆盖物
 * @Date: 2021/3/16 1:43
 * @Version: 1.0
 */
@Service
public class HkMapCoverServiceImpl implements IHkMapCoverService {
    @Autowired
    private HkMapCoverMapper hkMapCoverMapper;



    /**
     * 新增地图覆盖物-地区关联
     *
     * @param hkMapCover 地图覆盖物-地区关联
     * @return 结果
     */
    @Override
    @Transactional
    public int insertHkMapCover(HkMapCover hkMapCover) {
        try {
            //如果有,先删除原有的数据
            hkMapCoverMapper.updateDelFlagByParentId(hkMapCover.getParentId());
            //新增一条新数据
            return hkMapCoverMapper.insertHkMapCover(hkMapCover);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("操作失败");
        }
    }




    /**
     * 根据地区id查询覆盖物
     *
     * @param regionId
     * @return
     */
    @Override
    public HkMapCover getHkMapCover(Long regionId) {
        return hkMapCoverMapper.getHkMapCover(regionId);
    }

    @Override
    public List<HkMapCover> getChildHkMapCoverList(Long regionId) {
        return hkMapCoverMapper.getChildHkMapCoverList(regionId);
    }

    @Override
    public List<HkMapCover> getBrotherHkMapCoverList(Long regionId) {
        return hkMapCoverMapper.getBrotherHkMapCoverList(regionId);
    }

    /**
     * 根据地区id删除当前覆盖物
     *
     * @param regionId
     * @return
     */
    @Override
    @Transactional
    public int deleteHkMapCoverByParentId(Long regionId) {
        try {
            return hkMapCoverMapper.updateDelFlagByParentId(regionId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("操作失败");
        }
    }

    /**
     * 获取当前地区父节点的覆盖物(获取上级地区覆盖物)
     * @param regionId
     * @return
     */
    @Override
    public HkMapCover getParentHkMapCover(Long regionId) {
        return hkMapCoverMapper.getParentHkMapCover(regionId);
    }

    /**
     * 获取所有地区点位
     * @return
     */
    @Override
    public List<HkMapCover> getALLMapCoverList() {
        return hkMapCoverMapper.getALLMapCoverList();
    }

    /**
     * 获取当前地区堂兄弟节点
     * @param regionId
     * @return
     */
    @Override
    public List<HkMapCover> getCousinHkMapCoverList(Long regionId) {

        return hkMapCoverMapper.getCousinHkMapCoverList(regionId);
    }
}
