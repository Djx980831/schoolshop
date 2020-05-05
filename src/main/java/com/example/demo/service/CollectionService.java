package com.example.demo.service;

import com.example.demo.vo.response.CollectionVO;

import java.util.List;

public interface CollectionService {

    Integer addCollection(Integer userId, Integer goodsId, String title, String comment, Double money);

    Integer deleteCollectionById(Integer id);

    List<CollectionVO> getCollectionByUserId(Integer userId);

    Integer getCollectionCountByUserId(Integer userId);
}
