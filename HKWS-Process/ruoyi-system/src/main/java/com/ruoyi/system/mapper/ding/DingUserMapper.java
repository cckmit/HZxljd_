package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.ding.DingUser;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingUserMapper
 * @Author: guohailong
 * @Description:
 * @Date: 2021/3/10 10:29
 * @Version: 1.0
 */
public interface DingUserMapper {

    /**
     * 根据用户名判断用户是否存在
     *
     * @param loginName
     * @return
     */
    DingUser findByName(String loginName);

    /**
     * 登入
     *
     * @param loginName
     * @param password
     * @return
     */
    SysUser auth(@Param("loginName") String loginName, @Param("password") String password);

    /**
     * id查询
     * @param userId
     * @return
     */
    SysUser findById(@Param("userId") Long userId);
}
