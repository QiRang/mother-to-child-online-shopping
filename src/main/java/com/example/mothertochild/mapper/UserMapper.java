package com.example.mothertochild.mapper;

import com.example.mothertochild.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //指定这是一个操作数据库的mapper
public interface UserMapper {
    //按用户名单条查询
    @Select("select * from user where username = #{username}")
    User findUserByName(String username);
    //查询所有
    @Select("select * from user")
    List<User> userList();
    //插入一条记录
    //@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(username,password) values (#{username},#{password})")
//    int insertUser(String username, String password);
    int insertUser(User user);
    //删除一条记录
    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);
    //更改密码
    @Update("update user set password = #{NewPassword} where id = #{id}")
    public int updateUser(int id, String password, String NewPassword);

}
