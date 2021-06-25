package com.ruoyi.system.service.impl.ding;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.HkFileBase;
import com.ruoyi.system.domain.HkUserFile;
import com.ruoyi.system.mapper.ding.DingFileBaseMapper;
import com.ruoyi.system.mapper.ding.DingUserFileMapper;
import com.ruoyi.system.service.ding.DingFileBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl.ding
 * @ClassName: DingFileBaseServiceImpl
 * @Author: guohailong
 * @Description: 浙政钉-资料库
 * @Date: 2021/3/11 1:05
 * @Version: 1.0
 */
@Service
public class DingFileBaseServiceImpl implements DingFileBaseService {

    @Resource
    private DingFileBaseMapper dingFileBaseMapper;

    @Resource
    private DingUserFileMapper dingUserFileMapper;

    /**
     * 获取我所有的资料.倒叙
     *
     * @param userId
     * @return
     */
    @Override
    public List<HkFileBase> getMyFileListByUserId(Long userId) {
        return dingFileBaseMapper.getMyFileListByUserId(userId);
    }

    @Override
    public List<HkFileBase> getMyFileHomeByUserId(Long userId) {
        return dingFileBaseMapper.getMyFileHomeByUserId(userId);
    }


    /**
     * 获取所有分享资料(不包括我自己的)
     *
     * @return
     */
    @Override
    public List<HkFileBase> getShareFileList(Long userId) {
        return dingFileBaseMapper.getShareFileList(userId);
    }

    /**
     * 新增上传文件保存
     *
     * @param hkFileBase
     */
    @Override
    @Transactional
    public void insert(HkFileBase hkFileBase) {
        dingFileBaseMapper.insertHkFileBase(hkFileBase);
    }

    /**
     * 分享/取消
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int shareFile(Long id) {
        try {
            HkFileBase hkFileBase = dingFileBaseMapper.selectHkFileBaseById(id);
            //如果共享 则取消
            if (hkFileBase.getShareFlag() == 1) {
                hkFileBase.setShareFlag(0);
                hkFileBase.setUpdateTime(DateUtils.getNowDate());
                int result = dingFileBaseMapper.updateHkFileBase(hkFileBase);
                if (result == 1) {
                    return 10;
                } else {
                    throw new RuntimeException("取消失败");
                }
            } else {
                hkFileBase.setShareFlag(1);
                hkFileBase.setUpdateTime(DateUtils.getNowDate());
                int result = dingFileBaseMapper.updateHkFileBase(hkFileBase);
                if (result == 1) {
                    return 20;
                } else {
                    throw new RuntimeException("分享成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
    }

    /**
     * 收藏/取消文件
     *
     * @param userId
     * @param fileId
     * @return
     */
    @Override
    public int collectFile(Long userId, Long fileId) {
        try {
            HkUserFile userFile = dingUserFileMapper.selectUserFileByUserIdAndFileId(userId, fileId);
            //如果不存在.则进行新增.新增成功返回收藏成功
            if (userFile == null) {
                HkUserFile newUserFile = new HkUserFile();
                newUserFile.setUserId(userId);
                newUserFile.setFileId(fileId);
                int result = dingUserFileMapper.insertHkUserFile(newUserFile);
                if (result == 1) {
                    return 10;
                } else {
                    throw new RuntimeException("收藏失败");
                }
            } else {
                int result = dingUserFileMapper.deleteUserFileByUserIdAndFileId(userId, fileId);
                if (result == 1) {
                    return 20;
                } else {
                    throw new RuntimeException("取消失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
    }


}
