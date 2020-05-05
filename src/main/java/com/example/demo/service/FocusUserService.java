package com.example.demo.service;

import java.util.List;

public interface FocusUserService {

    List<Integer> getFocueUserIdByUserId(Integer userId);

    Integer addFocueUser(Integer userId, Integer focusUserId);

    Integer deleteFocusUserById(Integer id);

    Integer getFocusUserCountByUserId(Integer userId);

    Integer getFensiCountByUserId(Integer userId);
}
