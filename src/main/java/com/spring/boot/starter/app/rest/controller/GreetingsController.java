package com.spring.boot.starter.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author sharif.ahmed
 * @since 4/28/19
 */
@RestController
public class GreetingsController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/greetings")
    public String greetings(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("label.greetings", null, locale);
    }
}
