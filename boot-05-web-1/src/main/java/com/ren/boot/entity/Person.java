package com.ren.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-24 17:32
 * @description:
 **/
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private String username;

    private String password;

    private Integer age;
}
