package com.example.demo.controller;

import com.example.demo.service.GoodsService;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import com.example.demo.vo.response.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.example.demo.constant.ErrorConsant.*;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-18 23:00
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService service;

    @RequestMapping("/addGoods")
    @ResponseBody
    public RpcResponse<Integer> addGoods(Integer userId, String title, String comment, MultipartFile[] files) {
        if (!ParamUtil.checkNumbers(userId)) {
            return RpcResponse.error(GOODS_USERID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(title)) {
            return RpcResponse.error(GOODS_TITLE_IS_EMPTY);
        }
        if (!ParamUtil.checkString(comment)) {
            return RpcResponse.error(GOODS_COMMENT_IS_EMPTY);
        }
        if (files.length == 0) {
            return RpcResponse.error(GOODS_PIC_IS_EMPTY);
        }

        service.savePic(userId, files);
        Integer id = service.saveGoods(userId, title, comment);

        return RpcResponse.success(id);
    }

    @PostMapping("/getGoodsByLikeTitle")
    public RpcResponse<List<GoodsVO>> getGoodsByLikeTitle(String title) {
        if (!ParamUtil.checkString(title)) {
            return RpcResponse.error(GOODS_TITLE_IS_EMPTY);
        }

        return RpcResponse.success(service.getGoodsByLikeTitle(title));
    }


}
