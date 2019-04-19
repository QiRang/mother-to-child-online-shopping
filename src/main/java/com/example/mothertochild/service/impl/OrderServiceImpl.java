//package com.example.mothertochild.service.impl;
//
//import com.example.mothertochild.entity.Order;
//import com.example.mothertochild.entity.User;
//import com.example.mothertochild.mapper.OrderMapper;
//import com.example.mothertochild.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderServiceImpl implements OrderService {
//    @Autowired
//    private OrderMapper orderMapper;
//    @Override
//    public int addOrder(Order order) {
//        return 0;
//    }
//
//    @Override
//    public int deleteOrder(int id) {
//        return 0;
//    }
//
//    @Override
//    public int updateOrder(Order order) {
//        return 0;
//    }
//
//    @Override
//    public Order getOrder(int id) {
//        return null;
//    }
//
//    @Override
//    public List orderList() {
//        return null;
//    }
//    public void setUser(List<Order> orders) {
//        for (Order order : orders) {
//            setUser(order);
//        }
//    }
//
//    public void setUser(Order order) {
//        int userId = order.getUserId();
////        User user = userService.getUser(userId);
////        order.setUser(user);
//    }
//}
