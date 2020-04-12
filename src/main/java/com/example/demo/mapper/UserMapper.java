package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.vo.request.UserRequesstVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Integer addUser(UserRequesstVO vo);

    User login(String userNameOrMobile, String password);

    Integer updateUserInfoById(UserRequesstVO vo);

    Integer updatePasswordById(UserRequesstVO vo);

    User getUserInfoById(Integer id);
}
