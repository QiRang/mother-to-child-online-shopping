package com.example.mothertochild.controller;

import com.example.mothertochild.entity.Category;
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
    public JsonResult deleteCategory(@RequestParam int categoryId) {
        int row = categoryService.deleteCategory(categoryId);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @PostMapping("/category/update")
    @ApiOperation(value="修改商品类别", notes="根据id修改name")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "categoryId", value = "categoryId", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "categoryName", value = "categoryName", required = true, dataType = "String")
    })
    public JsonResult  updateCategory(@RequestParam(value="categoryId") int categoryId,
                                  @RequestParam(value="categoryName") String categoryName) {
        System.out.println("categoryName:" + categoryName);
        int row = categoryService.updateCategory(categoryId,categoryName);
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
            @ApiImplicitParam(paramType = "body",name = "categoryName",value = "商品类别名",required = true,dataType = "String"),
    })
    public JsonResult insert(@RequestBody String categoryName) {
        System.out.println("categoryName:"+categoryName);
        int row = categoryService.insertCategory(categoryName);
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
