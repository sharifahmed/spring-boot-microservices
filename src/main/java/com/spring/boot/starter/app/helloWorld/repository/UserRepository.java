package com.spring.boot.starter.app.helloWorld.repository;

import com.spring.boot.starter.app.helloWorld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
