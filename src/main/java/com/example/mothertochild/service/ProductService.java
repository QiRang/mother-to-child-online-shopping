package com.example.mothertochild.service;

import com.example.mothertochild.entity.Product;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public Product findByName(String productName);
    public Product getProduct(int productId);
    public int  addProduct(Product product);
    public Page<Product> productList();
    public int updateStock(int productId,int stock);
    public int deleteProduct(int productId);
}
