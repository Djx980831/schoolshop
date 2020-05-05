package com.example.demo.mapper;

import com.example.demo.entity.Order;
import com.example.demo.vo.request.OrderRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Integer addOrder(OrderRequestVO vo);

    List<Order> getOrderByUserId(Integer userId);

    Integer updateOrderById(Integer userId, Integer flag);
}
