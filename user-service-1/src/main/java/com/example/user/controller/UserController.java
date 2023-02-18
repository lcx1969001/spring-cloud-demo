package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @GetMapping("user/hello")
    public String hello(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        System.out.println("ip = " + ip);
        return "user-service-1: hello";
    }

}
