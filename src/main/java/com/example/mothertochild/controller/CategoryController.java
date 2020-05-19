package com.example.mothertochild.controller;

import com.example.mothertochild.entity.Category;
import com.example.mothertochild.entity.Product;
import com.example.mothertochild.service.impl.CategoryServiceImpl;
import com.example.mothertochild.util.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @PostMapping("/category/delete")
    public JsonResult deleteCategory(@RequestBody Category category) {
        int row = categoryService.deleteCategory(category.getCategoryId());
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @PostMapping("/category/update")
    @ApiOperation(value="修改商品类别", notes="根据id修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",name = "category",value = "商品类别",required = true,dataType = "object")
    })
    public JsonResult  updateCategory(@RequestBody  Category category) {
        System.out.println("category" + category.toString());
        int row = categoryService.updateCategory(category);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @ApiOperation(value = "新增一个商品类别")
    @PostMapping("/category/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",name = "category",value = "商品类别",required = true,dataType = "object"),
    })
    public JsonResult insert(@RequestBody  Category category) {

        System.out.println("category:" + category.toString());
        int row = categoryService.insertCategory(category);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @ApiOperation(value = "查询所有")
    @GetMapping("/categories")
    private JsonResult  categoryList(){
        List<Category> categoryLists = categoryService.categoryList();
        JsonResult jsonResult = new JsonResult();
        System.out.println("categoryLists:");
        System.out.println(categoryLists);
        if (categoryLists != null && categoryLists.size() > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(categoryLists);
        }
        return jsonResult;
    }
    @GetMapping("/category/product")
    public JsonResult findCategoryAndProduct(){
        JsonResult jsonResult= new JsonResult();
        List<Category> categoryAndProductList = categoryService.categoryAndProductList();
        if (categoryAndProductList != null && categoryAndProductList.size() > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(categoryAndProductList);
        }
        return jsonResult;
    }
    @GetMapping("/category/page")
    public JsonResult findCategoryWithPage(@RequestParam int pageNum, @RequestParam int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<Category> productList = categoryService.categoryListWithPage();
        JsonResult jsonResult = new JsonResult();
        if (productList != null && productList.size() > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(productList);
        }
        return jsonResult;
    }

    @GetMapping("/search/categories")
    @ApiOperation(value = "检索查询分类")
    @ApiImplicitParam(paramType = "query",name = "categoryName",value = "类别名",required = true,dataType = "String")

    public JsonResult searchCategoryList(@RequestParam String categoryName){
        JsonResult jsonResult = new JsonResult();
        System.out.println("categoryName"+  categoryName);
        List<Category> categories = categoryService.searchCategoryList(categoryName);
        if(categories != null && !categories.isEmpty()){
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(categories);
        }
        return jsonResult;
    }

    @ApiOperation( value = "查找商品类别",notes = "根据name查找商品类别")
    @GetMapping("/category/{categoryName}")
    @ApiImplicitParam(paramType = "query",name = "categoryName",value = "类别名",required = true,dataType = "String")
    public JsonResult  ListUserByName( @RequestParam String categoryName){
        System.out.println("name" + categoryName);
        Category category = categoryService.getCategory(categoryName);
        JsonResult jsonResult = new JsonResult();
        if (category != null) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(category);
        }
        return jsonResult;
    }
}
