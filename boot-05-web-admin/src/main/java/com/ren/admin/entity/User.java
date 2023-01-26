package com.ren.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-26 18:38
 * @description:
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String username;

    private String password;
}
