package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HkUserFile;

/**
 * 用户文件收藏关系Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-11
 */
public interface HkUserFileMapper 
{
    /**
     * 查询用户文件收藏关系
     * 
     * @param userId 用户文件收藏关系ID
     * @return 用户文件收藏关系
     */
    public HkUserFile selectHkUserFileById(Long userId);

    /**
     * 查询用户文件收藏关系列表
     * 
     * @param hkUserFile 用户文件收藏关系
     * @return 用户文件收藏关系集合
     */
    public List<HkUserFile> selectHkUserFileList(HkUserFile hkUserFile);

    /**
     * 新增用户文件收藏关系
     * 
     * @param hkUserFile 用户文件收藏关系
     * @return 结果
     */
    public int insertHkUserFile(HkUserFile hkUserFile);

    /**
     * 修改用户文件收藏关系
     * 
     * @param hkUserFile 用户文件收藏关系
     * @return 结果
     */
    public int updateHkUserFile(HkUserFile hkUserFile);

    /**
     * 删除用户文件收藏关系
     * 
     * @param userId 用户文件收藏关系ID
     * @return 结果
     */
    public int deleteHkUserFileById(Long userId);

    /**
     * 批量删除用户文件收藏关系
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHkUserFileByIds(String[] userIds);
}
