package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkFileBaseMapper;
import com.ruoyi.system.domain.HkFileBase;
import com.ruoyi.system.service.IHkFileBaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资料库Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@Service
public class HkFileBaseServiceImpl implements IHkFileBaseService 
{
    @Autowired
    private HkFileBaseMapper hkFileBaseMapper;

    /**
     * 查询资料库
     * 
     * @param id 资料库ID
     * @return 资料库
     */
    @Override
    public HkFileBase selectHkFileBaseById(Long id)
    {
        return hkFileBaseMapper.selectHkFileBaseById(id);
    }

    /**
     * 查询资料库列表
     * 
     * @param hkFileBase 资料库
     * @return 资料库
     */
    @Override
    public List<HkFileBase> selectHkFileBaseList(HkFileBase hkFileBase)
    {
        return hkFileBaseMapper.selectHkFileBaseList(hkFileBase);
    }

    /**
     * 新增资料库
     * 
     * @param hkFileBase 资料库
     * @return 结果
     */
    @Override
    public int insertHkFileBase(HkFileBase hkFileBase)
    {
        hkFileBase.setCreateTime(DateUtils.getNowDate());
        return hkFileBaseMapper.insertHkFileBase(hkFileBase);
    }

    /**
     * 修改资料库
     * 
     * @param hkFileBase 资料库
     * @return 结果
     */
    @Override
    public int updateHkFileBase(HkFileBase hkFileBase)
    {
        hkFileBase.setUpdateTime(DateUtils.getNowDate());
        return hkFileBaseMapper.updateHkFileBase(hkFileBase);
    }

    /**
     * 删除资料库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkFileBaseByIds(String ids)
    {
        return hkFileBaseMapper.deleteHkFileBaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资料库信息
     * 
     * @param id 资料库ID
     * @return 结果
     */
    @Override
    public int deleteHkFileBaseById(Long id)
    {
        return hkFileBaseMapper.deleteHkFileBaseById(id);
    }
}
