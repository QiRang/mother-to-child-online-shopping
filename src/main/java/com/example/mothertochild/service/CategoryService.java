package com.example.mothertochild.service;

import com.example.mothertochild.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> list();
    int add(String name);
    int delete(int id);
    Category get(String name);
    int update(int id , String name);

}
