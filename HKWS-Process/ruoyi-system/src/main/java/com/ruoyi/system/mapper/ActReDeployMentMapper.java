package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ActProcess.ActReDeployment;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-11-15-4:25
 */
public interface ActReDeployMentMapper {
    /**
     * 查询部署表中是否有这个类型的数据
     * @param eventTypeName
     * @return
     */
    List<ActReDeployment> findActDeployMent(String eventTypeName);

    /**
     * 查询工作流额唯一标识符
     * @param id
     * @return
     */
    String findKey(String id);
}
