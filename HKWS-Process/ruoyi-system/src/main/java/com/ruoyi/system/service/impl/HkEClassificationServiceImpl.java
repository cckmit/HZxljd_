package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.system.domain.HkEClassification;
import com.ruoyi.system.mapper.HkEClassificationMapper;
import com.ruoyi.system.service.HkEClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HkEClassificationServiceImpl implements HkEClassificationService {
    @Autowired(required = false)
    private HkEClassificationMapper eClassificationMapper;
    @Override
    public Integer create(HkEClassification eClassification) {

        return eClassificationMapper.insert(eClassification);
    }

    @Override
    public List<HkEClassification> selectByEClass( String ec_name, String ec_type, String ec_ids,String ec_category) throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("ec_name",ec_name);
        map.put("ec_ids",ec_ids);
        map.put("ec_type",ec_type);
        map.put("ec_category",ec_category);
        List<HkEClassification> list=eClassificationMapper.selectByEClass(map);
        return list;
    }


    @Override
    public HkEClassification findById(Integer id) {
        return eClassificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(HkEClassification eClassification) {
        eClassificationMapper.updateByPrimaryKeySelective(eClassification);
    }

    @Override
    public void deleteById(Integer id) {
        eClassificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int checkRoleAllowed(HkEClassification hkEClassification) {
          try {
              eClassificationMapper.changeStatus(hkEClassification);
              return 1;
          }catch (Exception e){
              return 0;
          }

    }

    @Override
    public String checkRoleNameUnique(HkEClassification hkEClassification) {
        Integer itt=eClassificationMapper.checkRoleNameUnique(hkEClassification.getEc_ids());
        if (itt==0){
            return "名称可以使用";
        }else {
            return "名称已存在";
        }
    }

    @Override
    public HkEClassification selectRoleById(String ec_id) {

        return eClassificationMapper.selectRoleById(ec_id);
    }

    @Override
    public int updateRole(HkEClassification hkEClassification) {
        return eClassificationMapper.updateRole(hkEClassification);
    }

    @Override
    public int deleteRoleByIds(String ids) {
        return eClassificationMapper.deleteRoleByIds(ids);
    }

    @Override
    public List<HkEClassification> finby() {
        return eClassificationMapper.finby();
    }

    @Override
    public int deleteConfigByIds(String ids) {
        int count = eClassificationMapper.deleteConfigByIds(Convert.toStrArray(ids));
        if (count > 0)
        {

            CacheUtils.removeAll(getCacheName());
        }
        return count;
    }

    @Override
    public List<HkEClassification> eventType() {
        return eClassificationMapper.eventType();
    }

    @Override
    public HkEClassification findHkEClassification(String actionType) {
        return eClassificationMapper.findHkEClassification(actionType);
    }

    /**
     * 获取cache name
     *
     * @return 缓存名
     */
    private String getCacheName()
    {
        return Constants.SYS_CONFIG_CACHE;
    }

    @Override
    public List<HkEClassification> findEclass() {
        return eClassificationMapper.findEclass();
    }

    @Override
    public List<HkEClassification> queryEventEClassifications() {
        return eClassificationMapper.queryEventEClassifications();
    }

    /**
     * 根据事件类型码获取事件分类
     * @return
     */
    @Override
    public List<HkEClassification> selectHkEClassByEcCategory(String ecCategory) {
        return eClassificationMapper.selectHkEClassByEcCategory(ecCategory);
    }
}
