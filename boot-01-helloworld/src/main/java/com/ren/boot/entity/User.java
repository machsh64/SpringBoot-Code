package com.ren.boot.entity;

import lombok.*;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-15 19:25
 * @description:
 **/
@ToString  // toString的注解
@NoArgsConstructor
//@AllArgsConstructor // 全参构造器  如果有特殊情况 如 构造器中不需要设置 pet属性，则直接在实体类中进行构造器的设置 放弃该注解
@Data
@EqualsAndHashCode  // 重写equals和hashCode
public class User {

    private String name;

    private Integer age;

    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
