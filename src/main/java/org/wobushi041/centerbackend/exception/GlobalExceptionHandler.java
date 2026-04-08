package org.wobushi041.centerbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wobushi041.centerbackend.common.BaseResponse;
import org.wobushi041.centerbackend.common.ErrorCode;
import org.wobushi041.centerbackend.common.ResultUtils;


/**
 *  - 统一把异常转换成 BaseResponse
 *   - BusinessException 返回业务错误
 *   - 其他未知异常返回系统错误
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
        @ExceptionHandler(value = BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("runtimeException", e);
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(Exception e) {
        log.error("runtimeException",e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),"");
    }
}


/**
 * 踩过坑
 * return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
 * return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),"");
 */
