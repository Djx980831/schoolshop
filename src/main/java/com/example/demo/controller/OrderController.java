package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.constant.ErrorConsant.*;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-05 15:38
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/addOrder")
    public RpcResponse<Integer> addOrder(Integer userId, Integer goodsId, Double money, String title, String comment) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }
        if (!ParamUtil.checkNumbers(goodsId)) {
            return RpcResponse.error(GOODS_GOODSID_IS_EMPTY);
        }
        if (!ParamUtil.checkDouble(money)) {
            return RpcResponse.error(ORDER_MONEY_IS_EMPTY);
        }
        if (!ParamUtil.checkString(title)) {
            return RpcResponse.error(GOODS_TITLE_IS_EMPTY);
        }
        if (!ParamUtil.checkString(comment)) {
            return RpcResponse.error(GOODS_COMMENT_IS_EMPTY);
        }

        return RpcResponse.success(service.addOrder(userId, goodsId, money, title, comment));
    }

    @PostMapping("/getOrderByUserId")
    public RpcResponse<List<Order>> getOrderByUserId(Integer userId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }

        return RpcResponse.success(service.getOrderByUserId(userId));
    }

    @PostMapping("/updateOrderById")
    public RpcResponse<Integer> updateOrderById(Integer userId, Integer flag) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }

        return RpcResponse.success(service.updateOrderById(userId, flag));
    }
}
