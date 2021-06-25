package com.ruoyi.system.service.impl.ding;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.HkDingUser;
import com.ruoyi.system.mapper.ding.HkDingUserMapper;
import com.ruoyi.system.service.ding.IHkDingUserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl.ding
 * @ClassName: HkDingUserServiceImpl
 * @Author: guohailong
 * @Description: 浙政钉-系统用户绑定关系
 * @Date: 2021/3/22 15:10
 * @Version: 1.0
 */
@Service
public class HkDingUserServiceImpl implements IHkDingUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HkDingUserServiceImpl.class);

    @Autowired
    private HkDingUserMapper hkDingUserMapper;


    /**
     * 查询浙政钉-系统用户关系
     *
     * @param id 浙政钉-系统用户关系ID
     * @return 浙政钉-系统用户关系
     */
    @Override
    public HkDingUser selectHkDingUserById(Long id) {
        return hkDingUserMapper.selectHkDingUserById(id);
    }

    /**
     * 查询浙政钉-系统用户关系列表
     *
     * @param hkDingUser 浙政钉-系统用户关系
     * @return 浙政钉-系统用户关系
     */
    @Override
    public List<HkDingUser> selectHkDingUserList(HkDingUser hkDingUser) {
        return hkDingUserMapper.selectHkDingUserList(hkDingUser);
    }

    /**
     * 新增浙政钉-系统用户关系
     *
     * @param hkDingUser 浙政钉-系统用户关系
     * @return 结果
     */
    @Override
    public int insertHkDingUser(HkDingUser hkDingUser) {
        hkDingUser.setCreateTime(DateUtils.getNowDate());
        return hkDingUserMapper.insertHkDingUser(hkDingUser);
    }

    /**
     * 修改浙政钉-系统用户关系
     *
     * @param hkDingUser 浙政钉-系统用户关系
     * @return 结果
     */
    @Override
    public int updateHkDingUser(HkDingUser hkDingUser) {
        hkDingUser.setUpdateTime(DateUtils.getNowDate());
        return hkDingUserMapper.updateHkDingUser(hkDingUser);
    }

    /**
     * 删除浙政钉-系统用户关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHkDingUserByIds(String ids) {
        return hkDingUserMapper.deleteHkDingUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除浙政钉-系统用户关系信息
     *
     * @param id 浙政钉-系统用户关系ID
     * @return 结果
     */
    @Override
    public int deleteHkDingUserById(Long id) {
        return hkDingUserMapper.deleteHkDingUserById(id);
    }

    @Override
    public HkDingUser selectHkDingUserByDingUserId(String dingUserId) {
        return hkDingUserMapper.selectHkDingUserByDingUserId(dingUserId);
    }

    @Transactional
    @Override
    public int deleteHkDingUserBySysUserIdAndDingUserId(Long userId, String accountId) {
        HkDingUser dingUser = new HkDingUser();
        dingUser.setSysUserId(userId);
        dingUser.setDingUserId(accountId);
        try {
            return hkDingUserMapper.deleteHkDingUserBySysUserIdAndDingUserId(dingUser);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public HkDingUser selectHkDingUserBySysUserId(Long userId) {
        return hkDingUserMapper.selectHkDingUserBySysUserId(userId);
    }


}
