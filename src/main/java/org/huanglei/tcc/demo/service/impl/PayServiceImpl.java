/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/8/20, 7:00 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.dromara.hmily.annotation.Hmily;
import org.huanglei.tcc.demo.common.PayStatus;
import org.huanglei.tcc.demo.dao.PayRecordMapper;
import org.huanglei.tcc.demo.dto.OrderDto;
import org.huanglei.tcc.demo.dto.PayRecordDto;
import org.huanglei.tcc.demo.entity.PayRecordEntity;
import org.huanglei.tcc.demo.exception.PayRuntimeException;
import org.huanglei.tcc.demo.mapper.PayStructMapper;
import org.huanglei.tcc.demo.service.PayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("payService")
public class PayServiceImpl implements PayService {

    @Resource
    private PayRecordMapper payRecordMapper;

    @Override
    @Transactional
    public void setPayStatus(Long payNo, PayStatus payStatus) {

    }

    @Override
    @Transactional
    @Hmily(cancelMethod = "cancel", confirmMethod = "confirm")
    public PayRecordDto createPayRecord(OrderDto orderDto) {
        if (orderDto == null) {
            throw new PayRuntimeException("order is null");
        }
        if (StringUtils.isEmpty(orderDto.getOrderNo())) {
            throw new PayRuntimeException("order no is empty");
        }
        if (StringUtils.isEmpty(orderDto.getProductName())) {
            throw new PayRuntimeException("order product name is empty");
        }
        if (orderDto.getPrice() == null || orderDto.getPrice() < 0) {
            throw new PayRuntimeException("order price must great 0");
        }
        orderDto.setStatus(PayStatus.Wait);
        PayRecordEntity record = PayStructMapper.MAPPER.fromOrderDto(orderDto);
        // TODO: 找一个唯一ID生成算法，比如snowflake
        record.setPayNo(111L);
        record.setCreateTime(Calendar.getInstance().getTime());
        record.setUpdateTime(record.getCreateTime());
        payRecordMapper.addPayRecord(record);
        throw new PayRuntimeException("test tcc");
//        return PayStructMapper.MAPPER.fromPayRecordEntity(record);
    }

    @Override
    public List<PayRecordDto> getPayRecordList(String orderNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderNo", orderNo);
        List<PayRecordEntity> payRecordEntityList = payRecordMapper.getPayRecordList(params);
        List<PayRecordDto> payRecordDtoList = PayStructMapper.MAPPER.fromPayRecordEntityList(payRecordEntityList);
        return payRecordDtoList;
    }

    @Override
    public List<OrderDto> getOrderList() {
        return null;
    }

    @Override
    public PayRecordDto getPayRecord(Long payNo) {
        return null;
    }

    @Override
    public boolean confirm(OrderDto orderDto) {
        System.out.println("confirm");
        return Boolean.TRUE;
    }

    @Override
    public boolean cancel(OrderDto orderDto) {
//        throw new RuntimeException("cancel exception");
        System.out.println("cancel");
        return Boolean.FALSE;
    }
}
