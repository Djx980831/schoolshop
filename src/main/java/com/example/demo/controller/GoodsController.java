package com.example.demo.controller;

import com.example.demo.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    private PicService service;

    @RequestMapping("/savePic")
    @ResponseBody
    public String savePic(Integer userId, MultipartFile[] files) {
        return service.savePic(userId, files);
    }
}
