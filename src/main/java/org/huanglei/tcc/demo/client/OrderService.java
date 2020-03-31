/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/20/20, 2:21 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
public interface OrderService {

    /**
     * 支付完成
     *
     * @param orderNo
     */
    void paySuccess(String orderNo);

}
