package com.ren.springboot.helloworld.controller;

import com.ren.springboot.helloworld.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-12 17:39
 * @description:
 **/
@RestController
public class HelloController {

    @GetMapping("/hello/{nickName}")
    public String hello(@PathVariable("nickName") String nickName){

        return "你好 "+nickName;
    }

    @GetMapping("/helloTest/{nickName}")
    public String helloTest(@PathVariable("nickName") String nickName){

        return "你好 "+nickName;
    }

    @PostMapping("/postTest1")
    public String postTest1(){

        return "POST请求";
    }

    @PostMapping("/postTest2")
    public String postTest2(String username,String password){
        System.out.println("username"+username);
        System.out.println("password"+password);

        return "POST请求 "+username+" "+password;
    }

    @PostMapping("/postTest3")
    public String postTest2(User user){
        System.out.println("username"+user.getUsername());
        System.out.println("password"+user.getPassword());
        System.out.println("User"+user);

        return "POST请求 "+user;
    }
}
