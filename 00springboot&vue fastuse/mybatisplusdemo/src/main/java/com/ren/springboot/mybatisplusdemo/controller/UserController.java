package com.ren.springboot.mybatisplusdemo.controller;

import com.ren.springboot.mybatisplusdemo.entity.User;
import com.ren.springboot.mybatisplusdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-13 17:16
 * @description:
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    @ApiOperation("根据id查询用户")
    public String query(@PathVariable("id") Integer id, HttpServletResponse response) {
        User user = userService.findById(id);
        System.out.println(user);
        System.out.println("Default charset: " + response.getCharacterEncoding());
        return "查询用户 :" + user;
    }

    @GetMapping("/user")
    @ApiOperation("查询所有用户")
    public String query(HttpServletResponse response) {
        List<User> allUser = userService.getAll();
        System.out.println("Default charset: " + response.getCharacterEncoding());
        return "查询用户 " + allUser;
    }

    @PostMapping("/user")
    @ApiOperation("插入用户")
    public String save(User user) {
        int i = userService.add(user);

        return i > 0 ? "插入成功" : "插入失败";
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("删除用户")
    public String delete(@PathVariable("id") Integer id) {
        int i = userService.delete(id);

        return i > 0 ? "删除成功" : "删除失败";
    }

    @PutMapping("/user")
    @ApiOperation("修改用户")
    public String update(User user) {
        int i = userService.update(user);

        return i > 0 ? "修改成功" : "修改失败";
    }
}
