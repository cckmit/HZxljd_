package com.ruoyi.system.service.ding;

import com.ruoyi.system.domain.ding.DingUser;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.ding
 * @ClassName: DingUserService
 * @Author: guohailong
 * @Description: 浙政钉用户服务接口
 * @Date: 2021/3/10 10:24
 * @Version: 1.0
 */
public interface DingUserService {

    DingUser findByName(String loginName);

    DingUser auth(String loginName, String password);

    DingUser findById(Long userId);

}
