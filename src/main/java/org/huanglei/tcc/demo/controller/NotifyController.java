/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/8/20, 6:59 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.controller;

import org.huanglei.tcc.demo.service.PayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/notify")
public class NotifyController {

    @Resource
    private PayService payService;

    @GetMapping("/callback")
    public String callback() {
        return "ok";
    }
}
