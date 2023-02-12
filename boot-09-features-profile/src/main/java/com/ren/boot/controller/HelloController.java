package com.ren.boot.controller;

import com.ren.boot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-10 20:45
 * @description:
 **/
@RestController
public class HelloController {

    @Value("${person.name:王炸}")
    private String name;

    @Autowired
    private Person person;

    @GetMapping("/")
    public String hello(){
        return "Hello : "+name + "  person : "+person;
    }
}
