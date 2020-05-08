package com.example.mothertochild.service;

import com.example.mothertochild.entity.Order;
import com.example.mothertochild.entity.Product;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
//    String waitPay = "waitPay";
//    String waitDelivery = "waitDelivery";
//    String waitConfirm = "waitConfirm";
//    String waitReview = "waitReview";
//    String finish = "finish";
//    String delete = "delete";

    int insertOrder(Order order);
//    int insertOrder(Date createDate,String receiver,String mobile);

    int deleteOrder(int id);

    int updateOrder(Order order);

    Order getOrder(int id);

    Page<Order> orderList();

    List<Order> getUserOrder(int userId);
}

