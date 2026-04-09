package org.wobushi041.centerbackend.constant;


/**
 * 一定要用接口类型
 * class不行
 */
public interface UserConstant {
    /**
     * 用户登录状态
     */
     String USER_LOGIN_STATE = "userLoginState";

    /**
     * role
     */
    int DEFAULT_ROLE = 0;
     int ADMIN_ROLE = 1;

    /**
     * 密码盐值
     */
    String SALT = "041";
}
