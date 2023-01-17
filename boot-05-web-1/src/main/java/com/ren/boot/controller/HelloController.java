package com.ren.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-17 17:06
 * @description:
 **/
@RestController
public class HelloController {

    @RequestMapping("/res.jpg")
    public String hello(){
        return "aaa";
    }
}
