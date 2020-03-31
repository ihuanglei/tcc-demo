/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 11:05 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.common;

public enum PayStatus {

    Wait(1), Payed(2);

    private int value;

    PayStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == 1) {
            return "wait";
        } else if (value == 2) {
            return "payed";
        }
        return "unknown";
    }

    public static PayStatus fromValue(int value) {
        for (PayStatus payStatus : values()) {
            if (payStatus.value == value) {
                return payStatus;
            }
        }
        return null;
    }
}
