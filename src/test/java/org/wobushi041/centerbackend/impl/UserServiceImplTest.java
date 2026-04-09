package org.wobushi041.centerbackend.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.wobushi041.centerbackend.exception.BusinessException;
import org.wobushi041.centerbackend.mapper.UserMapper;
import service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(userService, "baseMapper", userMapper);
    }

    @Test
    @DisplayName("userRegister 参数校验失败")
    void userRegister_shouldThrowWhenParamsInvalid() {
        assertThrows(BusinessException.class, () -> userService.userRegister("", "12345678", "12345678"));
        assertThrows(BusinessException.class, () -> userService.userRegister("yu", "12345678", "12345678"));
        assertThrows(BusinessException.class, () -> userService.userRegister("yupi", "123456", "123456"));
        assertThrows(BusinessException.class, () -> userService.userRegister("yu pi", "12345678", "12345678"));
        assertThrows(BusinessException.class, () -> userService.userRegister("yupi", "12345678", "12345679"));
    }

    @Test
    @DisplayName("userRegister 账号重复")
    void userRegister_shouldThrowWhenAccountExists() {
        when(userMapper.selectCount(any())).thenReturn(1L);

        assertThrows(BusinessException.class, () -> userService.userRegister("dogYupi", "12345678", "12345678"));
    }


}
