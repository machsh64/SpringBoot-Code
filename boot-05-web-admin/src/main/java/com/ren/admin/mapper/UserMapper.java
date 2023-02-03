package com.ren.admin.mapper;

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
public interface UserMapper {

    /**
     * 获取user
     * @param: id
     * @return:
     */
    User getUser(@Param("id") Integer id);

    @Insert("INSERT INTO user(username,password,birthday) VALUES(#{username},#{password},#{birthday})")
    Integer saveUser(User user);
}
