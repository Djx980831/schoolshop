package com.example.demo.mapper;

import com.example.demo.entity.Orders;
import com.example.demo.vo.request.OrderRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Integer addOrder(OrderRequestVO vo);

    List<Orders> getOrderByUserId(Integer userId);

    Integer updateOrderById(Integer id, Integer flag);
}
