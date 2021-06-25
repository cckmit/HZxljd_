package com.ruoyi.web.controller.hkApi.dingding;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.request.OapiIndustryDepartmentGetRequest;
import com.dingtalk.api.request.OapiIndustryUserListRequest;
import com.dingtalk.api.request.OapiV2UserListRequest;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiIndustryDepartmentGetResponse;
import com.dingtalk.api.response.OapiIndustryUserListResponse;
import com.dingtalk.api.response.OapiV2UserListResponse;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysRegion;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.platform.dingUser.dingUserParm;
import com.ruoyi.system.domain.platform.illagallyPark.Park;
import com.ruoyi.system.domain.platform.organization.organizationParm;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysRegionService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.utils.MD5Util;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author FanKaibiao
 * @date 2021-05-21-10:49
 * 获取钉钉组织架构信息
 */
@Controller
@RequestMapping("/hkapi")
public class DingController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ISysDeptService iSysDeptService;
    @Autowired
    private ISysRegionService iSysRegionService;
    @Autowired
    private ISysUserService iSysUserService;

    /*public static void main(String[] args) {
        String appKey="dingjklrbydaevwecqxp";
        String appSecret="PovXa4wL9JsVeH2u8bwh40XP72G5MixfiZdIAHQeGoI14_UqEFXPA4q32382gVng";
        *//*String appKey="ding7kh9p9ns4r8j5n6j";
        String appSecret="gRSOPyDB4akbbV4zi124TZhMQPsZs3IC6m-O7YPeLhrnkA2AW_e6EJdkshmcycGv";*//*
        Map map = JSONObject.parseObject(JSONObject.toJSONString(new DingGetTokenDto(appKey,appSecret)), Map.class);
        int timeout=2*60-10;
        *//*String result = HttpUtil.get("https://oapi.dingtalk.com/gettoken", map, timeout);
        String token = JSONObject.parseObject(result).getString("access_token");
        System.out.println(token);*//*
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
            OapiDepartmentListRequest req = new OapiDepartmentListRequest();
            req.setLang("zh_CN");
            req.setFetchChild(true);//是否要查询部门下面的子级
            req.setId("1");           //查询社区477278005
            req.setHttpMethod("GET");
            OapiDepartmentListResponse rsp = client.execute(req, "07152d912c68384abdacf9b3cc7eeaa8");
            System.out.println(rsp.getBody());
            *//*organizationParm organization = JSONObject.parseObject(rsp.getBody(),organizationParm.class);
            SysDept sysDept = new SysDept();
            for (int i=0;i<organization.getDepartment().size();i++){
                //父级id
                sysDept.setParentId("100");
                //名称
                sysDept.setDeptName(organization.getDepartment().get(i).getName());
                //创建时间
                sysDept.setCreateTime(new Date());
                //uuid
                sysDept.setDeptUuid(UUID.randomUUID().toString().trim().replaceAll("-", "").trim().replaceAll("-", "").trim().replaceAll("-", ""));
                int depeId=iSysDeptService.insertSysDept(sysDept);
            }*//*

        } catch (ApiException e) {
            e.printStackTrace();
        }

    }*/
    //获取部门下的人员信息
    public static void main(String[] args) {
        String appKey="dingjklrbydaevwecqxp";
        String appSecret="PovXa4wL9JsVeH2u8bwh40XP72G5MixfiZdIAHQeGoI14_UqEFXPA4q32382gVng";
        /*String appKey="ding7kh9p9ns4r8j5n6j";
        String appSecret="gRSOPyDB4akbbV4zi124TZhMQPsZs3IC6m-O7YPeLhrnkA2AW_e6EJdkshmcycGv";*/
        Map map = JSONObject.parseObject(JSONObject.toJSONString(new DingGetTokenDto(appKey,appSecret)), Map.class);
        int timeout=2*60-10;
        /*String result = HttpUtil.get("https://oapi.dingtalk.com/gettoken", map, timeout);
        String token = JSONObject.parseObject(result).getString("access_token");
        System.out.println(token);*/

        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/list");
            OapiV2UserListRequest req = new OapiV2UserListRequest();
            req.setDeptId(483675202L);
            req.setCursor(1L);
            req.setSize(100L);
            OapiV2UserListResponse rsp = client.execute(req, "d78065b23d3a39c1aa0f7cb57460fcc2");
            System.out.println(rsp.getBody());
            dingUserParm dingUser = JSONObject.parseObject(rsp.getBody(),dingUserParm.class);
            SysUser sysUser = new SysUser();
           /* for(int i=0;i<dingUser.getResult().getList().size();i++){
                sysUser.setUserName(dingUser.getResult().getList().get(i).getName());
            }*/
        } catch (ApiException e) {
            System.out.println("错误");
        }
    }
    //全部部门
    @RequestMapping("/listDept")
    @ResponseBody
    public AjaxResult deptList(){
        String appKey="dingjklrbydaevwecqxp";
        String appSecret="PovXa4wL9JsVeH2u8bwh40XP72G5MixfiZdIAHQeGoI14_UqEFXPA4q32382gVng";
        /*String appKey="ding7kh9p9ns4r8j5n6j";
        String appSecret="gRSOPyDB4akbbV4zi124TZhMQPsZs3IC6m-O7YPeLhrnkA2AW_e6EJdkshmcycGv";*/
        Map map = JSONObject.parseObject(JSONObject.toJSONString(new DingGetTokenDto(appKey,appSecret)), Map.class);
        int timeout=2*60-10;
       /* String result = HttpUtil.get("https://oapi.dingtalk.com/gettoken", map, timeout);
        String token = JSONObject.parseObject(result).getString("access_token");
        System.out.println(token);*/
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
            OapiDepartmentListRequest req = new OapiDepartmentListRequest();
            req.setLang("zh_CN");
            req.setFetchChild(false);//是否要查询部门下面的子级
            req.setId("1");           //查询社区477278005
            req.setHttpMethod("GET");
            OapiDepartmentListResponse rsp = client.execute(req, "fba0c11387153721b4921d277f04123d");
//            System.out.println(rsp.getBody());
            organizationParm organization = JSONObject.parseObject(rsp.getBody(),organizationParm.class);
//            System.out.println(organization.getDepartment().get(0).getName());
            SysDept sysDept = new SysDept();
            for (int i=0;i<organization.getDepartment().size();i++){
                long id = organization.getDepartment().get(i).getId();
                String name1 = organization.getDepartment().get(i).getName();
                //父级id
                sysDept.setParentId("100");
                //名称
                sysDept.setDeptName(organization.getDepartment().get(i).getName());
                //创建时间
                sysDept.setCreateTime(new Date());
                //uuid
                sysDept.setDeptUuid(UUID.randomUUID().toString().trim().replaceAll("-", "").trim().replaceAll("-", "").trim().replaceAll("-", ""));
                sysDept.setDingId(Integer.parseInt(String.valueOf(organization.getDepartment().get(i).getId())));
//                Long depeId=iSysDeptService.insertSysDeptAll(sysDept);
//                System.out.println(depeId);
                DingTalkClient clientUser = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/list");
                OapiV2UserListRequest reqUser = new OapiV2UserListRequest();
                reqUser.setDeptId(id);
                reqUser.setCursor(1L);
                reqUser.setSize(100L);
                OapiV2UserListResponse rspUser = clientUser.execute(reqUser, "fba0c11387153721b4921d277f04123d");
                System.out.println(rspUser.getBody());
                dingUserParm dingUser = JSONObject.parseObject(rspUser.getBody(),dingUserParm.class);
                SysUser sysUser = new SysUser();
                if(dingUser.getResult()!=null){
                    for(int j=0;j<dingUser.getResult().getList().size();j++){
                        String name = dingUser.getResult().getList().get(j).getName();
//                        sysUser.setDeptId(depeId);
                        //手机号
                        String mobile = dingUser.getResult().getList().get(j).getMobile();
                        String md5 = MD5Util.getMD5(mobile + "123123");
                        sysUser.setUserName(dingUser.getResult().getList().get(j).getName());
                        sysUser.setPhonenumber(dingUser.getResult().getList().get(j).getMobile());
                        sysUser.setLoginName(dingUser.getResult().getList().get(j).getMobile());
                        sysUser.setPassword(md5);
                        sysUser.setCreateTime(new Date());
                        sysUser.setAvatar(dingUser.getResult().getList().get(j).getAvatar());
//                        int userCount =iSysUserService.findUserCount(sysUser);
                        System.out.println(name1+"部门下人员信息:-"+name);
                    }
                }
//              System.out.println(dingUser);
                //部门下子部门
                DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
                OapiDepartmentListRequest reqZi = new OapiDepartmentListRequest();
                reqZi.setLang("zh_CN");
                reqZi.setFetchChild(false);//是否要查询部门下面的子级
                reqZi.setId(String.valueOf(id));
                OapiDepartmentListResponse rspZi = client1.execute(reqZi, "fba0c11387153721b4921d277f04123d");
//                    System.out.println(rspZi.getBody());
                organizationParm organizationZi = JSONObject.parseObject(rspZi.getBody(),organizationParm.class);
                if(organizationZi.getDepartment()!=null){
                    SysDept sysDept1 = new SysDept();
                    for(int j=0;j<organizationZi.getDepartment().size();j++){
                        long id1 = organizationZi.getDepartment().get(j).getId();
                        String name2 = organizationZi.getDepartment().get(j).getName();
                        //父级id
//                        sysDept1.setParentId(String.valueOf(depeId));
                        //名称
                        sysDept1.setDeptName(organizationZi.getDepartment().get(j).getName());
                        //创建时间
                        sysDept1.setCreateTime(new Date());
                        //uuid
                        sysDept1.setDeptUuid(UUID.randomUUID().toString().trim().replaceAll("-", "").trim().replaceAll("-", "").trim().replaceAll("-", ""));
                        //钉钉编码
                        sysDept1.setDingId(Integer.parseInt(String.valueOf(organizationZi.getDepartment().get(j).getId())));
//                        Long aLong = iSysDeptService.insertSysDeptAll(sysDept1);
                        DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
                        OapiDepartmentListRequest reqZiZi = new OapiDepartmentListRequest();
                        reqZiZi.setLang("zh_CN");
                        reqZiZi.setFetchChild(false);//是否要查询部门下面的子级
                        reqZiZi.setId(String.valueOf(id1));//查询社区477278005
                        reqZiZi.setHttpMethod("GET");
                        OapiDepartmentListResponse rspZiZi = client2.execute(reqZiZi, "fba0c11387153721b4921d277f04123d");
//                      System.out.println(rspZi.getBody());
                        organizationParm organizationZiZi = JSONObject.parseObject(rspZiZi.getBody(),organizationParm.class);
                        if(organizationZiZi.getDepartment()!=null){
                            SysDept sysDept2 = new SysDept();
                            for(int k=0;k<organizationZiZi.getDepartment().size();k++){
                                long id2 = organizationZiZi.getDepartment().get(k).getId();
                                String name3 = organizationZiZi.getDepartment().get(k).getName();
                                //父级id
//                                sysDept2.setParentId(String.valueOf(aLong));
                                //名称
                                sysDept2.setDeptName(organizationZiZi.getDepartment().get(k).getName());
                                //创建时间
                                sysDept2.setCreateTime(new Date());
                                //uuid
                                sysDept2.setDeptUuid(UUID.randomUUID().toString().trim().replaceAll("-", "").trim().replaceAll("-", "").trim().replaceAll("-", ""));
                                //钉钉编码
                                sysDept2.setDingId(Integer.parseInt(String.valueOf(organizationZiZi.getDepartment().get(k).getId())));
//                                iSysDeptService.insertSysDeptAll(sysDept2);
                            }
                        }
                    }
                }
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
    //全部社区
    @RequestMapping("/listWangDept")
    public AjaxResult deptWangList(){
        String appKey="dingjklrbydaevwecqxp";
        String appSecret="PovXa4wL9JsVeH2u8bwh40XP72G5MixfiZdIAHQeGoI14_UqEFXPA4q32382gVng";
        /*String appKey="ding7kh9p9ns4r8j5n6j";
        String appSecret="gRSOPyDB4akbbV4zi124TZhMQPsZs3IC6m-O7YPeLhrnkA2AW_e6EJdkshmcycGv";*/
        Map map = JSONObject.parseObject(JSONObject.toJSONString(new DingGetTokenDto(appKey,appSecret)), Map.class);
        int timeout=2*60-10;
        String result = HttpUtil.get("https://oapi.dingtalk.com/gettoken", map, timeout);
        String token = JSONObject.parseObject(result).getString("access_token");
        System.out.println(token);
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
            OapiDepartmentListRequest req = new OapiDepartmentListRequest();
            req.setLang("zh_CN");
            req.setFetchChild(false);//是否要查询部门下面的子级
            req.setId("477278005");           //查询社区477278005
            req.setHttpMethod("GET");
            OapiDepartmentListResponse rsp = client.execute(req, token);
            System.out.println(rsp.getBody());
            organizationParm organization = JSONObject.parseObject(rsp.getBody(),organizationParm.class);
//            System.out.println(organization.getDepartment().get(0).getName());
            SysDept sysDept = new SysDept();
            SysRegion sysRegion = new SysRegion();
//            for (int i=0;i<organization.getDepartment().size();i++){
                //父级id
               /* sysRegion.setParentId("100");
                //名称
                sysRegion.setRegionName(organization.getDepartment().get(i).getName());
                //创建人
                sysRegion.setCreateBy("admin");
                //创建时间
                sysRegion.setCreateTime(new Date());
                int regionid = iSysRegionService.insertSysRegion(sysRegion);*/
                /*long id = organization.getDepartment().get(0).getId();
                try {
                    DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
                    OapiDepartmentListRequest req1 = new OapiDepartmentListRequest();
                    req1.setLang("zh_CN");
                    req1.setFetchChild(false);//是否要查询部门下面的子级
                    req1.setId(String.valueOf(id));           //查询社区477278005
                    req1.setHttpMethod("GET");
                    OapiDepartmentListResponse rsp1 = client1.execute(req1, "613e8d6ac54a3ca4ae82d98524d52661");
                    System.out.println(rsp1.getBody());
                    organizationParm organization1 = JSONObject.parseObject(rsp1.getBody(),organizationParm.class);
//                   System.out.println(organization.getDepartment().get(0).getName());
                    SysRegion sysRegion1 = new SysRegion();
                    for (int j=0;j<organization1.getDepartment().size();j++){
                        //父级id
                        sysRegion1.setParentId(String.valueOf(regionid));
                        //名称
                        sysRegion1.setRegionName(organization.getDepartment().get(j).getName());
                        //创建人
                        sysRegion1.setCreateBy("admin");
                        //创建时间
                        sysRegion1.setCreateTime(new Date());
                        iSysRegionService.insertSysRegion(sysRegion1);
                    }

                } catch (ApiException e) {
                    e.printStackTrace();
                }*/

//            }

        } catch (ApiException e) {
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
    //社区下网格信息
    @RequestMapping("/listWaDept")
    @ResponseBody
    public AjaxResult deptWangList222(){
        String appKey="dingjklrbydaevwecqxp";
        String appSecret="PovXa4wL9JsVeH2u8bwh40XP72G5MixfiZdIAHQeGoI14_UqEFXPA4q32382gVng";
        /*String appKey="ding7kh9p9ns4r8j5n6j";
        String appSecret="gRSOPyDB4akbbV4zi124TZhMQPsZs3IC6m-O7YPeLhrnkA2AW_e6EJdkshmcycGv";*/
        Map map = JSONObject.parseObject(JSONObject.toJSONString(new DingGetTokenDto(appKey,appSecret)), Map.class);
        int timeout=2*60-10;
        String result = HttpUtil.get("https://oapi.dingtalk.com/gettoken", map, timeout);
        String token = JSONObject.parseObject(result).getString("access_token");
        System.out.println(token);
        try {
            /*DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
            OapiDepartmentListRequest req = new OapiDepartmentListRequest();
            req.setLang("zh_CN");
            req.setFetchChild(false);//是否要查询部门下面的子级
            req.setId("477241072");//查询社区477278005
            req.setHttpMethod("GET");
            OapiDepartmentListResponse rsp = client.execute(req, "fba0c11387153721b4921d277f04123d");
            System.out.println(rsp.getBody());
            organizationParm organization = JSONObject.parseObject(rsp.getBody(),organizationParm.class);
//            System.out.println(organization.getDepartment().get(0).getName());
            SysDept sysDept = new SysDept();
            SysRegion sysRegion = new SysRegion();*/
            DingTalkClient clientUser = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/list");
            OapiV2UserListRequest reqUser = new OapiV2UserListRequest();
            reqUser.setDeptId(483675202L);
            reqUser.setCursor(1L);
            reqUser.setSize(100L);
            OapiV2UserListResponse rspUser = clientUser.execute(reqUser, token);
            System.out.println(rspUser.getBody());
            dingUserParm dingUser = JSONObject.parseObject(rspUser.getBody(),dingUserParm.class);
            SysUser sysUser = new SysUser();
            if(dingUser.getResult()!=null){
                for(int j=0;j<dingUser.getResult().getList().size();j++){
                    String name = dingUser.getResult().getList().get(j).getName();
//                        sysUser.setDeptId(depeId);
                    //手机号
                    String mobile = dingUser.getResult().getList().get(j).getMobile();
                    String md5 = MD5Util.getMD5(mobile + "123123");
                    sysUser.setUserName(dingUser.getResult().getList().get(j).getName());
                    sysUser.setPhonenumber(dingUser.getResult().getList().get(j).getMobile());
                    sysUser.setLoginName(dingUser.getResult().getList().get(j).getMobile());
                    sysUser.setPassword(md5);
                    sysUser.setCreateTime(new Date());
                    sysUser.setAvatar(dingUser.getResult().getList().get(j).getAvatar());
                    Long userId=iSysUserService.insertUserInfo(sysUser);
//                        int userCount =iSysUserService.findUserCount(sysUser);
                    System.out.println("部门下人员信息:-"+name);
                }
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }
        return AjaxResult.success();
    }

   /* public static void main(String[] args) {
        String appKey="dingjklrbydaevwecqxp";
        String appSecret="PovXa4wL9JsVeH2u8bwh40XP72G5MixfiZdIAHQeGoI14_UqEFXPA4q32382gVng";
        *//*String appKey="ding7kh9p9ns4r8j5n6j";
        String appSecret="gRSOPyDB4akbbV4zi124TZhMQPsZs3IC6m-O7YPeLhrnkA2AW_e6EJdkshmcycGv";*//*
        Map map = JSONObject.parseObject(JSONObject.toJSONString(new DingGetTokenDto(appKey,appSecret)), Map.class);
        int timeout=2*60-10;
        String result = HttpUtil.get("https://oapi.dingtalk.com/gettoken", map, timeout);
        String token = JSONObject.parseObject(result).getString("access_token");
        System.out.println(token);
        try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
            OapiDepartmentListRequest req = new OapiDepartmentListRequest();
            req.setLang("zh_CN");
            req.setFetchChild(true);//是否要查询部门下面的子级
            req.setId("1");           //查询社区477278005
            req.setHttpMethod("GET");
            OapiDepartmentListResponse rsp = client.execute(req, token);
            System.out.println(rsp.getBody());
            organizationParm organization = JSONObject.parseObject(rsp.getBody(),organizationParm.class);
//            System.out.println(organization.getDepartment().get(0).getName());
            SysDept sysDept = new SysDept();
            SysRegion sysRegion = new SysRegion();
            *//*for (int i=0;i<organization.getDepartment().size();i++){
                //父级id
                sysRegion.setParentId("1794264");
                //名称
                sysRegion.setRegionName(organization.getDepartment().get(i).getName());
                //创建人
                sysRegion.setCreateBy("admin");
                //创建时间
                sysRegion.setCreateTime(new Date());
                iSysRegionService.insertSysRegion(sysRegion);
            }*//*

        } catch (ApiException e) {
            e.printStackTrace();
        }
    }*/
}
