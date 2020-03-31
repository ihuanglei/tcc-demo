/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/8/20, 7:00 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.service;

import org.huanglei.tcc.demo.common.PayStatus;
import org.huanglei.tcc.demo.dto.OrderDto;
import org.huanglei.tcc.demo.dto.PayRecordDto;

import java.util.List;

public interface PayService {

    /**
     * 修改支付流水状态
     *
     * @param payNo
     */
    void setPayStatus(Long payNo, PayStatus payStatus);

    /**
     * 创建支付流水记录
     *
     * @param orderDto
     * @return
     */
    PayRecordDto createPayRecord(OrderDto orderDto);

    /**
     * 根据订单号获取支付流水记录
     *
     * @param orderNo
     * @return
     */
    List<PayRecordDto> getPayRecordList(String orderNo);


    /**
     * 获取订单列表
     *
     * @return
     */
    List<OrderDto> getOrderList();

    /**
     * 根据流水号获取流水记录
     *
     * @param payNo
     * @return
     */
    PayRecordDto getPayRecord(Long payNo);

    boolean confirm(OrderDto orderDto);

    boolean cancel(OrderDto orderDto);
}
