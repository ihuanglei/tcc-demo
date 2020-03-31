/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 9:41 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.entity;

import lombok.Data;

import java.util.Date;


/**
 * 支付记录
 */
@Data
public class PayRecordEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 支付号
     */
    private Long payNo;

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
     * 备注
     */
    private String memo;

    /**
     * 状态
     */
    private int status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
