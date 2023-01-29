package com.ren.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-29 20:19
 * @description:
 **/
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "用户数量太多")  //指定此异常的类型，以及返回的错误消息
public class UserTooManyException extends RuntimeException{

    public UserTooManyException(){

    }

    public UserTooManyException(String msg){
        super(msg);
    }
}
