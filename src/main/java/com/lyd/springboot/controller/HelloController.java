package com.lyd.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        System.out.println("进入controller");
        return "Hello World";
    }
}
