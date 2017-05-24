package com.patty.dubbo.provider.dao;

import com.patty.dubbo.provider.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/24 下午5:05
 * Desc: User数据操作层
 */
public interface UserDao {

    @Select("SELECT * FROM user")
    public List<User> findAllUsers();

    @Select("SELECT * FROM user where wid=#{wId}")
    public User findUserById(@Param("wId") String wId);

    @Insert("Insert into user(wId, name, age, phoneNo) " +
            "values (#{user.wid}, #{user.name}, #{user.age}, #{user.phoneNo})")
    public int addOneUser(@Param("user") User user);

    @Update("Update user set age=#{age} where wid=#{wId}")
    public int updateUser(@Param("wId") String wId, @Param("age") int age);

}
