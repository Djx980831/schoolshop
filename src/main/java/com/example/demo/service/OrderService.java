package com.example.demo.service;

import com.example.demo.entity.Orders;

import java.util.List;

public interface OrderService {

    Integer addOrder(Integer userId, Integer goodsId, Double money, String title, String comment);

    List<Orders> getOrderByUserId(Integer userId);

    Integer updateOrderById(Integer id, Integer flag);
}
