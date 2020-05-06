package com.example.demo.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-06 10:44
 */
@Data
public class OrdersVO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Double money;
    private String title;
    private String comment;
    private Integer flag;
    private List<String> pathList;
}
