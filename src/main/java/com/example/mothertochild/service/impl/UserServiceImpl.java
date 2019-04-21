package com.example.mothertochild.service.impl;

import com.example.mothertochild.entity.User;
import com.example.mothertochild.mapper.UserMapper;
import com.example.mothertochild.service.UserService;
import com.github.pagehelper.Page;
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

    @Override
    public User getUser(int userId) {
        return null;
    }

    @Override
    public int updatePassword(int userId, String password, String newPassword) {
        return userMapper.updatePassword(userId,password, newPassword);
    }

    @Override
    public int addUser(User user) {
        String q = user.getPassword();
        System.out.println("password:" + q);
        return userMapper.addUser(user);
    }

    @Override
    public Page<User>  userList() {
        return userMapper.userList();
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUserImage(int userId, String userImage) {
        return userMapper.updateUserImage(userId,userImage);
    }
}
