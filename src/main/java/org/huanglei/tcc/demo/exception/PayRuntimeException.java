/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/8/20, 7:00 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.exception;

public class PayRuntimeException extends RuntimeException {

    public PayRuntimeException(String message) {
        super(message);
    }

    public PayRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayRuntimeException(Throwable cause) {
        super(cause);
    }
}
