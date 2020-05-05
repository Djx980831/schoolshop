package com.example.demo.controller;

import com.example.demo.entity.Collectioner;
import com.example.demo.service.CollectionService;
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
 * @Date 2020-05-05 15:09
 */
@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService service;

    @PostMapping("/addCollection")
    public RpcResponse<Integer> addCollection(Integer userId, Integer goodsId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }
        if (!ParamUtil.checkNumbers(goodsId)) {
            return RpcResponse.error(GOODS_GOODSID_IS_EMPTY);
        }

        return RpcResponse.success(service.addCollection(userId, goodsId));
    }

    @PostMapping("/deleteCollectionById")
    public RpcResponse<Integer> deleteCollectionById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(COLLECTION_COLLECTIONID_IS_EMPTY);
        }

        return RpcResponse.success(service.deleteCollectionById(id));
    }

    @PostMapping("/getCollectionByUserId")
    public RpcResponse<List<Collectioner>> getCollectionByUserId(Integer userId) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }

        return RpcResponse.success(service.getCollectionByUserId(userId));
    }
}
