package org.wobushi041.centerbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.wobushi041.centerbackend.common.BaseResponse;
import org.wobushi041.centerbackend.common.ErrorCode;
import org.wobushi041.centerbackend.common.ResultUtils;
import org.wobushi041.centerbackend.exception.BusinessException;
import org.wobushi041.centerbackend.model.enity.User;
import org.wobushi041.centerbackend.model.request.UserLoginRequest;
import org.wobushi041.centerbackend.model.request.UserRegisterRequest;
import org.wobushi041.centerbackend.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.wobushi041.centerbackend.constant.UserConstant.ADMIN_ROLE;
import static org.wobushi041.centerbackend.service.UserService.USER_LOGIN_STATE;

/**
 * 用户控制器
 * 提供用户注册、登录、注销、查询和删除等功能
 * @author 041
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 用户服务接口
     * 用于处理用户相关的业务逻辑
     */
    @Resource
    private UserService userService;


    /**
     * 用户注册
     * @param userRegisterRequest 用户注册请求，包含账号、密码、确认密码和星球编号
     * @return 注册成功返回用户ID，失败则抛出异常
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        // 检查请求参数是否为空
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 获取注册信息
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        // 检查必要参数是否为空
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }
        // 调用服务层进行用户注册
        Long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }


    /**
     * 用户登录
     * @param userLoginRequest 用户登录请求，包含账号和密码
     * @param request HTTP请求对象，用于会话管理
     * @return 登录成功返回用户信息，失败则抛出异常
     */
    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        // 检查请求参数是否为空
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 获取登录信息
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        // 检查必要参数是否为空
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        // 调用服务层进行用户登录
        User user = userService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);
    }

    /**
     * 用户注销
     * @param request HTTP请求对象，用于会话管理
     * @return 注销成功返回1，表示注销成功
     */
    @PostMapping("/logout")
    public BaseResponse<Integer> userLogout(HttpServletRequest request) {
        return ResultUtils.success(userService.userlogout(request));
    }

    /**
     * 用户查询接口,仅管理员
     * @param username 用户名，用于模糊查询
     * @param request HTTP请求对象，用于权限验证
     * @return 返回查询到的用户列表
     */
    @GetMapping("/search")
    public List<User> searchUser(String username,HttpServletRequest request) {
        //管理员有权利可查询
        Object userObject = request.getSession().getAttribute(USER_LOGIN_STATE);
        if(userObject==null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        User user = (User) userObject;
        if(user.getUserRole()!=ADMIN_ROLE){
            throw new BusinessException(ErrorCode.NO_AUTHORITY, "你不是管理员，无权限");
        }
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("username",username);
        }
        List<User> searchlist = userService.list(queryWrapper);
        return searchlist;
    }


    /**
     * 仅管理员可删除用户
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/delete")
    public  boolean deleteUser(@RequestParam long id,HttpServletRequest request ){
        Object userObject = request.getSession().getAttribute(USER_LOGIN_STATE);
        if(userObject==null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        User user = (User) userObject;
        if(user.getUserRole()!=ADMIN_ROLE){
            throw new BusinessException(ErrorCode.NO_AUTHORITY, "你不是管理员，无权限");
        }
        if(id<=0){
            return false;
        }
        return userService.removeById(id);
    }


    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    @GetMapping("/current")
    public BaseResponse<User> getCurrentUser(HttpServletRequest request){
        if (request == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
            }
        Object userObject = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObject;
        User safetyUser = userService.getCurrentUser(currentUser);
        return ResultUtils.success(safetyUser);

        }
    }


