/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 10:58 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
public class RestResult implements Serializable {

    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String error;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    /**
     * 正确返回
     *
     * @return
     */
    public static RestResultBuilder builderOK() {
        return builder().code(HttpStatus.OK.value());
    }

    /**
     * 服务器错误
     *
     * @return
     */
    public static RestResultBuilder builderServerError() {
        return builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * 参数错误
     *
     * @return
     */
    public static RestResultBuilder builderBadRequest() {
        return builder().code(HttpStatus.BAD_REQUEST.value());
    }

    /**
     * 404
     *
     * @return
     */
    public static RestResult NotFound() {
        return builder().code(HttpStatus.NOT_FOUND.value()).error("Not Found").build();
    }

    /**
     * @param error
     * @return
     */
    public static RestResult BadRequest(String error) {
        return RestResult.builderBadRequest().error(error).build();
    }

    /**
     * @param error
     * @return
     */
    public static RestResult ServerError(String error) {
        return RestResult.builderServerError().error(error).build();
    }

    /**
     * @return
     */
    public static RestResult OK() {
        return RestResult.builderOK().error("").build();
    }

}
