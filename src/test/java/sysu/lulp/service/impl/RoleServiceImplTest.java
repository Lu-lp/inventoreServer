package sysu.lulp.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sysu.lulp.pojo.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceImplTest {
    private RoleServiceImpl roleService;

    @Autowired
    RoleServiceImplTest(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @Test
    void selectById() {
        Role admin = roleService.selectById(1);
        Assert.assertEquals("ROLE_ADMIN",admin.getRoleName());
    }
}