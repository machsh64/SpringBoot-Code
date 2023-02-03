package com.ren.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-31 22:02
 * @description:
 **/
@Configuration(proxyBeanMethods = true)
public class MyDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")  // 复用配置文件的数据源配置
    public DruidDataSource getDataSource() throws SQLException {

        // druidDataSource.setUrl("xxxx");
        // druidDataSource.setUsername("xxxx");
        // druidDataSource.setPassword("xxxx");
        /* 在引入了spring.datasource后就不用手动设置以上配置 */
        DruidDataSource druidDataSource = new DruidDataSource();
        // 相当于加入了监控功能
        /* 这里同样可以在 application.yaml中配置 */
        //druidDataSource.setFilters("stat,wall");

        return druidDataSource;
    }

    /**
     * 配置 druid 的监控页功能
     * @return
     */
  //  @Bean
    public ServletRegistrationBean<StatViewServlet> staViewServlet(){

        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");

        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123");
        return registrationBean;
    }

    /**
     * WebStatFilter 用于采集web-jdbc关联监控的数据。
     */
  //  @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }
}
