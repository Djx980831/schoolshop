package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.vo.request.UserRequesstVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Integer addUser(String userName, String year, String dept, String major, String password) {
        UserRequesstVO vo = new UserRequesstVO();
        vo.setUserName(userName);
        vo.setYear(year);
        vo.setDept(dept);
        vo.setMajor(major);
        vo.setPassword(password);

        userMapper.addUser(vo);

        return vo.getId();
    }

    @Override
    public User login(String userName, String password) {

        User user = userMapper.login(userName, password);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public Integer updateUserInfoById(Integer id, String userName, String year, String dept, String major) {
        UserRequesstVO vo = new UserRequesstVO();
        vo.setUserName(userName);
        vo.setYear(year);
        vo.setDept(dept);
        vo.setMajor(major);
        vo.setId(id);

        userMapper.updateUserInfoById(vo);
        return id;
    }

    @Override
    public Integer updatePasswordById(Integer id, String password) {
        UserRequesstVO vo = new UserRequesstVO();
        vo.setId(id);
        vo.setPassword(password);

        userMapper.updatePasswordById(vo);
        return id;
    }

    @Override
    public User getUserInfoById(Integer id) {
        return userMapper.getUserInfoById(id);
    }
}
