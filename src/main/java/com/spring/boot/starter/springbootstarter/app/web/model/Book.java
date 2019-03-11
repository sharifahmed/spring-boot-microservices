package com.spring.boot.starter.springbootstarter.app.web.model;

/**
 * @author sharif.ahmed
 * @since 3/7/19
 */
public class Book {

    private long id;
    private String name;
    private String author;

    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
