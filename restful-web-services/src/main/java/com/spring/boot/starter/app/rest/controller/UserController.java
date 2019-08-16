package com.spring.boot.starter.app.rest.controller;

import com.spring.boot.starter.app.rest.exception.UserNotFoundException;
import com.spring.boot.starter.app.rest.model.User;
import com.spring.boot.starter.app.rest.repository.UserRepository;
import com.spring.boot.starter.app.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

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
        User user = userService.find(id);

        if (isNull(user)) {
            throw new UserNotFoundException("User not found with id = " + id);
        }

        return user;
    }

    @GetMapping("/repoUser/{id}")
    public Resource<User> getRepoUser(@PathVariable long id) {
        User user = userRepository.findOne(id);

        if (isNull(user)) {
            throw new UserNotFoundException("User not found with id = " + id);
        }

        Resource<User> resource = new Resource<>(user);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
        resource.add(linkTo.withRel("allUsers"));

        return resource;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(Object.class);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id) {
        userRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
