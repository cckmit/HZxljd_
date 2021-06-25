package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.HKfield.hkfield;
import com.ruoyi.system.domain.app.appActionNow;

import java.util.List;
import java.util.Map;

/**
 * @program: data-ruoyi
 * @description: 字段类型表
 * @author: Yang-Teng-Fei
 * @create: 2020-11-11 17:39
 **/
public interface HkAFieldMapper {

    /**
     * 添加字段类型
     * @param hk
     * @return
     */
    public int addHkAfield(hkfield hk);

    /**
     * 根据行动id查询下的字段
     * @param commid
     * @return
     */
    public List<hkfield> findHKAfield(String commid);

    /**
     * 查询单个字段数据
     * @param commonlyId
     * @param id
     * @return
     */

    public hkfield selectHKAfieldBy(String commonlyId, Integer id);

    /**
     * 删除字段数据
     * @param id
     * @return
     */
    public  int deleteHKfield(Integer id);

    /**
     *  修改字段数据
     * @param hk
     * @return
     */
    public  int updateField(hkfield hk);

    /**
     * 校验字段数据是否唯一
     * @param hk
     * @return
     */
    public int checkField(hkfield hk);

    appActionNow queryFieldByAction(Map<String,Object> param);
}
