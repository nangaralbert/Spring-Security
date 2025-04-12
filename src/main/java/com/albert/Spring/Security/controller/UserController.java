package com.albert.Spring.Security.controller;

import com.albert.Spring.Security.model.Users;
import com.albert.Spring.Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }
}
