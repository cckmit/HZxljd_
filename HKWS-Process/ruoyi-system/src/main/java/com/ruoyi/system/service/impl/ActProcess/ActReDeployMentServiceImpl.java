package com.ruoyi.system.service.impl.ActProcess;

import com.ruoyi.system.domain.ActProcess.ActReDeployment;
import com.ruoyi.system.mapper.ActReDeployMentMapper;
import com.ruoyi.system.service.ActProcess.ActReDeployMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FanKaibiao
 * @date 2020-11-15-4:24
 */
@Service
public class ActReDeployMentServiceImpl implements ActReDeployMentService {

    @Autowired
    private ActReDeployMentMapper actReDeployMentMapper;

    @Override
    public List<ActReDeployment> findActDeployMent(String eventTypeName) {
        return actReDeployMentMapper.findActDeployMent(eventTypeName);
    }

    @Override
    public String findKey(String id) {
        return actReDeployMentMapper.findKey(id);
    }
}
