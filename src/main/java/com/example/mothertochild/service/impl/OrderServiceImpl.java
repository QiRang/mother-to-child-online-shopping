package com.example.mothertochild.service.impl;

import com.example.mothertochild.entity.Order;
import com.example.mothertochild.entity.OrderItem;
import com.example.mothertochild.entity.Product;
import com.example.mothertochild.entity.User;
import com.example.mothertochild.mapper.OrderItemMapper;
import com.example.mothertochild.mapper.OrderMapper;
import com.example.mothertochild.service.OrderService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int insertOrder(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        int flag = 1;
        int row = orderMapper.insertOrder(order);
        if(row > 0){
            int orderId = order.getOrderId();
            System.out.println("拿到id了吗？" + orderId);
            for(OrderItem ele : orderItems){
                ele.setOrderId(orderId);
               int a = orderItemMapper.insetOrderItem(ele);
               if(a < 1){
                   flag = a;
               }
            }
        }
        return flag;
    }

    @Override
    public int deleteOrder(int orderId) {
        return orderMapper.deleteOrder(orderId);
    }

    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    @Override
    public Order getOrder(int orderId) {
        return orderMapper.getOrder(orderId);
    }

    @Override
    public Page<Order> orderList() {
        Page<Order> orders = orderMapper.orderList();
        for(Order ele : orders){
            int orderId = ele.getOrderId();
            System.out.println("拿到的orderId" + orderId);
            List<OrderItem> orderItems = orderItemMapper.findOrderItemByOrderId(orderId);
            ele.setOrderItems(orderItems);
        }
        return orders;
    }
}
