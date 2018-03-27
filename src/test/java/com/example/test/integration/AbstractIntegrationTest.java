package com.example.test.integration;

import com.example.DemoApplication;
import com.example.backend.persistance.domain.backend.Plan;
import com.example.backend.persistance.domain.backend.Role;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.persistance.domain.backend.UserRole;
import com.example.backend.persistance.repositories.PlanRepository;
import com.example.backend.persistance.repositories.RoleRepository;
import com.example.backend.persistance.repositories.UserRepository;
import com.example.utils.PlansEnum;
import com.example.utils.RolesEnum;
import com.example.utils.UserUtils;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei.Vasiliu on 3/27/2018.
 */

public abstract class AbstractIntegrationTest {

    @Autowired
    protected PlanRepository planRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected UserRepository userRepository;


    protected Plan createPlan(PlansEnum plansEnum) {
        return new Plan(plansEnum);
    }


    protected Role createRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }

    protected User createUser(String username, String email){
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User basicUser = UserUtils.createBasicUser(username, email);
        basicUser.setPlan(basicPlan);

        Role basicRole = createRole(RolesEnum.BASIC);
        roleRepository.save(basicRole);

        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser, basicRole);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);
        basicUser = userRepository.save(basicUser);
        return basicUser;
    }

    protected User createUser(TestName testName){
        return createUser(testName.getMethodName(),testName.getMethodName() + "@yahoo.com");
    }
}
