package com.example.demo.mapper;

import com.example.demo.entity.Collectioner;
import com.example.demo.vo.request.CollectionRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionMapper {

    Integer addCollection(CollectionRequestVO vo);

    Integer deleteCollectionById(Integer id);

    List<Collectioner> getCollectionByUserId(Integer userId);

    Integer getCollectionCountByUserId(Integer userId);
}
