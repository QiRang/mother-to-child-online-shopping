package com.example.mothertochild.service;

import com.example.mothertochild.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> categoryList();
    int insertCategory(String categoryName);
    int deleteCategory(int categoryId);
    Category getCategory(String categoryName);
    int updateCategory(int categoryId , String categoryName);

}
