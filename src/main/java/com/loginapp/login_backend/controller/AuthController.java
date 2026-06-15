package com.loginapp.login_backend.controller;

import com.loginapp.login_backend.dto.LoginRequest;
import com.loginapp.login_backend.entity.User;
import com.loginapp.login_backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return service.login(
                request.getEmail(),
                request.getPassword()
        );
    }
}