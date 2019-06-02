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

}
