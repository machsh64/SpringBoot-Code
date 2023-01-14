package com.ren.springboot.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ren.springboot.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-01-13 17:18
 * @description:
 **/
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

  /*  @Insert("INSERT INTO user(username,password,birthday) VALUES(#{username},#{password},#{birthday})")
    int add(User user);


    @Update("UPDATE user(username,password,birthday) SET username=#{username},password=#{password},birthday=#{birthday} WHERE id=${id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(@Param("id") Integer id);

    @Select("SELECT id, username, password, birthday FROM user WHERE id=#{id}")
    User findById(@Param("id") Integer id);

    @Select("SELECT id, username, password, birthday FROM user")
    List<User> getAll();*/

    @Override
    int insert(User entity);

    @Override
    int updateById(User entity);

    @Override
    int deleteById(Serializable id);

    @Override
    User selectById(Serializable id);

    @Override
    List<User> selectList(Wrapper<User> queryWrapper);
}
