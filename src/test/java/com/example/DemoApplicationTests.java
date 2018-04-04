package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.backend.service.I18NService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@ActiveProfiles("prod")
public class DemoApplicationTests {

    @Autowired
    private I18NService i18NService;

    @Test
    public void testMessageByLocaleService() throws Exception {
        String expectedResult = "Bootstrap starter template";
        String messageId = "index.main.callout";
        String actual = i18NService.getMssage(messageId);
        Assert.assertEquals("The actual and expected Strings don't match", expectedResult, actual);
    }

}