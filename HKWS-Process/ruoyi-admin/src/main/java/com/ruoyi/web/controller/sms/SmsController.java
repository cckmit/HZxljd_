package com.ruoyi.web.controller.sms;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.sms.ReceiveMsgDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/sms")
@Controller
public class SmsController {

    /**
     * 接受状态报告
     * @param dto
     * @return
     */
    @PostMapping("/receiveStatusMsg")
    @ResponseBody
    public AjaxResult sso(@RequestBody ReceiveMsgDto dto){
        Map<String,Object> result = new HashMap<>();
        String reportStatus = dto.getReportStatus();
        String mobile = dto.getMobile();
        String errorCode = dto.getErrorCode();
        String submitDate = dto.getSubmitDate();
        String receiveDate = dto.getReceiveDate();
        String msgGroup = dto.getMsgGroup();
        result.put("phone",mobile);
        result.put("msgGroup",msgGroup);
        if("DELIVRD".equals(reportStatus)){
            result.put("success",true);
        }else{
            result.put("success",false);
        }
        return AjaxResult.success(result);
    }
}
