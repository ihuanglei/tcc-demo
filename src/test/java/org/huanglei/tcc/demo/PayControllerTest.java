/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/10/20, 3:20 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PayControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

//    @Spy
//    private PayServiceImpl payService;

//    @Autowired
//    private PayMapper payMapper;

//    @InjectMocks
//    private PayController payController;

    @Before
    public void setMockMvc() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(payController)
//                .setControllerAdvice(ExceptionController.class).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testCreate() throws Exception {
        String orderNo = "123";
        RequestBuilder createRequest = MockMvcRequestBuilders.post("/pay/create")
                .param("orderNo", orderNo)
                .param("productName", "测试")
                .param("price", "10000");
        mockMvc.perform(createRequest)
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding("UTF-8");
        mockMvc.perform(MockMvcRequestBuilders.get("/pay/" + orderNo)).andDo(MockMvcResultHandlers.print()).andReturn();
    }

}
