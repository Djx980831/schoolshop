package com.example.demo.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-06 00:05
 */
@Data
public class CollectionVO {

    private Integer id;
    private Integer goodsId;
    private Integer userId;

    private String comment;
    private String title;
    private Double money;
    private List<String> pathList;
}
