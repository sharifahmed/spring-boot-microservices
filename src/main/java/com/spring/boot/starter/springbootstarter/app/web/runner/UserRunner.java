package com.spring.boot.starter.springbootstarter.app.web.runner;

import com.spring.boot.starter.springbootstarter.app.web.model.User;
import com.spring.boot.starter.springbootstarter.app.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Karim");
        userService.saveOrUpdate(user);
    }
}
