package com.ren.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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

    private String name;

    private Integer age;

    private String email;

    @TableField(exist = false)  /** 表示该属性在表中不存在 */
    private String username;
    @TableField(exist = false)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
