package com.spring.boot.starter.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

/**
 * @author sharif.ahmed
 * @since 4/28/19
 */
@RestController
public class GreetingsController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/greetings")
    public String greetings() {
        return messageSource.getMessage("label.greetings", null, getLocale());
    }
}
