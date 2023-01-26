package com.ren.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-26 17:35
 * @description:
 **/
@Controller
public class ViewController {

    @GetMapping("/pageInfo/{page}")
    public String gotoPage(@PathVariable("page") String page){

        return page;
    }

    @GetMapping("/renpage")
    public String renPage(Model model){

        // model中的数据会被放在请求域中，request.setAttribute("a",aa)
        model.addAttribute("msg","你好，我是ren");
        model.addAttribute("link","https://igotu.top");
        return "success";
    }

}
