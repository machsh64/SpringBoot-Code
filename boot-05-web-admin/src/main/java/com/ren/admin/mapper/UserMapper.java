package com.ren.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ren.admin.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-03 19:33
 * @description:
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 获取user
     * @param: id
     * @return:
     */
    User getUser(@Param("id") Integer id);

    @Insert("INSERT INTO user(name,age,email) VALUES(#{name},#{age},#{email})")
    Integer saveUser(User user);
}
