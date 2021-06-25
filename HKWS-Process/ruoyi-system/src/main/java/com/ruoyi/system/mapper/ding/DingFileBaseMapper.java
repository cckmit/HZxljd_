package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.HkFileBase;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingFileBaseMapper
 * @Author: guohailong
 * @Description:
 * @Date: 2021/3/11 1:04
 * @Version: 1.0
 */
public interface DingFileBaseMapper {

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
     * 删除资料库
     *
     * @param id 资料库ID
     * @return 结果
     */
    public int deleteHkFileBaseById(Long id);

    /**
     * 批量删除资料库
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkFileBaseByIds(String[] ids);


    /**
     * 获取我所有文件
     * @param userId
     * @return
     */
    List<HkFileBase> getMyFileListByUserId(Long userId);


    /**
     * 获取我最近4个文件
     * @param userId
     * @return
     */
    List<HkFileBase> getMyFileHomeByUserId(Long userId);


    List<HkFileBase> getShareFileList(Long userId);

}
