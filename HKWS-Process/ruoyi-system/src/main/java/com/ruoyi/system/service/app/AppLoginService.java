package com.ruoyi.system.service.app;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.appRole;
import com.ruoyi.system.domain.app.appSysUser;
import com.ruoyi.system.domain.app.hkAdminEvent;

import java.util.*;

/**
 * @program: data-ruoyi
 * @description: app-登录
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 12:18
 **/
public interface AppLoginService {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public appSysUser checkLogin(String userName, String password );

    /**
     * 判断用户是否为管理员
     * @param userId
     * @return
     */
     public appRole checkRole(Long userId);

    /**
     * 查询管理员下的用户
     * @param userId
     * @return
     */
     public List<hkAdminEvent> allUserName(Long userId);


     public appSysUser selectUserByOpenId(String openId);
}
