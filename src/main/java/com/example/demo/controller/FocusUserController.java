package com.example.demo.controller;

import com.example.demo.service.FocusUserService;
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
 * @Date 2020-05-05 15:22
 */
@RestController
@RequestMapping("/focusUser")
public class FocusUserController {

    @Autowired
    private FocusUserService service;

    @PostMapping("/getFocueUserIdByUserId")
    public RpcResponse<List<Integer>> getFocueUserIdByUserId(Integer userId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }

        return RpcResponse.success(service.getFocueUserIdByUserId(userId));
    }

    @PostMapping("/addFocueUser")
    public RpcResponse<Integer> addFocueUser(Integer userId, Integer focusUserId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }
        if (!ParamUtil.checkNumbers(focusUserId)) {
            return RpcResponse.error(FOCUS_FOCUSUSERID_IS_EMPTY);
        }

        return RpcResponse.success(service.addFocueUser(userId, focusUserId));
    }

    @PostMapping("/deleteFocusUserById")
    public RpcResponse<Integer> deleteFocusUserById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(FOCUS_FOCUSID_IS_EMPTY);
        }

        return RpcResponse.success(service.deleteFocusUserById(id));
    }

    @PostMapping("/getFocusUserCountByUserId")
    public RpcResponse<Integer> getFocusUserCountByUserId(Integer userId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }

        return RpcResponse.success(service.getFocusUserCountByUserId(userId));
    }

    @PostMapping("/getFensiCountByUserId")
    public RpcResponse<Integer> getFensiCountByUserId(Integer userId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }

        return RpcResponse.success(service.getFensiCountByUserId(userId));
    }
}
