package com.ren.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-17 19:02
 * @description:
 **/
@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

    // 自定义filter
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties pro = new Properties();
        pro.setProperty("java.lang.Exception","error");
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }
}
