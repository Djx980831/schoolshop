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
    private ErrorConsant() {
    }

    ;

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

    public static final ErrorInfo GOODS_GOODSID_IS_EMPTY = new ErrorInfo(205, "商品ID为空");

    /*
    collection错误代码
     */

    public static final ErrorInfo COLLECTION_COLLECTIONID_IS_EMPTY = new ErrorInfo(301, "收藏id为空");


    /*

     */

    public static final ErrorInfo FOCUS_FOCUSUSERID_IS_EMPTY = new ErrorInfo(401, "被收藏者id不可为空");

    public static final ErrorInfo FOCUS_FOCUSID_IS_EMPTY = new ErrorInfo(402, "收藏id不可为空");

     /*
    留言板错误代码
     */

    public static final ErrorInfo COMMENT_IS_EMPTY = new ErrorInfo(501, "留言内容不可为空");

    public static final ErrorInfo COMMENT_ID_IS_EMPTY = new ErrorInfo(502, "留言id不可为空");

    public static final ErrorInfo COMMENT_LIMIT_NOT_ENOUGH = new ErrorInfo(503, "缺少分页参数");

    public static final ErrorInfo COMMENT_IS_NOT_EXIST = new ErrorInfo(504, "该留言不存在");

    public static final ErrorInfo COMMENT_IS_ALL_EMPTY = new ErrorInfo(504, "没有任何留言");

    public static final ErrorInfo COMMENT_QUANXIAN_ERROR = new ErrorInfo(505, "没有权限进行删除操作");

    /*
    order错误代码
     */

    public static final ErrorInfo ORDER_MONEY_IS_EMPTY = new ErrorInfo(601, "价格为空");

    public static final ErrorInfo ORDER_ID_IS_EMPTY = new ErrorInfo(602, "id为空");

    /*
    回复错误代码
     */

    public static final ErrorInfo REPLY_COMMENTID_IS_EMPTY = new ErrorInfo(701, "缺少评论id");

    public static final ErrorInfo REPLY_REPLYID_IS_EMPTY = new ErrorInfo(702, "缺少回复id");

    public static final ErrorInfo REPLY_REPLY_IS_EMPTY = new ErrorInfo(703, "缺少回复内容");

    public static final ErrorInfo REPLY_REPLYUSERNAME_IS_EMPTY = new ErrorInfo(704, "缺少回复用户名");

    public static final ErrorInfo REPLY_LIMIT_IS_EMPTY = new ErrorInfo(705, "缺少分页信息");

    public static final ErrorInfo REPLY_QUANXIAN_ERROR = new ErrorInfo(706, "没有权限进行删除操作");
}
