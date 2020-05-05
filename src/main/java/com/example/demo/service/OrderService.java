package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderService {

    Integer addOrder(Integer userId, Integer goodsId, Double money, String title, String comment);

    List<Order> getOrderByUserId(Integer userId);

    Integer updateOrderById(Integer userId, Integer flag);
}
