package com.example.demo.vo.response;

import lombok.Data;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-19 23:35
 */
@Data
public class GoodsVO {
    private Integer id;
    private Integer userId;
    private String title;
    private String comment;
    private List<String> pathList;
}
