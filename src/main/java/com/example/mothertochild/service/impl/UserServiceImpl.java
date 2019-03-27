package com.example.mothertochild.service.impl;

import com.example.mothertochild.entity.User;
import com.example.mothertochild.mapper.UserMapper;
import com.example.mothertochild.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByName(String username) {
        return userMapper.findUserByName(username);
    }

//    @Override
//    public int insertUser(String username, String password) {
//        System.out.println("password:" + password);
//        return userMapper.insertUser(username, password);
//    }

    @Override
    public int updatePassword(int id, String password, String NewPassword) {
        return userMapper.updateUser(id,password,NewPassword);
    }

    @Override
    public int insertUser(User user) {
        String q = user.getPassword();
        System.out.println("password:" + q);
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
}
