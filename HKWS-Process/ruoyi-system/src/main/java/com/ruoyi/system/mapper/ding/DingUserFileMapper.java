package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.HkFileBase;
import com.ruoyi.system.domain.HkUserFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingUserFileMapper
 * @Author: guohailong
 * @Description: 浙政钉-da接口
 * @Date: 2021/3/11 11:04
 * @Version: 1.0
 */
public interface DingUserFileMapper {

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

    HkUserFile selectUserFileByUserIdAndFileId(@Param("userId") Long userId,@Param("fileId") Long fileId);

    int deleteUserFileByUserIdAndFileId(@Param("userId") Long userId,@Param("fileId") Long fileId);


}
