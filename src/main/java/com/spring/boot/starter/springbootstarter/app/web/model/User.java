package com.spring.boot.starter.springbootstarter.app.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
