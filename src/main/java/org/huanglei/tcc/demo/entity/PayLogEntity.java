/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 10:05 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.entity;

import lombok.Data;

/**
 * 支付日志
 */
@Data
public class PayLogEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Long createTime;

}
