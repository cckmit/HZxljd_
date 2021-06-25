package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HkFileBase;

/**
 * 资料库Service接口
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
public interface IHkFileBaseService 
{
    /**
     * 查询资料库
     * 
     * @param id 资料库ID
     * @return 资料库
     */
    public HkFileBase selectHkFileBaseById(Long id);

    /**
     * 查询资料库列表
     * 
     * @param hkFileBase 资料库
     * @return 资料库集合
     */
    public List<HkFileBase> selectHkFileBaseList(HkFileBase hkFileBase);

    /**
     * 新增资料库
     * 
     * @param hkFileBase 资料库
     * @return 结果
     */
    public int insertHkFileBase(HkFileBase hkFileBase);

    /**
     * 修改资料库
     * 
     * @param hkFileBase 资料库
     * @return 结果
     */
    public int updateHkFileBase(HkFileBase hkFileBase);

    /**
     * 批量删除资料库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkFileBaseByIds(String ids);

    /**
     * 删除资料库信息
     * 
     * @param id 资料库ID
     * @return 结果
     */
    public int deleteHkFileBaseById(Long id);
}
