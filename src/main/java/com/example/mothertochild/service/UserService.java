package com.example.mothertochild.service;

import com.example.mothertochild.entity.User;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public User findByName(String username);
    public User getUser(int userId);
    public int  insetUser(User user);
    public Page<User> userList();
    public int updatePassword(int id,String password, String NewPassword);
    public int deleteUser(int id);
    public int updateUserImage(int userId, String userImage);
    public User login(String username, String password);

}
