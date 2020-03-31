/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 11:02 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 订单
 */
@Data
public class OrderForm {

    /**
     * 订单号
     */
    @NotEmpty(message = "订单号不能为空")
    private String orderNo;

    /**
     * 订单商品名称
     */
    @NotEmpty(message = "商品名称不能为空")
    private String productName;

    /**
     * 订单金额
     */
    @NotNull(message = "订单金额不能为空")
    @Min(value = 0, message = "订单金额不能小于0")
    @Max(value = Long.MAX_VALUE, message = "订单金额太大")
    private Long price;

    /**
     * 私有字段1
     */
    private String pri1;

    /**
     * 私有字段2
     */
    private String pri2;

    /**
     * 备注
     */
    private String memo;
}
