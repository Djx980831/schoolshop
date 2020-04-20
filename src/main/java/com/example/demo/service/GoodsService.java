package com.example.demo.service;

import com.example.demo.vo.response.GoodsVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsService {

    String savePic(Integer userId, MultipartFile[] files);

    Integer saveGoods(Integer userId, String title, String comment);

    List<GoodsVO> getGoodsByLikeTitle(String title);

    List<GoodsVO> getFocusUserGoodsByUserId(Integer userId);
}
