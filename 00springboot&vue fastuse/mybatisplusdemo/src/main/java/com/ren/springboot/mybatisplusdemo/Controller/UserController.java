package com.ren.springboot.mybatisplusdemo.Controller;

import com.ren.springboot.mybatisplusdemo.entity.User;
import com.ren.springboot.mybatisplusdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return "查询用户 "+allUser;
    }
}
