package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper //指定这是一个操作数据+-库的mapper
public interface UserMapper {
    //按名单条查询
    @Select("select * from user where username = #{username}")
    User findUserByName(String username);
    //查询所有
    @Select("select * from user")
    Page<User> userList();
    //按id单条查询
    @Select("select * from user where userId = #{userId}")
    User getUser(int userId);
    //插入一条记录
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into user(username,password,phoneNumber,sex,birth,userImage) values (#{username},#{password},#{phoneNumber},#{sex},#{birth},#{userImage})")
    int insertUser(User user);
    //删除一条记录
    @Delete("delete from user where userId = #{userId}")
    int deleteUser(int userId);
    //更改密码
    @Update("update user set password = #{newPassword} where userId = #{userId} and password = #{password}")
    public int updatePassword(int userId, String password, String newPassword);
    //更改头像
    @Update("update user set userImage = #{userImage} where userId = #{userId}")
    public int updateUserImage(int userId, String userImage);
    //用户登陆
    @Select("Select * from user  where username = #{username} and password = #{password}")
    public User login(String username, String password);

}
