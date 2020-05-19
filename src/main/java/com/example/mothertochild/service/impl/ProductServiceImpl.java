package com.example.mothertochild.service.impl;

import com.example.mothertochild.entity.Product;
import com.example.mothertochild.entity.User;
import com.example.mothertochild.mapper.ProductMapper;
import com.example.mothertochild.service.ProductService;
import com.example.mothertochild.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findProdcutsByCategoryId(int categoryId) {
        return productMapper.findProductByCategoryId(categoryId);
    }

    @Override
    public Product findProductById(int productId) {
        return productMapper.findProductById(productId);
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public Page<Product> productList() {
        return productMapper.productList();
    }

    @Override
    public int updateStock(int productId, int stock) {
        return productMapper.updateStock(productId,stock);
    }

    @Override
    public int deleteProduct(int productId) {
        return productMapper.deleteProduct(productId);
    }

    @Override
    public int updateProductImages(int productId, String productImages) {
        return productMapper.updataProductImages(productId,productImages);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    public List<Product> searchProductList(String productName) {
        return productMapper.searchProductList(productName);
    }
}
