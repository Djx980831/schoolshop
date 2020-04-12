package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.util.ParamUtil;
import com.example.demo.util.RpcResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import static com.example.demo.constant.ErrorConsant.*;

@Api(tags = "用户接口", value = "实现用户的相关操作")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public RpcResponse<Integer> addUser(String userName, String year, String dept, String major, String password) {
        if (!ParamUtil.checkString(userName, year, dept, major, password)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }

        return RpcResponse.success(service.addUser(userName, year, dept, major, password));
    }

    @PostMapping("/login")
    public RpcResponse<User> login(String userName, String password, HttpSession session) {
        if (!ParamUtil.checkString(userName, password)) {
            return RpcResponse.error(USERNAME_OR_PASSWORD_IS_EMPTY);
        }
        User user = service.login(userName, password);
        if (user == null) {
            return RpcResponse.error(USERNAME_OR_PASSWORD_IS_ERROR);
        }
        session.setAttribute("user", user);
        Cookie id = new Cookie("id", user.getId().toString());
        return RpcResponse.success(user);
    }

    @PostMapping("/getUserInfoById")
    public RpcResponse<User> getUserInfoById(Integer id) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(ID_IS_EMPTY);
        }

        User user = service.getUserInfoById(id);
        if (user == null) {
            return RpcResponse.error(USER_NOT_EXIST);
        }

        return RpcResponse.success(user);
    }

    @PostMapping("/updateUserInfoById")
    public RpcResponse<Integer> updateUserInfoById(Integer id, String userName, String year, String dept, String major) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(ID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(userName, year, dept, major)) {
            return RpcResponse.error(PARAM_NOT_ENOUGH);
        }

        return RpcResponse.success(service.updateUserInfoById(id, userName, year, dept, major));
    }

    @PostMapping("/updatePasswordById")
    public RpcResponse<Integer> updatePasswordById(Integer id, String password) {
        if (!ParamUtil.checkNumbers(id)) {
            return RpcResponse.error(ID_IS_EMPTY);
        }
        if (!ParamUtil.checkString(password)) {
            return RpcResponse.error(PASSWORD_EMPTY);
        }

        return RpcResponse.success(service.updatePasswordById(id, password));
    }
}
