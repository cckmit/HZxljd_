package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Action.HkActionProcess;

import java.util.List;
import java.util.Map;

public interface HkActionProcessMapper {

    /**
     * 批量新增
     * @param processList
     * @return
     */
    int insertBatchHkActionProcess(List<HkActionProcess> processList);

    int updateAppHkActionProcess(List<Map> list);

}
