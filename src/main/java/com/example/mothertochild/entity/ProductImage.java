package com.example.mothertochild.entity;

import java.util.List;

public class ProductImage {
    private Integer productImageId;

    private Integer productId;

    //private String productImages;

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

//    public List getProductImages() {
//        return productImages;
//    }
//
//    public void setProductImages(List productImages) {
//        this.productImages = productImages;
//    }
}