
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
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.TestName;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.SpringApplicationConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import java.util.HashSet;
        import java.util.Set;
        import java.util.UUID;

        /**
 * Created by tedonema on 29/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class UserRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Rule public TestName testName = new TestName();

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
    }

    @Test
    public void testCreateNewRole() throws Exception {

        Role userRole  = createRole(RolesEnum.BASIC);
        roleRepository.save(userRole);

        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrievedRole);
    }

    @Test
    public void createNewUser() throws Exception {

        String username = testName.getMethodName();
        String email = testName.getMethodName()+"@yahoo.com";

        User basicUser = createUser(username,email);

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur : newlyCreatedUserUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }

    }

    @Test
    public void testDeleteUser() throws Exception{
        String username = testName.getMethodName();
        String email = testName.getMethodName()+"@yahoo.com";
        User basicUser = createUser(username,email);
        userRepository.delete(basicUser.getId());
    }

    @Test
    public void testGetUserByEmail() throws Exception{
        User user = createUser(testName);

        User FoundUser = userRepository.findByEmail(user.getEmail());
        Assert.assertNotNull(FoundUser);
        Assert.assertNotNull(FoundUser.getId());
    }

    @Test
    public void testUpdateUserPassword() throws Exception{
        User user = createUser(testName);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

        String newPass = UUID.randomUUID().toString();

        userRepository.updateUserPassword(user.getId(),newPass);

        user = userRepository.findOne(user.getId());
        Assert.assertNotNull(newPass,user.getPassword());
    }

}
