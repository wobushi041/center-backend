package org.wobushi041.centerbackend.common;




/**
 * 错误码枚举类
 * @author 041
 */

//因为是错误码，所以无data
public enum ErrorCode {
    SUCCESS(0, "success", ""),
    PARAMS_ERROR(4000, "请求参数错误", ""),
    NULL_ERROR(4001, "请求参数为空", ""),
    NO_LOGIN(40100, "未登录", ""),
    NO_AUTHORITY(40101, "无权限", ""),
    SYSTEM_ERROR(50000, "系统内部异常", "");



    private final int code;
    private final String message;
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }
}
