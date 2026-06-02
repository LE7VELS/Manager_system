package com.vsbt.vsbtbackend.pojo;

import lombok.Data;
import java.io.Serializable;

/**
 * 后端统一返回结果类
 * 用于封装API接口的返回数据，包含状态码、消息和数据
 */
@Data
public class Result {

    private Integer code; //编码：1成功，0为失败
    private String msg; //错误信息
    private Object data; //数据

    /**
     * 返回成功结果（无数据）
     * @return 成功的Result对象
     */
    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    /**
     * 返回成功结果（带数据）
     * @param object 要返回的数据对象
     * @return 包含数据的成功Result对象
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    /**
     * 返回失败结果
     * @param msg 错误消息
     * @return 失败的Result对象
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}