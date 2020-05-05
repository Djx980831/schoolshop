package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-05 12:05
 */
@Data
public class OrderRequestVO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Double money;
    private String title;
    private String comment;
    private Integer flag;
}
