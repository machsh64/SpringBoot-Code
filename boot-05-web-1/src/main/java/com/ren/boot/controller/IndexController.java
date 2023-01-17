package com.ren.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-17 19:41
 * @description:
 **/
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("test","测试跳转");
        return "index";
    }

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){

        request.setAttribute("msg","成功了///....");
        request.setAttribute("code",2024);

        return "forward:success";  // 转发到 /success 请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") Integer code,
                                       HttpServletRequest request){
        // 或者
        String msg1 = (String) request.getAttribute("msg");
        Integer code1 = (Integer) request.getAttribute("code");

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("annotation_msg",msg);
        map.put("annotation_code",code);
        map.put("reqMethod_msg1",msg1);
        map.put("reqMethod_code1",code1);

        return map;
    }

    //  1，语法： /cars/sell;low=34;brand=byd,audi,yd
    //  2，SpringBoot默认是禁用了矩阵变量
    //      手动开启：原理，对于路径的处理，UrlPathHelper进行解析，
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    @ResponseBody
    @GetMapping("/cars/sell")
    public Map<String,Object> carsSell(@MatrixVariable("low") Integer low,
                                       @MatrixVariable("brand") List<String> brand){
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();

        map.put("low",low);
        map.put("brand",brand);

        return map;
    }
}
