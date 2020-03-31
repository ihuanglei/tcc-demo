/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 10:41 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.huanglei.tcc.demo.common.PayStatus;

import java.io.Serializable;
import java.util.Date;

@Data
public class PayRecordDto implements Serializable {

    /**
     * 支付号
     */
    private Long payNo;

    /**
     * 备注
     */
    private String memo;

    /**
     * 状态
     */
    private PayStatus status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public void setStatus(int status) {
        this.status = PayStatus.fromValue(status);
    }
}
