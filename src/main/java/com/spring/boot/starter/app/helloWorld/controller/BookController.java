package com.spring.boot.starter.app.helloWorld.controller;

import com.spring.boot.starter.app.helloWorld.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author sharif.ahmed
 * @since 3/7/19
 */
@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return Arrays.asList(new Book(1, "Book-101", "Author-1"), new Book(2, "Book-201", "Author-2"));
    }
}
