package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //指定这是一个操作数据+-库的mapper
public interface UserMapper {
    //按用户名单条查询
    @Select("select * from user where username = #{username}")
    User findUserByName(String username);
    //查询所有
    @Select("select * from user")
    Page<User> userList();
    //按id单条查询
    @Select("select * from user where userId = #{userId}")
    User getUser(int userId);
    //插入一条记录
    //@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(username,password) values (#{username},#{password})")
    int addUser(User user);
    //删除一条记录
    @Delete("delete from user where userId = #{userId}")
    int deleteUser(int userId);
    //更改密码
    @Update("update user set password = #{newPassword} where userId = #{userId} and password = #{password}")
    public int updatePassword(int userId, String password, String newPassword);

}
