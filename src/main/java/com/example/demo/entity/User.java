package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String year;
    private String dept;
    private String major;
    private String password;
}
