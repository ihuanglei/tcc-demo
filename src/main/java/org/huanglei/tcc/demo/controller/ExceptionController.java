/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/10/20, 1:32 PM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.huanglei.tcc.demo.common.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    /**
     * 参数验证错误拦截
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public RestResult bindException(BindException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : errors) {
            sb.append(error.getDefaultMessage());
        }
        return RestResult.BadRequest(sb.toString());
    }

    /**
     * 数据类型转换错误拦截
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public RestResult parameterTypeException(HttpMessageConversionException exception) {
        return RestResult.BadRequest(exception.getLocalizedMessage());
    }

    /**
     * 404 控制器未找到
     *
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResult notFoundException() {
        return RestResult.NotFound();
    }

    /**
     * 500 错误
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public RestResult exceptionHandler(Exception exception) {
        log.error("500",exception);
        return RestResult.ServerError(exception.getMessage());
    }
}