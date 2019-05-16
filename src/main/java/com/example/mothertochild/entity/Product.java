package com.example.mothertochild.entity;

import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

@ApiModel(value="商品对象模型")
public class Product {

    //数据库字段
    private String productImages;

    private Integer productId;

    private String productName;

    private String describe;

    private Float price;

    private Integer stock;

    private Integer categoryId;

    private Date createDate;

    //非数据库字段,产品和分类是多对一
    private Category category;
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productImages='" + productImages + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", describe='" + describe + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", categoryId=" + categoryId +
                ", createDate=" + createDate +
                ", category=" + category +
                ", orderItems=" + orderItems +
                '}';
    }
}