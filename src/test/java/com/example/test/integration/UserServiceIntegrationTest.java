package com.example.test.integration;

import com.example.DemoApplication;
import com.example.backend.persistance.domain.backend.Role;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.persistance.domain.backend.UserRole;
import com.example.backend.service.UserService;
import com.example.utils.PlansEnum;
import com.example.utils.RolesEnum;
import com.example.utils.UserUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei.Vasiliu on 4/4/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest{

    @Rule public TestName testName = new TestName();

    @Test
    public void testCreateNewUser() throws Exception{



        User user = createUser(testName);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }

}
