package com.mylsaber.common.pojo;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author jiangdi
 */
@Getter
public record CommonResult<T>(Integer code, String message, T data) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public final static Integer SUCCESS = 200;
    public final static Integer ERROR = 500;

    public static <T> CommonResult<T> fastSuccess(T data) {
        return new CommonResult<>(SUCCESS, "操作成功", data);
    }

    public static <T> CommonResult<T> fastFail(T data) {
        return new CommonResult<>(ERROR, "服务器异常", data);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private Integer code = SUCCESS;
        private String message = "操作成功";
        private T data;

        public Builder() {
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public CommonResult<T> build() {
            return new CommonResult<>(code, message, data);
        }
    }

}
