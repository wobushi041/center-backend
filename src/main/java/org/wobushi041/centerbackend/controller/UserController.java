package org.wobushi041.centerbackend.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.wobushi041.centerbackend.common.BaseResponse;
import org.wobushi041.centerbackend.common.ErrorCode;
import org.wobushi041.centerbackend.common.ResultUtils;
import org.wobushi041.centerbackend.exception.BusinessException;
import org.wobushi041.centerbackend.model.domain.User;
import org.wobushi041.centerbackend.model.domain.request.UserLoginRequest;
import org.wobushi041.centerbackend.model.domain.request.UserRegisterRequest;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 041
 *
 */




@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;


    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if(userRegisterRequest==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode)){
            return null;
        }
        Long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }


    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest,HttpServletRequest request){
        if(userLoginRequest==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)){
            return null;
        }
        User user = userService.userLogin(userAccount,userPassword,request);
        return ResultUtils.success(user);
    }

}
