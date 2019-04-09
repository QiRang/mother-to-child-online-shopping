package com.example.mothertochild.service.impl;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.mapper.CategoryMapper;
import com.example.mothertochild.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        return categoryMapper.categoryList();
    }

    @Override
    public int add(String name) {
        return categoryMapper.insertCategory(name);
    }

    @Override
    public int delete(int id) {
        return categoryMapper.deleteCategory(id);
    }

    @Override
    public Category get(String name) {
        return categoryMapper.getCategory(name);
    }

    @Override
    public int update(int id ,String name) {
        return categoryMapper.updateCategory(id, name);

    }
}
