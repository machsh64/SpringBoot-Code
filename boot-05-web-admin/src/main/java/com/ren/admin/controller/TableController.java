package com.ren.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ren.admin.entity.User;
import com.ren.admin.exception.UserTooManyException;
import com.ren.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-26 19:44
 * @description:
 **/
@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {

        return "table/basic_table";
    }

    @DeleteMapping("/dynamic_table/{id}")
    public String delUserInDynamic(@PathVariable("id") Integer id){

        userService.removeById(id);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {

        List<User> userList = userService.list();
        // 自动查出分页数据
        Page<User> userPage = new Page<>(pn,2);
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);

        //model.addAttribute("userList",userList);

        // 表格内容的遍历
      //  LinkedList<User> users = new LinkedList<>();
      //  users.add(new User("张三", "123456"));
      //  users.add(new User("里斯", "124124"));
      //  users.add(new User("哈哈", "3214"));
      //  users.add(new User("哈佛", "51331"));
      //  model.addAttribute("users", users);

       // if (users.size()>3){
       //     throw new ResponseStatusException(HttpStatus.NOT_FOUND,"用户数量太多");
       //     //throw new UserTooManyException("tetetetetet");
       // }
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {

        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {

        return "table/pricing_table";
    }
}
