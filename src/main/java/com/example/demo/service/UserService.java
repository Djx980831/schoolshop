package com.example.demo.service;


import com.example.demo.entity.User;

public interface UserService {

    Integer addUser(String userName, String year, String dept, String major,  String password);

    User login(String userName, String password);

    Integer updateUserInfoById(Integer id, String userName, String year, String dept, String major);

    Integer updatePasswordById(Integer id, String password);

    User getUserInfoById(Integer id);
}
