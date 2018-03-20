package com.example;

import com.example.webapp.i18n.I18NService;
import org.h2.command.dml.Replace;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private I18NService i18NService;

    @Test
    public void testMessageByLocaleService() throws Exception{
        String expectedResult = "Welcome to the Mars";
        String messageId ="index.main.callout";
        String actual = i18NService.getMssage(messageId);
        Assert.assertEquals("the actual and expected Strings don't match",expectedResult,actual);
    }

}
