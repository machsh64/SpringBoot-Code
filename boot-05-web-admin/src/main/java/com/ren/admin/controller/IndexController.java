package com.ren.admin.controller;

import com.ren.admin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-26 18:23
 * @description:
 **/
@Controller
public class IndexController {

    /**
     * 来登录页
     * @return login
     */
    @GetMapping(value = {"/login","/"})
    public String loginPage(HttpSession session){
        // 再次访问login页面即视为退出登录
        session.setAttribute("loginUser",null);
        return "login";
    }

    @SuppressWarnings("deprecation")
    @PostMapping("/login")
    public String main(User user, Model model, HttpSession session){

        if (!StringUtils.isEmpty(user)&&user.getUsername().equals("123")&&user.getPassword().equals("123")) {
            // 把登陆成功的用户保存到session域
            session.setAttribute("loginUser",user);
            // 登录成功 重定向到index页面
            return "redirect:/index.html";
        }else {
            // 将登陆失败的信息返回
            model.addAttribute("msg","账号或密码错误");
            // 回到登录页
            return "login";
        }
    }

    /**
     * 去index页面
     * @return index
     */
    @GetMapping("/index.html")
    public String indexPage(){

            return "index";
    }
}
