package com.ren.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-28 19:58
 * @description: 文件上传测试
 **/
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {

        return "form/form_layouts";
    }

    // MultipartFile 自动封装上传过来的文件
    @PostMapping("/upload")
    public String upLoad(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,  // 使用 @RequestPart 对文件类型注解
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        /* 注意在application.properties中配置最大上传文件大小，避免上传失败 */

        log.info("上传的信息：email={}, username={}. headerImg={}, photos={}",
                email, username, headerImg.getSize(), photos.length);

        // 如果文件不为空
        if(!headerImg.isEmpty()){
            // 保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();// 原始的文件名
            headerImg.transferTo(new File("D:\\RenComp\\ehcache\\upload\\"+originalFilename));  // 利用transferTo将文件保存在对应路径
        }
        if (photos.length > 0){
            // 遍历文件，对所有文件进行保存
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\RenComp\\ehcache\\upload\\"+originalFilename));
                }
            }
        }

        return "redirect:/index.html";  // 从post需要重定向到index.html 否则会因为地址栏的/upload报错不支持GET方式请求
    }
}
