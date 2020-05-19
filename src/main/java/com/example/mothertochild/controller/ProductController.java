package com.example.mothertochild.controller;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.entity.Product;
import com.example.mothertochild.service.impl.ProductServiceImpl;
import com.example.mothertochild.util.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "ProductController-商品接口")
@RestController
//@RestController 代替 @Controller,省略以后的 @ResponseBody
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @ApiOperation(value = "删除产品",notes = "根据id删除产品")
    @PostMapping("/product/delete")
    public JsonResult deleteProduct(@RequestBody Product product) {
        System.out.println("iiiiiiiiiiiiiiiiii"+ product.toString());
        int row = productService.deleteProduct(product.getProductId());
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @PostMapping("/product/updateStock")
    @ApiOperation(value="更新产品库存量", notes="根据商品id修改库存量")
    public JsonResult  updateStock(@RequestBody Product product) {
        System.out.println("iiiiiiiiiiiiiiiiii"+ product.toString());
        int row = productService.updateStock(product.getProductId(),product.getStock());
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @PostMapping("/product/updateProductImages")
    @ApiOperation(value="更新产品库存量", notes="根据商品id修改库存量")
    public JsonResult  updateProductImages(@RequestBody Product product) {
        System.out.println("iiiiiiiiiiiiiiiiii"+ product.getProductImages());
        int row = productService.updateProductImages(product.getProductId(),product.getProductImages());
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }


    @PostMapping("/product/update")
    @ApiOperation(value="更新产品", notes="根据商品id更新产品")
    public JsonResult  updateProduct(@RequestBody Product product) {
        int row = productService.updateProduct(product);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @ApiOperation(value = "新增一个商品")
    @PostMapping("/product/insert")
    public JsonResult insert(@RequestBody Product product) {
        System.out.println("iiiiiiiiiiiiiiiiii"+ product.toString());
        int row = productService.addProduct(product);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(product);
        }
            return jsonResult;
    }


    @ApiOperation( value = "查找商品",notes = "根据商品类别查找商品")
    @GetMapping("/product/findProductByCategoryId")
    @ApiImplicitParam(paramType = "query",name = "categoryId",value = "类别Id",required = true,dataType = "int")
    public JsonResult  findProductByName( @RequestParam int categoryId){
        List<Product> productList = productService.findProdcutsByCategoryId(categoryId);
        JsonResult jsonResult = new JsonResult();
        if (productList != null) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(productList);
        }
        return jsonResult;
    }

    @ApiOperation( value = "查找商品",notes = "根据商品Id查找商品")
    @GetMapping("/product/findProductById")
    @ApiImplicitParam(paramType = "query",name = "productId",value = "商品Id",required = true,dataType = "int")
    public JsonResult  findProductById( @RequestParam int productId){
        Product product = productService.findProductById(productId);
        JsonResult jsonResult = new JsonResult();
        if (product != null) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(product);
        }
        return jsonResult;
    }


    @ApiOperation(value = "分页查询")
    @GetMapping("/products")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页面",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "一页大小",required = true,dataType = "int")
    })
    public JsonResult getProductList(@RequestParam int pageNum, @RequestParam int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<Product> productList = productService.productList();
        JsonResult jsonResult = new JsonResult();
        if (productList != null && productList.size() > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(productList);
        }
        return jsonResult;
    }

    @GetMapping("/search/products")
    @ApiOperation(value = "检索查询商品")
    @ApiImplicitParam(paramType = "query",name = "productName",value = "类别名",required = true,dataType = "String")

    public JsonResult searchProductList(@RequestParam String productName){
        JsonResult jsonResult = new JsonResult();
        System.out.println("productName"+  productName);
        List<Product> products = productService.searchProductList(productName);
        if(products != null && !products.isEmpty()){
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(products);
        }
        return jsonResult;
    }
}
