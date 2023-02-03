package com.ren.admin.service;

import com.ren.admin.entity.User;
import com.ren.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-03 20:11
 * @description:
 **/
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public User getUserById(Integer userId){
        return userMapper.getUser(userId);
    }
}
