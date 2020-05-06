package com.example.demo.service.impl;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import com.example.demo.vo.request.OrderRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-05 12:19
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper mapper;

    @Override
    public Integer addOrder(Integer userId, Integer goodsId, Double money, String title, String comment) {
        OrderRequestVO vo = new OrderRequestVO();
        vo.setUserId(userId);
        vo.setGoodsId(goodsId);
        vo.setMoney(money);
        vo.setTitle(title);
        vo.setComment(comment);

        Integer id = mapper.addOrder(vo);
        return id;
    }

    @Override
    public List<Orders> getOrderByUserId(Integer userId) {
        return mapper.getOrderByUserId(userId);
    }

    @Override
    public Integer updateOrderById(Integer id, Integer flag) {
        return mapper.updateOrderById(id, flag);
    }
}
