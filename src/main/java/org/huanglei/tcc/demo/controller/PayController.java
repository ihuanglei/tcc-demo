/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/8/20, 7:00 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.controller;

import org.huanglei.tcc.demo.common.RestResult;
import org.huanglei.tcc.demo.dto.OrderDto;
import org.huanglei.tcc.demo.dto.PayRecordDto;
import org.huanglei.tcc.demo.form.OrderForm;
import org.huanglei.tcc.demo.mapper.PayStructMapper;
import org.huanglei.tcc.demo.service.PayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/create")
    public RestResult create(@Valid final OrderForm orderForm) {
        OrderDto orderDto = PayStructMapper.MAPPER.fromOrderForm(orderForm);
        PayRecordDto record = payService.createPayRecord(orderDto);
        return RestResult.builderOK().data(record).build();
    }

    /**
     * 订单状态
     *
     * @param orderNo
     * @return
     */
    @PutMapping("/{orderNo}/status")
    public RestResult getPayStatus(@PathVariable("orderNo") String orderNo) {
        return RestResult.OK();
    }

    /**
     * 订单支付记录
     *
     * @param orderNo
     * @return
     */
    @GetMapping("/{orderNo}")
    public RestResult getPayRecordList(@PathVariable("orderNo") String orderNo) {
        return RestResult.builderOK().data(payService.getPayRecordList(orderNo)).build();
    }


}
