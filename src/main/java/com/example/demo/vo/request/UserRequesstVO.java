package com.example.demo.vo.request;

import lombok.Data;

/**
 * @param
 * @Description
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-11 22:31
 */
@Data
public class UserRequesstVO {
    private Integer id;
    private String userName;
    private String year;
    private String dept;
    private String major;
    private String password;
}
