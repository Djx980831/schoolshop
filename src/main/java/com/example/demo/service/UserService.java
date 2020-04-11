package com.example.demo.service;


import com.example.demo.entity.User;

public interface UserService {

    Integer addUser(String userName, String year, String dept, String major, String mobile, String password);

    User login(String userNameOrMobile, String password);

    Integer getIdByMobile(String mobile);

    Integer updateUserInfoById(Integer id, String userName, String year, String dept, String major, String mobile);

    Integer updatePasswordById(Integer id, String password);
}
