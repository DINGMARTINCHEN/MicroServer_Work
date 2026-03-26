package com.dingshicheng23090200150.cloud.exp;

import com.dingshicheng23090200150.cloud.resp.ResultData;
import com.dingshicheng23090200150.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice // 全局捕获@RestController的异常
public class GlobalExceptionHandler {

    // 处理运行时异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleRuntimeException(RuntimeException e) {
        log.error("运行时异常:{}", e.getMessage(), e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }

    // 处理所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleException(Exception e) {
        log.error("系统异常:{}", e.getMessage(), e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "系统异常,请联系管理员");
    }
}