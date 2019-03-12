package com.spring.boot.starter.springbootstarter.app.web.runner;

import com.spring.boot.starter.springbootstarter.app.web.model.User;
import com.spring.boot.starter.springbootstarter.app.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@Component
public class UserRepoRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Akram");
        userRepository.save(user);
    }
}
