package com.example.demo.service;

import com.example.demo.entity.Goods;
import com.example.demo.vo.response.GoodsVO;
import com.example.demo.vo.response.MainVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsService {

    String savePic(Integer goodsId, Integer userId, MultipartFile[] files);

    Integer saveGoods(Integer userId, String title, String comment, Double money);

    List<GoodsVO> getGoodsByLikeTitle(String title);

    List<GoodsVO> getFocusUserGoodsByUserId(Integer userId);

    GoodsVO getGoodsInfoById(Integer id);

    MainVO getMainInfoByUserId(Integer userId);

    List<GoodsVO> getXiaJiaGoodsByUserId(Integer userId);

    List<GoodsVO> getGoodsByUserId(Integer userId);

    Integer deleteGoodsById(Integer id);
}
