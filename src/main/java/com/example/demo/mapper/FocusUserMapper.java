package com.example.demo.mapper;

import com.example.demo.vo.request.FocusUserRequestVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FocusUserMapper {
    List<Integer> getFocueUserIdByUserId(Integer userId);

    Integer addFocueUser(FocusUserRequestVO vo);

    void deleteFocusUserById(FocusUserRequestVO vo);

    Integer getFocusUserCountByUserId(Integer userId);

    Integer getFensiCountByUserId(Integer userId);
}
