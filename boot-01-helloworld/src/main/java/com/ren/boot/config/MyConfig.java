package com.ren.boot.config;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.ren.boot.entity.Pet;
import com.ren.boot.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.*;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-15 19:24
 * @description:
 **/
/**
 * 1，配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2，配置类本身也是组件
 * 3，proxyBeanMethods：代理bean的方法
 *     Full(proxyBeanMethods = true)，
 *     Lite(proxyBeanMethods = false)
 *     组件依赖
 * 4，@Import({User.class, ByteArrayUtil.class})
 *     给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
 *
 * 5，@ImportResource("classpath:beans.xml") ：会将xml中的组件装配进容器 原生配置文件引入
 */
@Import({User.class, ByteArrayUtil.class})  // 给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
@ImportResource("classpath:beans.xml")      // 会将xml中的组件装配进容器 原生配置文件引入
//@ConditionalOnBean(name = "tomcatPet")    // 当上下文有tomcatPet的实例bean时，才进行被注解组件的装配
@Configuration(proxyBeanMethods = true)     // 告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次，获得的都是之前注册容器的单实例对象
     */

    //@ConditionalOnBean(name = "tomcatPet")  // 当上下文有tomcatPet的实例bean时，才进行被注解组件的装配
    @Bean  // 给容器中添加组件，以方法名为组件的id，返回类型就是组件类型，返回的值，就是组件在容器中的实例
    public User user01(){
        return new User("zhangsan",19);
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tom");
    }
}
