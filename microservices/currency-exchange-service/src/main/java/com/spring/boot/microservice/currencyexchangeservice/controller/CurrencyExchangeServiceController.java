package com.spring.boot.microservice.currencyexchangeservice.controller;

import com.spring.boot.microservice.currencyexchangeservice.domain.ExchangeRate;
import com.spring.boot.microservice.currencyexchangeservice.repository.ExchangeRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author sharifahmed
 * @since 2019-08-19
 */
@RestController
public class CurrencyExchangeServiceController {

    private Logger log = LoggerFactory.getLogger(CurrencyExchangeServiceController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public ExchangeRate getExchangeRate(@PathVariable String from,
                                        @PathVariable String to) {
        log.info("e - getExchangeRate");

        ExchangeRate exchangeRate = exchangeRateRepository.findByFromAndTo(from, to);
        exchangeRate.setPort(environment.getProperty("local.server.port"));
        return exchangeRate;
    }
}
