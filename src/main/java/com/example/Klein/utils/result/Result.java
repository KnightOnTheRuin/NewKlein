package com.example.Klein.utils.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    // 200是正常情况，非200表示异常
    //300表示平台管理员登录成功
    //201表示酒店管理员登录成功
    // 400通用错误
    // 401缺乏对应权限
    // 402登陆状态错误
    // 403验证错误
    // 404没有获取到的信息

    private int code;

    private String msg;

    private Object data;

    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }

    public static Result success(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}