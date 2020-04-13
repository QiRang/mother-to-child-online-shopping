package com.example.mothertochild.service;

import com.example.mothertochild.entity.Category;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> categoryList();
    List<Category> categoryAndProductList();
    int insertCategory(Category category);
    int deleteCategory(int categoryId);
    Category getCategory(String categoryName);
    int updateCategory(Category category);
    Page<Category> categoryListWithPage();

}
