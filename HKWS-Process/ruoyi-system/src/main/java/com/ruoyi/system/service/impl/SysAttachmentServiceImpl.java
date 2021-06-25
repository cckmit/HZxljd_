package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import com.ruoyi.system.service.ISysAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 附件Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-17
 */
@Service
public class SysAttachmentServiceImpl implements ISysAttachmentService
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    /**
     * 查询附件
     *
     * @param attachmentId 附件ID
     * @return 附件
     */
    @Override
    public SysAttachment selectSysAttachmentById(Integer attachmentId)
    {
        return sysAttachmentMapper.selectSysAttachmentById(attachmentId);
    }

    /**
     * 查询附件列表
     *
     * @param sysAttachment 附件
     * @return 附件
     */
    @Override
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
    }

    /**
     * 新增附件
     *
     * @param sysAttachment 附件
     * @return 结果
     */
    @Override
    public int insertSysAttachment(SysAttachment sysAttachment)
    {
        sysAttachment.setCreateTime(DateUtils.getNowDate());
        return sysAttachmentMapper.insertSysAttachment(sysAttachment);
    }

    /**
     * 修改附件
     *
     * @param sysAttachment 附件
     * @return 结果
     */
    @Override
    public int updateSysAttachment(SysAttachment sysAttachment)
    {
        sysAttachment.setUpdateTime(DateUtils.getNowDate());
        return sysAttachmentMapper.updateSysAttachment(sysAttachment);
    }

    /**
     * 删除附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentByIds(String ids)
    {
        return sysAttachmentMapper.deleteSysAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件信息
     *
     * @param attachmentId 附件ID
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentById(Integer attachmentId)
    {
        return sysAttachmentMapper.deleteSysAttachmentById(attachmentId);
    }

    /**
     * 通过fileCode查询附件信息
     * @param uuid
     * @return
     */
    @Override
    public List<SysAttachment> selectAttachmentByFileCode(String fileCode) {
        return sysAttachmentMapper.selectAttachmentByFileCode(fileCode);
    }
}
