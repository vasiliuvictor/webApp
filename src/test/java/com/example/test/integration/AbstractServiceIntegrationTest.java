package com.example.test.integration;

import com.example.backend.persistance.domain.backend.Role;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.persistance.domain.backend.UserRole;
import com.example.backend.service.UserService;
import com.example.utils.PlansEnum;
import com.example.utils.RolesEnum;
import com.example.utils.UserUtils;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei.Vasiliu on 4/4/2018.
 */
public class AbstractServiceIntegrationTest {
    @Autowired
    protected UserService userService;

    protected User createUser(TestName testName){
        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@yahoo.com";

        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser(username,email);
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));
        return userService.createUser(basicUser, PlansEnum.BASIC,userRoles);
    }
}
