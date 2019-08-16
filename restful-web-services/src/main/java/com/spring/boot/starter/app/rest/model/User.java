package com.spring.boot.starter.app.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author sharif.ahmed
 * @since 3/12/19
 */
@Entity
@ApiModel(description = "User Details")
public class User {

    private static final String NAME_SIZE_MSG = "Name must have at least 2 characters";

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 2, message = NAME_SIZE_MSG)
    @ApiModelProperty(notes = NAME_SIZE_MSG)
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
