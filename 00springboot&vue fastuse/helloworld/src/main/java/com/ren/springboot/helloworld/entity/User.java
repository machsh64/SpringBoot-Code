package com.ren.springboot.helloworld.entity;

import java.io.Serializable;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-12 18:49
 * @description:
 **/
public class User implements Serializable {

    private String username;

    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
