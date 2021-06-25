package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.app.appRole;
import com.ruoyi.system.domain.app.appSysUser;
import com.ruoyi.system.domain.app.hkAdminEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: data-ruoyi
 * @description:app-登录
 * @author: Yang-Teng-Fei
 * @create: 2020-12-08 12:20
 **/
public interface appLoginMapper {

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    public appSysUser checkLogin(@Param("userName") String userName, @Param("password")String password );

    /**
     * 判断用户是否为管理员
     * @param userId
     * @return
     */
    public appRole checkRole(@Param("userId") Long userId);


    /**
     * 查询管理员下的用户
     * @param userId
     * @return
     */
    public List<hkAdminEvent> allUserName(@Param("userId") Long userId);


    appSysUser selectUserByOpenId(String openId);

}
