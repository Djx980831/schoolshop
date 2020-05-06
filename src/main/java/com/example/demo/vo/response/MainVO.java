package com.example.demo.vo.response;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Orders;
import lombok.Data;

import java.util.List;


/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-05-05 11:30
 */
@Data
public class MainVO {

    private Integer focue;
    private Integer fenSi;
    private Integer collection;

    private List<GoodsVO> GoodsList;
    private List<GoodsVO> xiaJiaGoodsList;
    private List<OrdersVO> orderList;
}
