package com.example.demo.service.impl;

import com.example.demo.mapper.FocusUserMapper;
import com.example.demo.service.FocusUserService;
import com.example.demo.vo.request.FocusUserRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-04-20 23:14
 */
@Service
public class FocusUserServiceImpl implements FocusUserService {

    @Autowired
    private FocusUserMapper mapper;

    @Override
    public List<Integer> getFocueUserIdByUserId(Integer userId) {

        return mapper.getFocueUserIdByUserId(userId);
    }

    @Override
    public Integer addFocueUser(Integer userId, Integer focusUserId) {
        FocusUserRequestVO vo = new FocusUserRequestVO();
        vo.setUserId(userId);
        vo.setFocusUserId(focusUserId);

        mapper.addFocueUser(vo);

        return vo.getId();
    }

    @Override
    public Integer deleteFocusUserById(Integer id) {
        FocusUserRequestVO vo = new FocusUserRequestVO();
        vo.setUserId(id);

        mapper.deleteFocusUserById(vo);
        return id;
    }

    @Override
    public Integer getFocusUserCountByUserId(Integer userId) {
        return mapper.getFocusUserCountByUserId(userId);
    }

    @Override
    public Integer getFensiCountByUserId(Integer userId) {
        return mapper.getFensiCountByUserId(userId);
    }
}
