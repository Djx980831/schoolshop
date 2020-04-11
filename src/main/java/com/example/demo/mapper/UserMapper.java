package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.vo.request.UserRequesstVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    Integer addUser(UserRequesstVO vo);

    User login(String userNameOrMobile, String password);

    Integer getIdByMobile(String mobile);

    Integer updateUserInfoById(UserRequesstVO vo);

    Integer updatePasswordById(UserRequesstVO vo);
}
