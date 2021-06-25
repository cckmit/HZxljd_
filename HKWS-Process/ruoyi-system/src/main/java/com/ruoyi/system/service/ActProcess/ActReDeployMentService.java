package com.ruoyi.system.service.ActProcess;

import com.ruoyi.system.domain.ActProcess.ActReDeployment;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-11-15-4:22
 */
public interface ActReDeployMentService {

    /**
     * 查询部署表中是否有类型
     * @param eventTypeName
     * @return
     */
    List<ActReDeployment> findActDeployMent(String eventTypeName);

    /**
     * 查询工作流唯一标识符
     * @param id
     * @return
     */
    String findKey(String id);
}
