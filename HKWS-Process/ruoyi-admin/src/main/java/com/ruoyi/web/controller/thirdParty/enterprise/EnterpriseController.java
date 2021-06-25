package com.ruoyi.web.controller.thirdParty.enterprise;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.XlEnterpriseInfo;
import com.ruoyi.system.domain.platform.enterPrise.enterPriseParm;
import com.ruoyi.system.domain.platform.enterPrise.enterPriseResult;
import com.ruoyi.system.domain.platform.illagallyPark.Park;
import com.ruoyi.system.service.IXlEnterpriseInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FanKaibiao
 * @date 2021-05-25-9:22
 */
@Controller
@RequestMapping("/hkapi")
public class EnterpriseController {

    @Autowired
    private IXlEnterpriseInfoService iXlEnterpriseInfoService;

    @Value("${enterprise.ak}")
    private String ak;

    @Value("${enterprise.sk}")
    private String sk;

    @Value("${enterprise.listurl}")
    private String listUrl;

    @Value("${enterprise.detailurl}")
    private String detailUrl;
    public static void main(String[] args) {
        EnterpriseListReq enterpriseListReq = new EnterpriseListReq();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", "330184600948995");
        /*paramMap.put("pageIndex", enterpriseListReq.getPageIndex());
        paramMap.put("pageSize", enterpriseListReq.getPageSize());*/
        /*if (StringUtils.isNotBlank(enterpriseListReq.getType())) {
            paramMap.put("type", enterpriseListReq.getType());
        }*/
        if (StringUtils.isNotBlank(enterpriseListReq.getDtype())) {
            paramMap.put("dtype", enterpriseListReq.getDtype());
        }
        String jsonStr = JSONUtil.toJsonStr(paramMap);
//        String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1214", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
        String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1215", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
        Park enterPriseRes = JSONObject.parseObject(request,Park.class);
        String data=enterPriseRes.getData();
        enterPriseParm parseObject = JSONObject.parseObject(data,enterPriseParm.class);
        System.out.println(data);
    }

    @RequestMapping("/enterprises")
    @ResponseBody
    public AjaxResult List(){
        List<XlEnterpriseInfo> xlEnterpriseInfos= iXlEnterpriseInfoService.selectenterpriseType();
        for(int i=0;i<xlEnterpriseInfos.size();i++){
            String unifiedCreditCode = xlEnterpriseInfos.get(i).getUnifiedCreditCode();
            String registrationNumber = xlEnterpriseInfos.get(i).getRegistrationNumber();
            String enterpriseName = xlEnterpriseInfos.get(i).getEnterpriseName();
            Long id = xlEnterpriseInfos.get(i).getId();
            if(StringUtils.isNotEmpty(unifiedCreditCode)){
//                System.out.println(xlEnterpriseInfos);
                EnterpriseListReq enterpriseListReq = new EnterpriseListReq();
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("keyword", unifiedCreditCode);
                if (StringUtils.isNotBlank(enterpriseListReq.getDtype())) {
                    paramMap.put("dtype", enterpriseListReq.getDtype());
                }
                String jsonStr = JSONUtil.toJsonStr(paramMap);
//              String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1214", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
                String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1215", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
                Park enterPriseRes = JSONObject.parseObject(request,Park.class);
                String data=enterPriseRes.getData();
                enterPriseParm parseObject = JSONObject.parseObject(data,enterPriseParm.class);
                if(parseObject.getResult()==null){
                    EnterpriseListReq enterpriseListReq1 = new EnterpriseListReq();
                    Map<String, Object> paramMap1 = new HashMap<>();
                    paramMap1.put("keyword", enterpriseName);
                    if (StringUtils.isNotBlank(enterpriseListReq1.getDtype())) {
                        paramMap1.put("dtype", enterpriseListReq1.getDtype());
                    }
                    String jsonStr1 = JSONUtil.toJsonStr(paramMap1);
//              String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1214", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
                    String request1 = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1215", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr1);
                    Park enterPriseRes1 = JSONObject.parseObject(request1,Park.class);
                    String data1=enterPriseRes1.getData();
                    enterPriseParm parseObject1 = JSONObject.parseObject(data1,enterPriseParm.class);
                    if(parseObject1.getResult()!=null){
                        XlEnterpriseInfo xlEnterpriseInfo = new XlEnterpriseInfo();
                        //公司名称
                        xlEnterpriseInfo.setEnterpriseName(parseObject1.getResult().getName());
                        //地址
                        xlEnterpriseInfo.setEnterpriseAdress(parseObject1.getResult().getAddress());
                        //经营状态
                        //状态名称
                        xlEnterpriseInfo.setEnterpriseStatusName(parseObject1.getResult().getStatus());
                        //企业类型
                        xlEnterpriseInfo.setEnterpriseType(parseObject1.getResult().getEconKind());
                        //成立日期
                        xlEnterpriseInfo.setEstablishDate(parseObject1.getResult().getStartDate());
                        //法人代表
                        xlEnterpriseInfo.setEstablishPerson(parseObject1.getResult().getOperName());
                        //公司更新时间
                        xlEnterpriseInfo.setEnterpriseUpdateDate(parseObject1.getResult().getUpdatedDate());
                        //注册资本
                        xlEnterpriseInfo.setRegisteredCapital(parseObject1.getResult().getRegistCapi());
                        //登记机关
                        xlEnterpriseInfo.setRegistrationAuthority(parseObject1.getResult().getBelongOrg());
                        //注册号
                        xlEnterpriseInfo.setRegistrationNumber(parseObject1.getResult().getNo());
                        //组织结构
                        xlEnterpriseInfo.setOrganization(parseObject1.getResult().getOrgNo());
                        //经营范围
                        xlEnterpriseInfo.setNatureBusiness(parseObject1.getResult().getScope());
                        //营业开始日期
                        xlEnterpriseInfo.setTermstart(parseObject1.getResult().getTermStart());
                        //营业结束日期
                        xlEnterpriseInfo.setTeamend(parseObject1.getResult().getTeamEnd());
                        //发招日期
                        xlEnterpriseInfo.setCheckdata(parseObject1.getResult().getCheckDate());
                        //企业logo
                        xlEnterpriseInfo.setEnterpriseLogo(parseObject1.getResult().getImageUrl());
                        //是否上市
                        xlEnterpriseInfo.setIsOnStock(Integer.parseInt(parseObject1.getResult().getIsOnStock()));
                        xlEnterpriseInfo.setUnifiedCreditCode(parseObject1.getResult().getCreditCode());
                        xlEnterpriseInfo.setId(id);
                        iXlEnterpriseInfoService.updateenterprisesCode(xlEnterpriseInfo);
                    }
                }else{
                    XlEnterpriseInfo xlEnterpriseInfo = new XlEnterpriseInfo();
                    //公司名称
                    xlEnterpriseInfo.setEnterpriseName(parseObject.getResult().getName());
                    //地址
                    xlEnterpriseInfo.setEnterpriseAdress(parseObject.getResult().getAddress());
                    //经营状态
                    //状态名称
                    xlEnterpriseInfo.setEnterpriseStatusName(parseObject.getResult().getStatus());
                    //企业类型
                    xlEnterpriseInfo.setEnterpriseType(parseObject.getResult().getEconKind());
                    //成立日期
                    xlEnterpriseInfo.setEstablishDate(parseObject.getResult().getStartDate());
                    //法人代表
                    xlEnterpriseInfo.setEstablishPerson(parseObject.getResult().getOperName());
                    //公司更新时间
                    xlEnterpriseInfo.setEnterpriseUpdateDate(parseObject.getResult().getUpdatedDate());
                    //注册资本
                    xlEnterpriseInfo.setRegisteredCapital(parseObject.getResult().getRegistCapi());
                    //登记机关
                    xlEnterpriseInfo.setRegistrationAuthority(parseObject.getResult().getBelongOrg());
                    //注册号
                    xlEnterpriseInfo.setRegistrationNumber(parseObject.getResult().getNo());
                    //组织结构
                    xlEnterpriseInfo.setOrganization(parseObject.getResult().getOrgNo());
                    //经营范围
                    xlEnterpriseInfo.setNatureBusiness(parseObject.getResult().getScope());
                    //营业开始日期
                    xlEnterpriseInfo.setTermstart(parseObject.getResult().getTermStart());
                    //营业结束日期
                    xlEnterpriseInfo.setTeamend(parseObject.getResult().getTeamEnd());
                    //发招日期
                    xlEnterpriseInfo.setCheckdata(parseObject.getResult().getCheckDate());
                    //企业logo
                    xlEnterpriseInfo.setEnterpriseLogo(parseObject.getResult().getImageUrl());
                    //是否上市
                    xlEnterpriseInfo.setIsOnStock(Integer.parseInt(parseObject.getResult().getIsOnStock()));
                    xlEnterpriseInfo.setUnifiedCreditCode(unifiedCreditCode);
                    iXlEnterpriseInfoService.updateenterprises(xlEnterpriseInfo);
                }

            }else if(StringUtils.isNotEmpty(registrationNumber)){
                System.out.println(xlEnterpriseInfos);
                EnterpriseListReq enterpriseListReq = new EnterpriseListReq();
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("keyword", registrationNumber);
                if (StringUtils.isNotBlank(enterpriseListReq.getDtype())) {
                    paramMap.put("dtype", enterpriseListReq.getDtype());
                }
                String jsonStr = JSONUtil.toJsonStr(paramMap);
//        String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1214", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
                String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1215", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
                Park enterPriseRes = JSONObject.parseObject(request,Park.class);
                String data=enterPriseRes.getData();
                enterPriseParm parseObject = JSONObject.parseObject(data,enterPriseParm.class);
                if(parseObject.getResult()!=null){
                    XlEnterpriseInfo xlEnterpriseInfo = new XlEnterpriseInfo();
                    //公司名称
                    xlEnterpriseInfo.setEnterpriseName(parseObject.getResult().getName());
                    //地址
                    xlEnterpriseInfo.setEnterpriseAdress(parseObject.getResult().getAddress());
                    //经营状态
                    //状态名称
                    xlEnterpriseInfo.setEnterpriseStatusName(parseObject.getResult().getStatus());
                    //企业类型
                    xlEnterpriseInfo.setEnterpriseType(parseObject.getResult().getEconKind());
                    //成立日期
                    xlEnterpriseInfo.setEstablishDate(parseObject.getResult().getStartDate());
                    //法人代表
                    xlEnterpriseInfo.setEstablishPerson(parseObject.getResult().getOperName());
                    //公司更新时间
                    xlEnterpriseInfo.setEnterpriseUpdateDate(parseObject.getResult().getUpdatedDate());
                    //注册资本
                    xlEnterpriseInfo.setRegisteredCapital(parseObject.getResult().getRegistCapi());
                    //登记机关
                    xlEnterpriseInfo.setRegistrationAuthority(parseObject.getResult().getBelongOrg());
                    //统一信用社代码
                    xlEnterpriseInfo.setUnifiedCreditCode(parseObject.getResult().getCreditCode());
                    //组织结构
                    xlEnterpriseInfo.setOrganization(parseObject.getResult().getOrgNo());
                    //经营范围
                    xlEnterpriseInfo.setNatureBusiness(parseObject.getResult().getScope());
                    //营业开始日期
                    xlEnterpriseInfo.setTermstart(parseObject.getResult().getTermStart());
                    //营业结束日期
                    xlEnterpriseInfo.setTeamend(parseObject.getResult().getTeamEnd());
                    //发招日期
                    xlEnterpriseInfo.setCheckdata(parseObject.getResult().getCheckDate());
                    //企业logo
                    xlEnterpriseInfo.setEnterpriseLogo(parseObject.getResult().getImageUrl());
                    //是否上市
                    xlEnterpriseInfo.setIsOnStock(Integer.parseInt(parseObject.getResult().getIsOnStock()));
                    xlEnterpriseInfo.setRegistrationNumber(registrationNumber);
                    iXlEnterpriseInfoService.updateenterprisesNumber(xlEnterpriseInfo);
                }
//                iXlEnterpriseInfoService.updatelist(registrationNumber);
            }else if(StringUtils.isNotEmpty(enterpriseName)){
                EnterpriseListReq enterpriseListReq1 = new EnterpriseListReq();
                Map<String, Object> paramMap1 = new HashMap<>();
                paramMap1.put("keyword", enterpriseName);
                if (StringUtils.isNotBlank(enterpriseListReq1.getDtype())) {
                    paramMap1.put("dtype", enterpriseListReq1.getDtype());
                }
                String jsonStr1 = JSONUtil.toJsonStr(paramMap1);
//              String request = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1214", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr);
                String request1 = RequestGateway.request("http://10.32.188.81:81/gateway/prod/1066/1215", "15a1ba7b44ae4d7bab68dd698884c71a", "a7baf46335514637b5b3b1a5c5a87c46", jsonStr1);
                Park enterPriseRes1 = JSONObject.parseObject(request1,Park.class);
                String data1=enterPriseRes1.getData();
                enterPriseParm parseObject1 = JSONObject.parseObject(data1,enterPriseParm.class);
                if(parseObject1.getResult()!=null){
                    XlEnterpriseInfo xlEnterpriseInfo = new XlEnterpriseInfo();
                    //公司名称
                    xlEnterpriseInfo.setEnterpriseName(parseObject1.getResult().getName());
                    //地址
                    xlEnterpriseInfo.setEnterpriseAdress(parseObject1.getResult().getAddress());
                    //经营状态
                    //状态名称
                    xlEnterpriseInfo.setEnterpriseStatusName(parseObject1.getResult().getStatus());
                    //企业类型
                    xlEnterpriseInfo.setEnterpriseType(parseObject1.getResult().getEconKind());
                    //成立日期
                    xlEnterpriseInfo.setEstablishDate(parseObject1.getResult().getStartDate());
                    //法人代表
                    xlEnterpriseInfo.setEstablishPerson(parseObject1.getResult().getOperName());
                    //公司更新时间
                    xlEnterpriseInfo.setEnterpriseUpdateDate(parseObject1.getResult().getUpdatedDate());
                    //注册资本
                    xlEnterpriseInfo.setRegisteredCapital(parseObject1.getResult().getRegistCapi());
                    //登记机关
                    xlEnterpriseInfo.setRegistrationAuthority(parseObject1.getResult().getBelongOrg());
                    //注册号
                    xlEnterpriseInfo.setRegistrationNumber(parseObject1.getResult().getNo());
                    //组织结构
                    xlEnterpriseInfo.setOrganization(parseObject1.getResult().getOrgNo());
                    //经营范围
                    xlEnterpriseInfo.setNatureBusiness(parseObject1.getResult().getScope());
                    //营业开始日期
                    xlEnterpriseInfo.setTermstart(parseObject1.getResult().getTermStart());
                    //营业结束日期
                    xlEnterpriseInfo.setTeamend(parseObject1.getResult().getTeamEnd());
                    //发招日期
                    xlEnterpriseInfo.setCheckdata(parseObject1.getResult().getCheckDate());
                    //企业logo
                    xlEnterpriseInfo.setEnterpriseLogo(parseObject1.getResult().getImageUrl());
                    //是否上市
                    xlEnterpriseInfo.setIsOnStock(Integer.parseInt(parseObject1.getResult().getIsOnStock()));
                    xlEnterpriseInfo.setUnifiedCreditCode(parseObject1.getResult().getCreditCode());
                    xlEnterpriseInfo.setId(id);
                    iXlEnterpriseInfoService.updateenterprisesCode(xlEnterpriseInfo);
            }
        }
//        return AjaxResult.success("成功");
    }
        return AjaxResult.success("成功");
}
}
