package com.example.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //test...
    @RequestMapping("/hello")
    public String test(){
        return "Hello";
    }
}
