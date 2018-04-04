package com.example.test.integration;

import com.example.DemoApplication;
import com.example.backend.persistance.domain.backend.PasswordResetToken;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.service.PasswordResetTokenService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Andrei.Vasiliu on 4/4/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class PasswordResetTokenServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @Rule public TestName testName = new TestName();

    @Test
    public void testCreateNewTokenForUserEmail() throws Exception{

        User user = createUser(testName);

        PasswordResetToken passwordResetToken = passwordResetTokenService.createPasswordResetTokenForEmail(user.getEmail());
        Assert.assertNotNull(passwordResetToken);
        Assert.assertNotNull(passwordResetToken.getToken());
    }
}
