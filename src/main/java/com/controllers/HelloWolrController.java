package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Andrei.Vasiliu on 3/8/2018.
 */
@Controller
public class HelloWolrController {

    @RequestMapping("/")
    public String sayHello(){
        return "index";
    }
}
