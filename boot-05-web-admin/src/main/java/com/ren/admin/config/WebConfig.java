package com.ren.admin.config;

import com.ren.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-28 17:24
 * @description: 代替SpringMVC的配置文件
 * 扫描组件 ，视图解析器 ，默认的servlet ，mvc的注解驱动 ，视图控制器 ，文件上传解析器 ，拦截器 ，异常解析器
 **/
// 将类表示为配置类
@Configuration
// 开启mvc的注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/","/login","/js/**","/css/**","/images/**","/fonts/**","/html/**","/error","/upload");
    }

    // 异常解析器
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", " classpath:/public/" };
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }
    }

}