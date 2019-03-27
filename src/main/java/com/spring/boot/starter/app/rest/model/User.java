package com.spring.boot.starter.app.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 2, message = "Name must have at least 2 characters")
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
