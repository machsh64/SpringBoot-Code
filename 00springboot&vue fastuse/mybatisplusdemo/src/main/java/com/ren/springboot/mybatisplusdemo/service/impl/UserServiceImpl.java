package com.ren.springboot.mybatisplusdemo.service.impl;

import com.ren.springboot.mybatisplusdemo.entity.User;
import com.ren.springboot.mybatisplusdemo.mapper.UserMapper;
import com.ren.springboot.mybatisplusdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-13 17:32
 * @description:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectList(null);
    }

//    @Override
//    public int add(User user) {
//        return userMapper.add(user);
//    }
//
//    @Override
//    public int update(User user) {
//        return userMapper.update(user);
//    }
//
//    @Override
//    public int delete(Integer id) {
//        return userMapper.delete(id);
//    }
//
//    @Override
//    public User findById(Integer id) {
//        return userMapper.findById(id);
//    }
//
//    @Override
//    public List<User> getAll() {
//        return userMapper.getAll();
//    }
}
