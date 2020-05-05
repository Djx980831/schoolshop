package com.example.demo.service.impl;

import com.example.demo.entity.Collectioner;
import com.example.demo.mapper.CollectionMapper;
import com.example.demo.service.CollectionService;
import com.example.demo.vo.request.CollectionRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper mapper;

    @Override
    public Integer addCollection(Integer userId, Integer goodsId) {
        CollectionRequestVO vo = new CollectionRequestVO();
        vo.setGoodsId(goodsId);
        vo.setUserId(userId);

        Integer id = mapper.addCollection(vo);
        return id;
    }

    @Override
    public Integer deleteCollectionById(Integer id) {
        return mapper.deleteCollectionById(id);
    }

    @Override
    public List<Collectioner> getCollectionByUserId(Integer userId) {
        return mapper.getCollectionByUserId(userId);
    }

    @Override
    public Integer getCollectionCountByUserId(Integer userId) {
        return mapper.getCollectionCountByUserId(userId);
    }
}
