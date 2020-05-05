package com.example.demo.service.impl;

import com.example.demo.entity.Collectioner;
import com.example.demo.mapper.CollectionMapper;
import com.example.demo.service.CollectionService;
import com.example.demo.service.GoodsService;
import com.example.demo.vo.request.CollectionRequestVO;
import com.example.demo.vo.response.CollectionVO;
import com.example.demo.vo.response.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper mapper;

    @Autowired
    private GoodsService goodsService;

    @Override
    public Integer addCollection(Integer userId, Integer goodsId,  String title, String comment, Double money) {
        CollectionRequestVO vo = new CollectionRequestVO();
        vo.setGoodsId(goodsId);
        vo.setUserId(userId);
        vo.setComment(comment);
        vo.setMoney(money);
        vo.setTitle(title);

        Integer id = mapper.addCollection(vo);
        return id;
    }

    @Override
    public Integer deleteCollectionById(Integer id) {
        return mapper.deleteCollectionById(id);
    }

    @Override
    public List<CollectionVO> getCollectionByUserId(Integer userId) {
        List<Collectioner> collectionerList =  mapper.getCollectionByUserId(userId);
        if (collectionerList == null) {
            return null;
        }
        List<CollectionVO> collectionVOList = new ArrayList<>();

        for (Collectioner collectioner : collectionerList) {
            CollectionVO vo = new CollectionVO();
            GoodsVO goodsVO = goodsService.getGoodsInfoById(collectioner.getGoodsId());
            vo.setId(collectioner.getId());
            vo.setGoodsId(collectioner.getGoodsId());
            vo.setUserId(collectioner.getUserId());
            vo.setTitle(collectioner.getTitle());
            vo.setComment(collectioner.getComment());
            vo.setMoney(collectioner.getMoney());
            vo.setPathList(goodsVO.getPathList());

            collectionVOList.add(vo);
        }

        return collectionVOList;
    }

    @Override
    public Integer getCollectionCountByUserId(Integer userId) {
        return mapper.getCollectionCountByUserId(userId);
    }
}
