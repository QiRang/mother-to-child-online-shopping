//package com.example.mothertochild.controller;
//
//import com.example.mothertochild.entity.Category;
//import com.example.mothertochild.service.impl.CategoryServiceImpl;
//import com.example.mothertochild.util.JsonResult;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CategoryController {
//    @Autowired
//    private CategoryServiceImpl categoryService;
//    public JsonResult deleteUser(@RequestParam int id) {
//        int row = categoryService.delete(id);
//        JsonResult jsonResult = new JsonResult();
//        if (row > 0) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//        }
//        return jsonResult;
//    }
//
//    @PutMapping("/category")
//    @ApiOperation(value="修改商品类别", notes="根据id修改name")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "id", value = "id", required = true, dataType = "int"),
//            @ApiImplicitParam(paramType="query", name = "name", value = "name", required = true, dataType = "String")
//    })
//    public JsonResult  updateCategory(@RequestParam(value="id") int id,
//                                  @RequestParam(value="name") String name) {
//        System.out.println("name:" + name);
//        int row = categoryService.update(id,name);
//        JsonResult jsonResult = new JsonResult();
//        if (row > 0) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//        }
//        return jsonResult;
//    }
//
//    @ApiOperation(value = "新增一个商品类别")
//    @PostMapping("/category")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",name = "name",value = "商品类别名",required = true,dataType = "String"),
//    })
//    public JsonResult insert(@RequestParam String name) {
//        int row = categoryService.add(name);
//        JsonResult jsonResult = new JsonResult();
//        if (row > 0) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//        }
//        return jsonResult;
//    }
//
//    @ApiOperation(value = "查询所有")
//    @GetMapping("/categories")
//    private JsonResult  userList(){
//        List<Category> categoryLists = categoryService.list();
//        JsonResult jsonResult = new JsonResult();
//        if (categoryLists != null && categoryLists.size() > 0) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//            jsonResult.setValue(categoryLists);
//        }
//        return jsonResult;
//    }
//
//    @ApiOperation( value = "查找商品类别",notes = "根据name查找商品类别")
//    @GetMapping("/category/{name}")
//    @ApiImplicitParam(paramType = "query",name = "name",value = "类别名",required = true,dataType = "String")
//    public JsonResult  ListUserByName( @RequestParam String name){
//        System.out.println("name" + name);
//        Category category = categoryService.get(name);
//        JsonResult jsonResult = new JsonResult();
//        if (category != null) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//            jsonResult.setValue(category);
//        }
//        return jsonResult;
//    }
//}
