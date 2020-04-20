package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-19 23:17
 */
@Data
public class GoodsRequestVO {
    private Integer id;
    private Integer userId;
    private String title;
    private String comment;
}
