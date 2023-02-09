package com.ren.admin;

import com.ren.admin.entity.User;
import com.ren.admin.mapper.UserMapper;
import com.ren.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Disabled
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() throws SQLException {

       /* String username = jdbcTemplate.queryForObject("select username from user where id = 1", String.class);
        log.info("1 姓名为 ： "+username);    // 2023-01-31 21:36:20.728  INFO 10888 --- [main] c.r.a.Boot05WebAdminApplicationTests     : 1 姓名为 ： lucy
*/
        User user = userMapper.getUser(1);
        log.info("用户是：{}",user);
        log.info("datasource 数据源为：{}" , dataSource.getClass());
    }

    @Test
    public void testInsert() {
     //  User user = new User("liuliu", "qieqie", "2019-12-03");
     //  Integer integer = userMapper.saveUser(user);
     //  log.info("inser IIII************** {}",integer);
    }

    @Test
    public void testUserMapper() {
        User user = userMapper.selectById(1);
        log.info("#### 用户信息 ： {}#####",user);
    }

}
