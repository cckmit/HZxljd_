package com.ruoyi.web.controller.ding;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.ding.DingUser;
import com.ruoyi.system.service.ding.DingMyWorkService;
import com.ruoyi.system.service.ding.DingUserService;
import com.ruoyi.web.annotation.IdentityVerify;
import com.ruoyi.web.annotation.IdentityVerifys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.ding
 * @ClassName: DingMyWorkController
 * @Author: guohailong
 * @Description: 浙政钉-我的工作接口
 * @Date: 2021/3/10 13:52
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ding")
public class DingMyWorkController {

    @Resource
    private DingMyWorkService dingMyWorkService;
    @Resource
    private DingUserService dingUserService;

    private static final Logger logger = LoggerFactory.getLogger(DingMyWorkController.class);

    /**
     * 我的工作详情
     * 获取待处理,已逾期,已完成事件数量
     *
     * @param userId
     * @return
     */
    @GetMapping("/work/detail/{userId}")
    @IdentityVerify
    public AjaxResult getMyWorkData(@PathVariable @IdentityVerifys Long userId,
                                    @RequestParam(name = "eventTitle", required = false, defaultValue = "") String eventTitle,
                                    @RequestParam(name = "sourceId", required = false, defaultValue = "") String sourceId) {
        DingUser dingUser = dingUserService.findById(userId);
        //判断当前是否有管理员权限
        List<SysRole> roles = dingUser.getRoles();
        if (StringUtils.isEmpty(roles)) {
            return AjaxResult.warn("当前用户无权限组");
        }
        Long[] roleIds = new Long[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            roleIds[i] = roles.get(i).getRoleId();
        }
        dingUser.setRoleIds(roleIds);
        if (null == dingUser.getUserId() || StringUtils.isEmpty(dingUser.getRoleIds())) {
            return AjaxResult.warn("必要参数缺失");
        }
        Map<String, Object> searchMap = new HashMap<>();
        //如果当前用户包含1角色,即为管理员
        if (Arrays.asList(dingUser.getRoleIds()).contains(1L)) {
            searchMap.put("userName", dingUser.getUserName());
            searchMap.put("userId", dingUser.getUserId());
            int toDoCount = dingMyWorkService.adminToDoCount(searchMap);
            searchMap.put("pendCount", toDoCount);
            //统计已逾期事件的总数
            int overdueCount = dingMyWorkService.adminOverdueCount(searchMap);
            searchMap.put("overCount", overdueCount);
            //统计已完成事件的总数
            int completedCount = dingMyWorkService.adminCompletedCount(searchMap);
            searchMap.put("completedCount", completedCount);
        } else {
            searchMap.put("userName", dingUser.getUserName());
            searchMap.put("userId", dingUser.getUserId());
            searchMap.put("eventTitle", eventTitle);
            searchMap.put("componentId", sourceId);
            int toDoCount = dingMyWorkService.toDoCount(searchMap);
            searchMap.put("toDoCount", toDoCount);
            //统计已逾期事件的总数
            int overdueCount = dingMyWorkService.overdueCount(searchMap);
            searchMap.put("overCount", overdueCount);
            //统计已完成事件的总数
            int completedCount = dingMyWorkService.completedCount(searchMap);
            searchMap.put("completedCount", completedCount);
        }
        return AjaxResult.success(searchMap);
    }


}
