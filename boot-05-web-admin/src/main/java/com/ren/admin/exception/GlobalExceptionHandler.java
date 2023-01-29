package com.ren.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-29 19:36
 * @description: 处理整个web controller的异常
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})  // 处理异常
    public String handleArithException(Exception ex) {

        log.info("异常是：", ex);
        return "login";  // 视图地址
    }
}
