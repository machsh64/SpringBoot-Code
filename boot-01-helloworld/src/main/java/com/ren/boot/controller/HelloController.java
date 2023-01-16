package com.ren.boot.controller;

import com.ren.boot.entity.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-15 17:57
 * @description:
 **/
@Slf4j  // lombok的日志功能
@RestController
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01(){

        log.info("lombok的slf4j日志请求进来了");

        return "hello, SpringBoot 2"+" 你好";
    }
}
