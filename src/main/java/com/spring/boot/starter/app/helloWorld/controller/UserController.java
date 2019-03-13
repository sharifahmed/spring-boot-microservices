package com.spring.boot.starter.app.helloWorld.controller;

import com.spring.boot.starter.app.helloWorld.model.User;
import com.spring.boot.starter.app.helloWorld.repository.UserRepository;
import com.spring.boot.starter.app.helloWorld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.find(id);
    }

    @GetMapping("/repoUser/{id}")
    public User getRepoUser(@PathVariable long id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
