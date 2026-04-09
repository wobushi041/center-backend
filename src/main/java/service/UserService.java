package service;


import org.wobushi041.centerbackend.model.enity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author 硫酸铜
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2026-04-03 14:41:22
*/

public interface UserService extends IService<User> {

    String USER_LOGIN_STATE = "userLoginState";


    /**
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 是否校验密码
     * @return
     */
    Long userRegister(String userAccount, String userPassword, String checkPassword);


    /**
     *
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     *
     * @param request
     * @return
     */
    int userlogout(HttpServletRequest request);


    /**
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 获取当前登录用户
     * @param currentUser
     * @return
     */
    User getCurrentUser(User currentUser);




}