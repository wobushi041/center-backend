package service;


import org.wobushi041.centerbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author 硫酸铜
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2026-04-03 14:41:22
*/

public interface UserService extends IService<User> {


    /**
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 是否校验密码
     * @return
     */
    Long userRegister(String userAccount, String userPassword, String checkPassword);


    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

}