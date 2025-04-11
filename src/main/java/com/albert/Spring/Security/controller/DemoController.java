package com.albert.Spring.Security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/")
    public String home(){
        return "This is a public API";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is an admin API";
    }

    @GetMapping("/user")
    public String user(){
        return "This is a user API";
    }
}
