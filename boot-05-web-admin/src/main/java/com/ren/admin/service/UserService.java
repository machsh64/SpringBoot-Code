package com.ren.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ren.admin.entity.User;
/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-03 20:11
 * @description:
 **/
public interface UserService extends IService<User> {

    User getUserById(Integer userId);
}
