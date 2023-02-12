package com.ren.boot.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-10 21:30
 * @description:
 **/
@Data
@ToString
@Component
@ConfigurationProperties("person")
public class Person {

    private String name;

    private Integer age;

}
