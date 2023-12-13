package com.mylsaber.console.core.config;

import com.mylsaber.common.exception.BaseException;
import com.mylsaber.common.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public CommonResult<String> processBusinessException(BaseException baseException) {
        log.error(baseException.getMessage(), baseException);
        return CommonResult.<String>builder().code(400).message(baseException.getMessage()).build();
    }
}
