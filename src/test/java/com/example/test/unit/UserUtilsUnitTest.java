package com.example.test.unit;

import com.example.utils.UserUtils;
import com.example.webapp.controllers.ForgotMyPasswordController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.UUID;

/**
 * Created by Andrei.Vasiliu on 4/4/2018.
 */
public class UserUtilsUnitTest {
    private MockHttpServletRequest mockHttpServletRequest;

    @Before
    public void init() {
        mockHttpServletRequest = new MockHttpServletRequest();
    }

    @Test
    public void testPasswordResetEmailUrlConstruction() throws Exception{
        String token = UUID.randomUUID().toString();
        long userId = 123456;

        String expectedUrl = "http://localhost:80" + ForgotMyPasswordController.CHANGE_PASSWORD_PATH + "?id=" + userId + "&token=" +token;

        String actualUrl = UserUtils.createPasswordResetUrl(mockHttpServletRequest,userId,token);

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
