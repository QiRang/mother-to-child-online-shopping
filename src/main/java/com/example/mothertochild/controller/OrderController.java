package com.example.mothertochild.controller;

import com.example.mothertochild.entity.Order;
import com.example.mothertochild.service.impl.OrderServiceImpl;
import com.example.mothertochild.util.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/orders")
    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页面",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value = "一页大小",required = true,dataType = "int")
    })
    public JsonResult orderList(@RequestParam int pageNum, @RequestParam int pageSize){
        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(pageNum, pageSize);
        Page<Order> orders = orderService.orderList();

        if(orders != null && !orders.isEmpty()){
            jsonResult.setCode(200);
            jsonResult.setValue(orders);
        }
        return jsonResult;
    }

    @GetMapping("/search/orders")
    @ApiOperation(value = "检索查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "receiver",value = "收件人",required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "mobile",value = "收件人电话",required = false,dataType = "String")
    })
    public JsonResult searchOrderList(@RequestParam String receiver, @RequestParam String mobile){
        JsonResult jsonResult = new JsonResult();
        System.out.println("receiver"+ receiver + mobile);
        List<Order> orders = orderService.searchOrderList(receiver, mobile);
        if(orders != null && !orders.isEmpty()){
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(orders);
        }
        return jsonResult;
    }

    @PostMapping("/order/insert")
    @ApiOperation(value = "新增一个订单")
    public JsonResult insertOrder(@RequestBody Order order){
        System.out.println(order.toString());
        JsonResult jsonResult = new JsonResult();
        int row = orderService.insertOrder(order);
        System.out.println("row" + row);
        if(row > 0){
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(order);
        }
        //System.out.println(jsonResult.getValue());
        return jsonResult;
    }

    //    /user/findOrderByUserId
    @ApiOperation( value = "查找用户订单",notes = "根据用户Id查找用户订单")
    @GetMapping("/order/findOrderByUserId")
    @ApiImplicitParam(paramType = "query",name = "userId",value = "用户id",required = true,dataType = "int")
    public JsonResult  getUserOrder( @RequestParam int userId) {
        System.out.println("--------------------------"+ userId);
        List<Order> orders = orderService.getUserOrder(userId);
        JsonResult jsonResult = new JsonResult();
        System.out.println(orders.toString());
        if (orders != null) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(orders);
        }
        return jsonResult;
    }

    @ApiOperation( value = "查找用户订单",notes = "根据订单Id查找用户订单")
    @GetMapping("/order/findOrderByOrderId")
    @ApiImplicitParam(paramType = "query",name = "orderId",value = "订单id",required = true,dataType = "int")
    public JsonResult  getUserOrderByOrderId( @RequestParam int orderId) {
        System.out.println("--------------------------"+ orderId);
        Order order = orderService.getUserOrderByOrderId(orderId);
        JsonResult jsonResult = new JsonResult();
        System.out.println(order.toString());
        if (order != null) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(order);
        }
        return jsonResult;
    }


    @ApiOperation(value = "删除异常订单",notes = "根据id删除异常产品")
    @PostMapping("/order/delete")
    public JsonResult deleteProduct(@RequestBody Order order) {
        System.out.println("iiiiiiiiiiiiiiiiii"+ order.toString());
        int row = orderService.deleteOrder(order.getOrderId());
        JsonResult jsonResult = new JsonResult();
        if (row > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
        }
        return jsonResult;
    }

    @PostMapping("/order/changeStatus")
    @ApiOperation(value = "修改订单状态")
    public JsonResult updateOrderStatus(@RequestBody Order order){
        System.out.println("-----改订单状态--------"+order.toString());
        JsonResult jsonResult = new JsonResult();
        int row = orderService.updateOrderStatus(order);
        if(row > 0){
            jsonResult.setCode(200);
            jsonResult.setMessage("成功");
            jsonResult.setValue(order);
        }
        //System.out.println(jsonResult.getValue());
        return jsonResult;
    }

}
