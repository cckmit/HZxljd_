package com.ruoyi.system.service.ding;

import com.ruoyi.system.domain.HkFileBase;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.ding
 * @ClassName: DingFileBaseService
 * @Author: guohailong
 * @Description: 浙政钉-资料库服务
 * @Date: 2021/3/11 1:05
 * @Version: 1.0
 */
public interface DingFileBaseService {
    /**
     * 所有
     * @param userId
     * @return
     */
    List<HkFileBase> getMyFileListByUserId(Long userId);

    /**
     * 最近4个
     * @param userId
     * @return
     */
    List<HkFileBase> getMyFileHomeByUserId(Long userId);

    List<HkFileBase> getShareFileList(Long userId);

    void insert(HkFileBase hkFileBase);

    int shareFile(Long id);

    int collectFile(Long userId, Long fileId);


}
