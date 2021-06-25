package com.ruoyi.web.controller.foreignInterface;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import junit.framework.TestCase;
import org.apache.shiro.crypto.hash.Hash;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.foreignInterface
 * @ClassName: ProvideDataControllerTest
 * @Author: guohailong
 * @Description:
 * @Date: 2021/4/8 11:28
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProvideDataControllerTest extends TestCase {
    @Autowired
    private WebApplicationContext context;

    MockMvc mockMvc;

    Logger logger = LoggerFactory.getLogger(ProvideDataControllerTest.class);

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Autowired
    ProvideDataController controller;

    @Test
    public void testGetCityEye() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("Component_Code", "1001");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hkapi/index/cityEye").params(params))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testGovernAll() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("Component_Code", "1001");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hkapi/index/governAll").params(params))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testThingPopuliNonstop() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("Component_Code", "1004");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hkapi/index/thingPopuliNonstop").params(params))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void dpDigllog() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("Component_Code", "1004");
        params.add("requestTime", "60000");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hkapi/index/eventInfoByYJ").params(params))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        logger.info(mvcResult.getResponse().getContentAsString());
    }
}