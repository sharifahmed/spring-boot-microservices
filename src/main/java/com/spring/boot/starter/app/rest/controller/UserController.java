package com.spring.boot.starter.app.rest.controller;

import com.spring.boot.starter.app.rest.model.User;
import com.spring.boot.starter.app.rest.repository.UserRepository;
import com.spring.boot.starter.app.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/users")
    public ResponseEntity<Object> save(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(Object.class);
    }
}
