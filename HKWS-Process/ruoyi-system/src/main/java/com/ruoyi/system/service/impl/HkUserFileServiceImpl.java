package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HkUserFileMapper;
import com.ruoyi.system.domain.HkUserFile;
import com.ruoyi.system.service.IHkUserFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户文件收藏关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
@Service
public class HkUserFileServiceImpl implements IHkUserFileService 
{
    @Autowired
    private HkUserFileMapper hkUserFileMapper;

    /**
     * 查询用户文件收藏关系
     * 
     * @param userId 用户文件收藏关系ID
     * @return 用户文件收藏关系
     */
    @Override
    public HkUserFile selectHkUserFileById(Long userId)
    {
        return hkUserFileMapper.selectHkUserFileById(userId);
    }

    /**
     * 查询用户文件收藏关系列表
     * 
     * @param hkUserFile 用户文件收藏关系
     * @return 用户文件收藏关系
     */
    @Override
    public List<HkUserFile> selectHkUserFileList(HkUserFile hkUserFile)
    {
        return hkUserFileMapper.selectHkUserFileList(hkUserFile);
    }

    /**
     * 新增用户文件收藏关系
     * 
     * @param hkUserFile 用户文件收藏关系
     * @return 结果
     */
    @Override
    public int insertHkUserFile(HkUserFile hkUserFile)
    {
        return hkUserFileMapper.insertHkUserFile(hkUserFile);
    }

    /**
     * 修改用户文件收藏关系
     * 
     * @param hkUserFile 用户文件收藏关系
     * @return 结果
     */
    @Override
    public int updateHkUserFile(HkUserFile hkUserFile)
    {
        return hkUserFileMapper.updateHkUserFile(hkUserFile);
    }

    /**
     * 删除用户文件收藏关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkUserFileByIds(String ids)
    {
        return hkUserFileMapper.deleteHkUserFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户文件收藏关系信息
     * 
     * @param userId 用户文件收藏关系ID
     * @return 结果
     */
    @Override
    public int deleteHkUserFileById(Long userId)
    {
        return hkUserFileMapper.deleteHkUserFileById(userId);
    }
}
