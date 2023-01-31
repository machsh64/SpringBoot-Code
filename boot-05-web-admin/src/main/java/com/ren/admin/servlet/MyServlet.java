package com.ren.admin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-31 18:06
 * @description:
 **/
//@WebServlet(urlPatterns = "/my")   // 将这个类注解为Servlet 并加入容器供被扫描到
public class MyServlet extends HttpServlet {   // 继承HttpServlet并重写doGet方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("643643643");
    }
}
