package com.mylsaber.common.exception;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jiangdi
 */
@Getter
@Setter
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;

    public BaseException() {
        super("服务器异常");
        this.code = 500;
        this.message = "服务器异常";
    }

    public BaseException(String message, Object... args) {
        super();
        this.message = StrUtil.format(message, args);
    }

    public BaseException(Integer code, String message, Object... args) {
        super(StrUtil.format(message, args));
        this.message = StrUtil.format(message, args);
        this.code = code;

    }
}
