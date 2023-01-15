package com.ren.boot;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.ren.boot.config.MyConfig;
import com.ren.boot.entity.Pet;
import com.ren.boot.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-15 17:53
 * @description:
 **/
/**
* 这是一个SpringBoot应用
 * */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args){
        // 1，返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);

        // 2，查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }

       /* // 3，从容器中获取组件
        Pet tom01 = run.getBean("tomcatPet", Pet.class);

        Pet tom02 = run.getBean("tomcatPet", Pet.class);

        System.out.println("组件： "+(tom01 == tom02));  // true

        //4，com.ren.boot.config.MyConfig$$EnhancerBySpringCGLIB$$7f5b3617@3605c4d3
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中
        // 保持组件单实例
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01 == user02);  // true

        System.out.println("+++++++++++++++++++++");
        // 5，获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for(String s : beanNamesForType){
            System.out.println(s);
        }

        ByteArrayUtil bean1 = run.getBean(ByteArrayUtil.class);
        System.out.println(bean1);*/

    }
}
