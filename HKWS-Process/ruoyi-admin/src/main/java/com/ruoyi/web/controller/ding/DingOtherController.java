package com.ruoyi.web.controller.ding;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.ding.IHkDingUserService;
import com.ruoyi.web.annotation.IdentityVerify;
import com.ruoyi.web.annotation.IdentityVerifys;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingOtherController
 * @Author: guohailong
 * @Description: 浙政钉-其他接口
 * @Date: 2021/4/18 23:02
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingOtherController {

    @Resource
    private IHkDingUserService hkDingUserService;

    /**
     * 退出
     * @param userId
     * @param accountId
     * @return
     */
    @IdentityVerify
    @DeleteMapping("/other/logout/{userId}/{accountId}")
    public AjaxResult logout(@PathVariable @IdentityVerifys Long userId, @PathVariable String accountId) {
        int count = hkDingUserService.deleteHkDingUserBySysUserIdAndDingUserId(userId, accountId);
        return count > 0 ? AjaxResult.success() : AjaxResult.error();
    }

}
