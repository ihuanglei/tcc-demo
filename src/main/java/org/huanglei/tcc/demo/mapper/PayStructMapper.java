/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/14/20, 4:41 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.mapper;

import org.huanglei.tcc.demo.dto.OrderDto;
import org.huanglei.tcc.demo.dto.PayRecordDto;
import org.huanglei.tcc.demo.entity.PayRecordEntity;
import org.huanglei.tcc.demo.form.OrderForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PayStructMapper {

    PayStructMapper MAPPER = Mappers.getMapper(PayStructMapper.class);

    PayRecordDto fromPayRecordEntity(PayRecordEntity payRecordEntity);

    @Mapping(target = "status",source = "status.value")
    PayRecordEntity fromOrderDto(OrderDto orderDto);

    OrderDto fromOrderForm(OrderForm orderForm);

    List<PayRecordDto> fromPayRecordEntityList(List<PayRecordEntity> payRecordEntityList);

}
