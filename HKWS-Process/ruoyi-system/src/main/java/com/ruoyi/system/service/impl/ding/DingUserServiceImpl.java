package com.ruoyi.system.service.impl.ding;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.ding.DingUser;
import com.ruoyi.system.mapper.ding.DingUserMapper;
import com.ruoyi.system.service.ding.DingUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl.ding
 * @ClassName: DingUserServiceImpl
 * @Author: guohailong
 * @Description: 浙政钉用户服务实现
 * @Date: 2021/3/10 10:25
 * @Version: 1.0
 */
@Service
public class DingUserServiceImpl implements DingUserService {

    @Resource
    private DingUserMapper dingUserMapper;


    @Override
    public DingUser findByName(String loginName) {
        return dingUserMapper.findByName(loginName);
    }

    @Override
    public DingUser auth(String loginName, String password) {
        SysUser authUser = dingUserMapper.auth(loginName, password);
        if (authUser != null) {
            DingUser dingUser = new DingUser();
            BeanUtils.copyProperties(authUser, dingUser);
            return dingUser;
        }
        return null;
    }

    @Override
    public DingUser findById(Long userId) {
        SysUser sysUser = dingUserMapper.findById(userId);
        DingUser dingUser = new DingUser();
        BeanUtils.copyProperties(sysUser, dingUser);
        return dingUser;
    }
}
