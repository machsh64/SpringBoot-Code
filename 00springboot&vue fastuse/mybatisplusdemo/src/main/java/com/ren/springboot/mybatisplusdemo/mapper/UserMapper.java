package com.ren.springboot.mybatisplusdemo.mapper;

import com.ren.springboot.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-13 17:18
 * @description:
 **/
@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user VALUES(#{username},#{password},#{birthday})")
    int add(User user);

    @Update("UPDATE user SET username=#{username},password=#{password},birthday=#{birthday} WHERE id=${id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(Integer id);

    @Select("SELECT id, username, password, birthday FROM user WHERE id=#{id}")
    User findById(Integer id);

    @Select("SELECT id, username, password, birthday FROM user")
    List<User> getAll();
}
