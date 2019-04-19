package com.example.mothertochild.controller;

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

@Api(value = "ProductController-商品接口")
@RestController
//@RestController 代替 @Controller,省略以后的 @ResponseBody
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
    @DeleteMapping("/product/{productId}")
    @ApiImplicitParam(paramType = "query",name = "id",value = "商品ID",required = true,dataType = "int")
    public JsonResult deleteProduct(@RequestParam int id) {
        int row = productService.deleteProduct(id);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @PatchMapping("/product")
    @ApiOperation(value="修改用户密码", notes="根据商品id修改库存量")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "商品ID", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "stock", value = "商品库存量", required = true, dataType = "int"),
    })
    public JsonResult  updateProduct(@RequestParam(value="id") int id, @RequestParam(value="stock") int stock) {
        int row = productService.updateStock(id,stock);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

@ApiOperation(value = "新增一个商品")
@PostMapping("/product")
public JsonResult insert(@RequestBody Product product) {
    System.out.println("ppppppp" + product);
    //Product  product = new Product();
    System.out.println("iiiiiiiiiiiiiiiiii"+ product.toString());
    int row = productService.addProduct(product);
    JsonResult jsonResult = new JsonResult();
    if (row > 0) {
        jsonResult.setCode(200);
        jsonResult.setSuccess("true");
        jsonResult.setMessage("成功");
        jsonResult.setValue(product);
    }
        return jsonResult;
    //return product.toString();
}


    @ApiOperation( value = "查找用户",notes = "根据用户名查找用户")
    @GetMapping("/product/{productName}")
    @ApiImplicitParam(paramType = "query",name = "productName",value = "用户名",required = true,dataType = "String")
    public JsonResult  findProductByName( @RequestParam String productName){
        Product product = productService.findByName(productName);
        JsonResult jsonResult = new JsonResult();
        if (product != null) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
            jsonResult.setValue(product);
        }
        return jsonResult;
    }
//    @ApiOperation( value = "查找用户",notes = "根据用户名查找用户")
//    @GetMapping("/user/{userId}")
//    @ApiImplicitParam(paramType = "query",name = "userId",value = "用户id",required = true,dataType = "int")
//    public JsonResult  getUser( @RequestParam int userId){
//        User user = userService.getUser(userId);
//        JsonResult jsonResult = new JsonResult();
//        if (user != null) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//            jsonResult.setValue(user);
//        }
//        return jsonResult;
//    }

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
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
            jsonResult.setValue(productList);
        }
        return jsonResult;
    }

}
