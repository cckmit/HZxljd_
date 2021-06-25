package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysAttachment;

import java.util.List;

/**
 * 附件Service接口
 *
 * @author ruoyi
 * @date 2021-06-17
 */
public interface ISysAttachmentService
{
    /**
     * 查询附件
     *
     * @param attachmentId 附件ID
     * @return 附件
     */
    public SysAttachment selectSysAttachmentById(Integer attachmentId);

    /**
     * 查询附件列表
     *
     * @param sysAttachment 附件
     * @return 附件集合
     */
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment);

    /**
     * 新增附件
     *
     * @param sysAttachment 附件
     * @return 结果
     */
    public int insertSysAttachment(SysAttachment sysAttachment);

    /**
     * 修改附件
     *
     * @param sysAttachment 附件
     * @return 结果
     */
    public int updateSysAttachment(SysAttachment sysAttachment);

    /**
     * 批量删除附件
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAttachmentByIds(String ids);

    /**
     * 删除附件信息
     *
     * @param attachmentId 附件ID
     * @return 结果
     */
    public int deleteSysAttachmentById(Integer attachmentId);

    /**
     * 通过fileCode查询附件信息
     * @param uuid
     * @return
     */
    public List<SysAttachment> selectAttachmentByFileCode(String fileCode);
}