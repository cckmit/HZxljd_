package com.ruoyi.system.service.impl.HKfield;

import com.ruoyi.system.domain.HKfield.hkfield;
import com.ruoyi.system.domain.app.appActionNow;
import com.ruoyi.system.mapper.HkAFieldMapper;
import com.ruoyi.system.service.HKfield.HKfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-11-11 21:29
 **/
@Service
public class HkfieldServiceImpl implements HKfieldService {

    @Autowired
    private HkAFieldMapper hkAFieldMapper;

    @Override
    public int addHkAfieldMapper(hkfield hk) {
        return hkAFieldMapper.addHkAfield(hk);
    }

    /**
     * 根据行动id查询下的字段
     * @param commid
     * @return
     */
    @Override
    public List<hkfield> findHKAfield(String commid) {
        return hkAFieldMapper.findHKAfield(commid);
    }

    /**
     * 查询单个字段数据
     * @param commonlyId
     * @param id
     * @return
     */
    @Override
    public hkfield selectHKAfieldBy(String commonlyId, Integer id) {
        return hkAFieldMapper.selectHKAfieldBy(commonlyId,id);
    }

    /**
     * 删除字段数据
     * @param id
     * @return
     */
    @Override
    public int deleteHKfield(Integer id) {
        return hkAFieldMapper.deleteHKfield(id);
    }

    /**
     * 修改字段数据
     * @param hk
     * @return
     */
    @Override
    public int updateField(hkfield hk) {
        return hkAFieldMapper.updateField(hk);
    }

    /**
     * 校验字段名是否唯一
     * @param hk
     * @return
     */
    @Override
    public int checkField(hkfield hk) {
        return hkAFieldMapper.checkField(hk);
    }

    @Override
    public appActionNow queryFieldByAction(Map<String,Object> param) {
        return hkAFieldMapper.queryFieldByAction(param);
    }
}
