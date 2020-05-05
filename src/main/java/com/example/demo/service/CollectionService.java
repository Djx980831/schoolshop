package com.example.demo.service;

import com.example.demo.entity.Collectioner;

import java.util.List;

public interface CollectionService {

    Integer addCollection(Integer userId, Integer goodsId);

    Integer deleteCollectionById(Integer id);

    List<Collectioner> getCollectionByUserId(Integer userId);

    Integer getCollectionCountByUserId(Integer userId);
}
