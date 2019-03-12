package com.spring.boot.starter.springbootstarter.app.web.controller;

import com.spring.boot.starter.springbootstarter.app.web.model.User;
import com.spring.boot.starter.springbootstarter.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.find(id);
    }
}
