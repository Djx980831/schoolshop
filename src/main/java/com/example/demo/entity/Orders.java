package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-05 11:34
 */
@Data
public class Orders {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Double money;
    private String title;
    private String comment;
    private Integer flag;
}
