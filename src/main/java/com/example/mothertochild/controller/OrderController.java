package com.example.mothertochild.controller;

import com.example.mothertochild.entity.Order;
import com.example.mothertochild.service.impl.OrderServiceImpl;
import com.example.mothertochild.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private OrderServiceImpl orderService;

    @GetMapping("/orders")
    private JsonResult orderList(){
        JsonResult jsonResult = new JsonResult();
        List<Order> orders = orderService.orderList();
        if(orders != null && !orders.isEmpty()){
            jsonResult.setCode(200);
            jsonResult.setValue(orders);
        }
        return jsonResult;
    }

}
