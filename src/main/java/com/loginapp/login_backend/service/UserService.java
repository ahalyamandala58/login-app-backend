package com.loginapp.login_backend.service;

import com.loginapp.login_backend.entity.User;
import com.loginapp.login_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User register(User user) {
        return repository.save(user);
    }

    public String login(String email, String password) {

        User user = repository.findByEmail(email)
                .orElse(null);

        if (user == null) {
            return "User Not Found";
        }

        if (user.getPassword().equals(password)) {
            return "Login Successful";
        }

        return "Invalid Password";
    }
}