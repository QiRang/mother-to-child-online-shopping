package com.example.mothertochild.controller;

import com.example.mothertochild.entity.User;
import com.example.mothertochild.service.impl.UserServiceImpl;
import com.example.mothertochild.util.DataUtils;
import com.example.mothertochild.util.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(value = "UserController-用户接口")
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
    @PostMapping("/user/delete")
    @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "String")
    //name是参数的名称，value是参数的说明
    // required true时是必传参数、false是选填参数，dataType是参数的类型，前端不是限制，仅做说明使用，
//    paramType是指定参数放在哪个地方
//    header：请求参数放置于Request Header，使用@RequestHeader获取
//    query：请求参数放置于请求地址，使用@RequestParam获取
//    path：（用于restful接口）-->请求参数的获取：@PathVariable
//    body：（不常用）
//    form（不常用）
    public JsonResult deleteUser(@RequestBody String id) {
        System.out.println("Id:"+ id);
        //System.out.println("iii"+ Integer.valueOf(userId));
        int userId =  DataUtils.getNumbers(id);
        System.out.println("userId:" + userId);
        int row = userService.deleteUser(userId);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    //@PutMapping("/user")
    @PostMapping("/user/updatePassword")
    @ApiOperation(value="修改用户密码", notes="根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public JsonResult  updateUser(@RequestParam(value="id") int id, @RequestParam(value="password") String password,
                                 @RequestParam(value="newPassword") String newPassword) {
        System.out.println("newPassword:" + newPassword);
        int row = userService.updatePassword(id,password,newPassword);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @ApiOperation(value = "新增一个用户")
    @PostMapping("/user/add")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "username",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "password",value = "用户密码",required = true,dataType = "String")
    })
    public JsonResult insert(@RequestParam String username, @RequestParam String password) {
        User user = new User(username,password);
        System.out.println("username:" + username);
        int row = userService.addUser(user);
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
            jsonResult.setValue(user);
        }
        return jsonResult;
    }


    @ApiOperation( value = "查找用户",notes = "根据用户名查找用户")
    @GetMapping("/user/findUserByName")
    @ApiImplicitParam(paramType = "query",name = "username",value = "用户名",required = true,dataType = "String")
    public JsonResult  findUserByName( @RequestParam String username){
        System.out.println("username" + username);
        User user = userService.findByName(username);
        JsonResult jsonResult = new JsonResult();
        if (user != null) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
            jsonResult.setValue(user);
        }
        return jsonResult;
    }
    @ApiOperation( value = "查找用户",notes = "根据用户名查找用户")
    @GetMapping("/user/findUserById")
    @ApiImplicitParam(paramType = "query",name = "userId",value = "用户id",required = true,dataType = "int")
    public JsonResult  getUser( @RequestParam int userId){
        User user = userService.getUser(userId);
        JsonResult jsonResult = new JsonResult();
        if (user != null) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
            jsonResult.setValue(user);
        }
        return jsonResult;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/users")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页面",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "一页大小",required = true,dataType = "int")
    })
    public JsonResult getUserList(@RequestParam int pageNum, @RequestParam int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList = userService.userList();
        JsonResult jsonResult = new JsonResult();
        if (userList != null && userList.size() > 0) {
            jsonResult.setCode(200);
            jsonResult.setSuccess("true");
            jsonResult.setMessage("成功");
            jsonResult.setValue(userList);
        }
        return jsonResult;
    }

//    @ApiOperation(value = "查询所有")
//    @GetMapping("/users")
//    private JsonResult  userList(){
//        List<User> userLists = userService.userList();
//        JsonResult jsonResult = new JsonResult();
//        if (userLists != null && userLists.size() > 0) {
//            jsonResult.setCode(200);
//            jsonResult.setSuccess("true");
//            jsonResult.setMessage("成功");
//            jsonResult.setValue(userLists);
//        }
//        return jsonResult;
//    }
}
