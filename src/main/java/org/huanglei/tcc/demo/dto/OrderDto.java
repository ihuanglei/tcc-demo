/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 11:02 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.dto;

import lombok.Data;
import org.huanglei.tcc.demo.common.PayStatus;

import java.io.Serializable;

@Data
public class OrderDto implements Serializable {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单商品名称
     */
    private String productName;

    /**
     * 订单金额
     */
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
     * 状态
     */
    private PayStatus status;

}
