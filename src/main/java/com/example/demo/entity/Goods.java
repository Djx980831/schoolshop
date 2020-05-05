package com.example.demo.entity;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-13 23:18
 */
@Data
public class Goods {
    Integer id;
    Integer userId;
    String title;
    String comment;
    Double money;
}
