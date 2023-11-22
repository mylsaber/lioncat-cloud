package com.mylsaber.common.pojo;

import java.io.Serial;
import java.io.Serializable;

public class CommonResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public final static Integer SUCCESS = 200;
    public final static Integer ERROR = 500;

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public CommonResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonResult<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public static <T> CommonResult<T> getSuccess(T data) {
        return new CommonResult<>(SUCCESS, "操作成功", data);
    }

    public static <T> CommonResult<T> getFail(T data) {
        return new CommonResult<>(ERROR, "服务器异常", data);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
