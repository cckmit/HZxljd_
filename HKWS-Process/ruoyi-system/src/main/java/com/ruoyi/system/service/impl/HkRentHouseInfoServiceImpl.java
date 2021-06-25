package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkRentHouseInfoMapper;
import com.ruoyi.system.domain.HkRentHouseInfo;
import com.ruoyi.system.service.IHkRentHouseInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房屋管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
@Service
public class HkRentHouseInfoServiceImpl implements IHkRentHouseInfoService 
{
    @Autowired
    private HkRentHouseInfoMapper hkRentHouseInfoMapper;

    /**
     * 查询房屋管理
     * 
     * @param id 房屋管理ID
     * @return 房屋管理
     */
    @Override
    public HkRentHouseInfo selectHkRentHouseInfoById(Long id)
    {
        return hkRentHouseInfoMapper.selectHkRentHouseInfoById(id);
    }

    /**
     * 查询房屋管理列表
     * 
     * @param hkRentHouseInfo 房屋管理
     * @return 房屋管理
     */
    @Override
    public List<HkRentHouseInfo> selectHkRentHouseInfoList(HkRentHouseInfo hkRentHouseInfo)
    {
        return hkRentHouseInfoMapper.selectHkRentHouseInfoList(hkRentHouseInfo);
    }

    @Override
    public int reportHouseInfo(HkRentHouseInfo hkRentHouseInfo) {
        HkRentHouseInfo houseInfo = hkRentHouseInfoMapper.selectHkRentHouseInfoByCode(hkRentHouseInfo.getHouseCode());
        int count = 0;
        if(houseInfo != null){
            BeanUtils.copyProperties(hkRentHouseInfo,houseInfo);
            count = hkRentHouseInfoMapper.updateHkRentHouseInfo(houseInfo);
        }else{
            count = hkRentHouseInfoMapper.insertHkRentHouseInfo(hkRentHouseInfo);
        }
        return count;
    }

    /**
     * 新增房屋管理
     * 
     * @param hkRentHouseInfo 房屋管理
     * @return 结果
     */
    @Override
    public int insertHkRentHouseInfo(HkRentHouseInfo hkRentHouseInfo)
    {
        return hkRentHouseInfoMapper.insertHkRentHouseInfo(hkRentHouseInfo);
    }

    /**
     * 修改房屋管理
     * 
     * @param hkRentHouseInfo 房屋管理
     * @return 结果
     */
    @Override
    public int updateHkRentHouseInfo(HkRentHouseInfo hkRentHouseInfo)
    {
        return hkRentHouseInfoMapper.updateHkRentHouseInfo(hkRentHouseInfo);
    }

    /**
     * 删除房屋管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkRentHouseInfoByIds(String ids)
    {
        return hkRentHouseInfoMapper.deleteHkRentHouseInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房屋管理信息
     * 
     * @param id 房屋管理ID
     * @return 结果
     */
    @Override
    public int deleteHkRentHouseInfoById(Long id)
    {
        return hkRentHouseInfoMapper.deleteHkRentHouseInfoById(id);
    }

    /**
     * 查询出租房屋数量
     * @param params
     * @return
     */
    @Override
    public int allCount(Map<String, Object> params) {
        return hkRentHouseInfoMapper.allCount(params);
    }
}
