package service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.wobushi041.centerbackend.common.BaseResponse;
import org.wobushi041.centerbackend.common.ErrorCode;
import org.wobushi041.centerbackend.common.ResultUtils;
import org.wobushi041.centerbackend.exception.BusinessException;
import org.wobushi041.centerbackend.mapper.UserMapper;
import org.wobushi041.centerbackend.model.domain.User;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 041
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2026-04-03 14:41:22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public static final String SALT = "041";
 private static final String USER_LOGIN_STATE = "userLoginState";
    @Resource
    private UserMapper userMapper;

/**
 * 用户注册方法
 * @param userAccount 用户账号
 * @param userPassword 用户密码
 * @param checkPassword 确认密码
 * @return 返回新注册用户的ID
 */
    @Override
    public Long userRegister(String userAccount, String userPassword, String checkPassword) {
    // 检查参数是否为空
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
    // 检查用户账号长度
        if (userAccount.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号不能小于4位");
        }
    // 检查用户密码长度
        if (userPassword.length() < 8) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码不能小于8位");
        }

    // 检查用户账号是否包含特殊字符
        String validateRegExp = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validateRegExp).matcher(userAccount);
        if (matcher.find()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号不能包含特殊字符");
        }
    // 检查两次密码是否一致
        if (!userPassword.equals(checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次密码不一致");
        }

    // 检查账号是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");
        }

    // 对密码进行MD5加密并保存用户信息
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean saveResult = this.save(user);
        if (!saveResult) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "注册失败");
        }
        return user.getId();
    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (userAccount.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号不能小于4位");
        }
        if (userPassword.length() < 8) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码不能小于8位");
        }

        String validateRegExp = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(validateRegExp).matcher(userAccount);
        if (matcher.find()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号不能包含特殊字符");
        }

        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);

        User user = userMapper.selectOne(queryWrapper);

        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }

        User safetyUser = new User();
        safetyUser.setId(user.getId());
        safetyUser.setUsername(user.getUsername());
        safetyUser.setUserAccount(user.getUserAccount());
        safetyUser.setAvatarUrl(user.getAvatarUrl());
        safetyUser.setGender(user.getGender());
        safetyUser.setPhone(user.getPhone());
        safetyUser.setEmail(user.getEmail());
        safetyUser.setUserStatus(user.getUserStatus());
        safetyUser.setCreateTime(user.getCreateTime());

        request.getSession().setAttribute(USER_LOGIN_STATE, safetyUser);

        return safetyUser;
    }
}
