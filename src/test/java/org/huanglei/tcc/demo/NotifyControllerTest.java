/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/12/20, 12:15 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo;

import org.huanglei.tcc.demo.controller.ExceptionController;
import org.huanglei.tcc.demo.controller.NotifyController;
import org.huanglei.tcc.demo.controller.PayController;
import org.huanglei.tcc.demo.service.impl.PayServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class NotifyControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private NotifyController notifyController;

    @Before
    public void setMockMvc() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(notifyController)
                .setControllerAdvice(ExceptionController.class).build();
    }

    @Test
    public void testCallback() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/notify/callback").contentType("application/json;charset=UTF-8")
                .param("orderNo", "123")
                .param("productName", "测试")
                .param("price", "10000");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding("UTF-8");
    }

}
