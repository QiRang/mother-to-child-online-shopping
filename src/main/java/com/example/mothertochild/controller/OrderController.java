package com.example.mothertochild.controller;

import com.example.mothertochild.entity.Order;
import com.example.mothertochild.service.impl.OrderServiceImpl;
import com.example.mothertochild.util.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/orders")
    public JsonResult orderList(){
        JsonResult jsonResult = new JsonResult();
        List<Order> orders = orderService.orderList();
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
