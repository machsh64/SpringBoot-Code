package com.ren.springboot.mybatisplusdemo;

import com.ren.springboot.mybatisplusdemo.entity.User;
import com.ren.springboot.mybatisplusdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class MybatisplusdemoApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    public String query() {
        User user = userService.findById(1);
        System.out.println(user);

        return "查询用户";
    }
}
