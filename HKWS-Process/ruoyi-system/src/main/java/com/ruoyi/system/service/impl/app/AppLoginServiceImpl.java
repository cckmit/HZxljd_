package com.ruoyi.system.service.impl.app;

import com.ruoyi.system.domain.app.appRole;
import com.ruoyi.system.domain.app.appSysUser;
import com.ruoyi.system.domain.app.hkAdminEvent;
import com.ruoyi.system.mapper.appLoginMapper;
import com.ruoyi.system.service.app.AppLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: data-ruoyi
 * @description:
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 12:21
 **/
@Service
public class AppLoginServiceImpl implements AppLoginService {
    @Autowired(required = false)
    private appLoginMapper appLoginMapper;
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public appSysUser checkLogin(String userName, String password) {
        return appLoginMapper.checkLogin(userName,password);
    }

    /**
     * 判断用户是否为管理员
     * @param userId
     * @return
     */
     @Override
    public appRole checkRole(Long userId) {
        return appLoginMapper.checkRole(userId);
    }
    /**
     * 查询管理员下的用户
     * @param userId
     * @return
     */
    @Override
    public List<hkAdminEvent> allUserName(Long userId) {
        return appLoginMapper.allUserName(userId);
    }

    /**
     * 根据openId查询用户信息
     * @param openId
     * @return
     */
    @Override
    public appSysUser selectUserByOpenId(String openId) {
        return appLoginMapper.selectUserByOpenId(openId);
    }

}
