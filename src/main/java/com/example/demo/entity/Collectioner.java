package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-04 23:43
 */
@Data
public class Collectioner {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String title;
    private String comment;
    private Double money;
}
