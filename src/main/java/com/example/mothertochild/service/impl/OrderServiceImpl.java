package com.example.mothertochild.service.impl;

import com.example.mothertochild.entity.Order;
import com.example.mothertochild.entity.User;
import com.example.mothertochild.mapper.OrderMapper;
import com.example.mothertochild.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }


//    @Override
//    public int insertOrder(Date createDate, String receiver, String mobile) {
//        System.out.println("serviceImpl" + createDate + receiver + mobile);
//        return orderMapper.insertOrder(createDate, receiver, mobile);
//    }

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
    public List orderList() {
        return orderMapper.orderList();
    }
}
