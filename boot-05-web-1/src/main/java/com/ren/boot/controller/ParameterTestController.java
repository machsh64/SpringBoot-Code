package com.ren.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-17 20:17
 * @description:
 **/
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-e9b925a2") String _ga,
                                     @CookieValue("Idea-e9b925a2") Cookie cookie){
        HashMap<String, Object> map = new LinkedHashMap<>();

        map.put("id",id);
        map.put("name",username);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("_ga",_ga);

        System.out.println(cookie.getName()+"  ====>  "+cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map<String,Object> postMethod(@RequestBody String content){
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("content",content);
        return map;
    }
}
