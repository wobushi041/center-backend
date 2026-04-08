package org.wobushi041.centerbackend.common;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;


/**
 * 通用返回类
 * @param <T>
 * @auther 041
 */
@Data
@Slf4j
public class BaseResponse<T> implements Serializable {
    private int code;
    private T data;
    private String message;
    private String description;

//    传4
    public BaseResponse(int code, T data, String message,String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description= description;
    }

//    传3
    public BaseResponse(int code, T data ,String message) {
//        this.code = code;
//        this.data = data;
//        this.message="";
        this(code, data,message,"");
    }

//    传2
    public BaseResponse(int code, T data ) {
        this(code, data,"","");

    }

//    传errorcode
    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription());
    }
}
