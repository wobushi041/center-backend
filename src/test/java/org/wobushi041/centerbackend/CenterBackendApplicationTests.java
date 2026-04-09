package org.wobushi041.centerbackend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wobushi041.centerbackend.mapper.UserMapper;
import org.wobushi041.centerbackend.model.enity.User;

import javax.annotation.Resource;


@SpringBootTest
class CenterBackendApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void testSelectUserRoleAndPlanetCode() {
        Long testUserId = 1L; // 改成你手动插入的那条数据 id

        User user = userMapper.selectById(testUserId);

        Assertions.assertNotNull(user, "用户不存在，请先手动插入测试数据");
        Assertions.assertNotNull(user.getUserRole(), "role 没查出来，请检查数据库字段、XML 映射或实体字段");
        System.out.println("id = " + user.getId());
        System.out.println("role = " + user.getUserRole());
    }


    }

