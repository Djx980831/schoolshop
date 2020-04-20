package com.example.demo.mapper;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Pic;
import com.example.demo.vo.request.GoodsRequestVO;
import com.example.demo.vo.request.PicRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    Integer savePic(PicRequestVO vo);

    Integer saveGoods(GoodsRequestVO vo);

    List<Goods> getGoodsByLikeTitle(String title);

    List<Pic> getPicByIds(List<Integer> userIds);

    List<Goods> getFocusUserGoodsByUserId(List<Integer> userIds);
}
