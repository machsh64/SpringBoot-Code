package com.ren.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-26 18:38
 * @description:
 **/
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String birthday;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public User(String username,String password,String birthday){
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }
}
