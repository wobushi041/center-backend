package org.wobushi041.centerbackend.exception;

import org.wobushi041.centerbackend.common.ErrorCode;

public class BusinessException extends RuntimeException{
    private final int code;
    private final String description;

//    自定义
    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;

    }


    public BusinessException(ErrorCode errorCode,String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description =description;

    }

//    errorcode传参
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();

    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
