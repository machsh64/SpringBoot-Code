package com.ren.springboot.mybatisplusdemo.service;

import com.ren.springboot.mybatisplusdemo.entity.User;
import java.util.List;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-13 17:27
 * @description:
 **/
public interface UserService {

    int add(User user);

    int update(User user);

    int delete(Integer id);

    User findById(Integer id);

    List<User> getAll();
}
