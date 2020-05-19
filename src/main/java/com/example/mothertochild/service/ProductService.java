package com.example.mothertochild.service;

import com.example.mothertochild.entity.Product;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> findProdcutsByCategoryId(int categoryId);
    public Product findProductById(int productId);
    public int  addProduct(Product product);
    public Page<Product> productList();
    public int updateStock(int productId,int stock);
    public int updateProduct(Product product);
    public int deleteProduct(int productId);
    public int updateProductImages(int productId,String productImages);

    public List<Product> searchProductList(String productName);
}
