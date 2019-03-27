package com.example.mothertochild.service;

import com.example.mothertochild.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public User findByName(String username);
//    public int insertUser(String username ,String password);
    public int insertUser(User user);
    public List<User> userList();
    public int updatePassword(int id,String password, String NewPassword);
    public int deleteUser(int id);

}
