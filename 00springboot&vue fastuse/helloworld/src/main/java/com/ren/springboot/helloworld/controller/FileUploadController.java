package com.ren.springboot.helloworld.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-12 19:11
 * @description:
 **/
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    @ApiOperation("文件上传")  // 用来在Swagger API中描述方法
    public String upload(String nickName, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println("nickName :"+nickName);

        // 获取图片的原始名称
        System.out.println("photo before name :"+photo.getOriginalFilename());
        // 获取文件类型
        System.out.println("photo ContentType :"+photo.getContentType());

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println("path :"+path);
        saveFile(photo,path);
        return "上传成功";
    }

    public void saveFile(MultipartFile photo,String path) throws IOException {
        // 判断存储的目录是否存在，如果不存在则创建
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }

        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
