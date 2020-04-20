package com.example.demo.constant;

import com.example.demo.util.ErrorInfo;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2020-03-17 23:22
 */
public class ErrorConsant {
    private ErrorConsant(){};

    public static final Integer SUCCESS_CODE = 0;


    /*
    user错误代码
     */
    public static final ErrorInfo PARAM_NOT_ENOUGH = new ErrorInfo(100, "缺少参数");

    public static final ErrorInfo PARAM_ERROR = new ErrorInfo(101, "参数错误");

    public static final ErrorInfo USERNAME_OR_PASSWORD_IS_EMPTY = new ErrorInfo(102, "用户名或密码为空");

    public static final ErrorInfo USERNAME_OR_PASSWORD_IS_ERROR = new ErrorInfo(103, "用户名或密码不正确");

    public static final ErrorInfo ID_IS_EMPTY = new ErrorInfo(104, "id不可为空");

    public static final ErrorInfo USER_NOT_EXIST = new ErrorInfo(105, "用户不存在");

    public static final ErrorInfo PASSWORD_EMPTY = new ErrorInfo(106, "密码不可为空");

    /*
    goods错误代码
     */
    public static final ErrorInfo GOODS_USERID_IS_EMPTY = new ErrorInfo(201, "用户id为空");

    public static final ErrorInfo GOODS_TITLE_IS_EMPTY = new ErrorInfo(202, "标题为空");

    public static final ErrorInfo GOODS_COMMENT_IS_EMPTY = new ErrorInfo(203, "描述为空");

    public static final ErrorInfo GOODS_PIC_IS_EMPTY = new ErrorInfo(204, "选择图片为空");
}
