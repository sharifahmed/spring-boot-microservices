package com.spring.boot.microservice.currencyconversionservice.controller;

import com.spring.boot.microservice.currencyconversionservice.domain.CurrencyConversion;
import com.spring.boot.microservice.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author sharifahmed
 * @since 2019-08-20
 */
@RestController
public class CurrencyConversionController {

    private Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private CurrencyExchangeServiceProxy exchangeServiceProxy;

    @GetMapping(value = "/currency-converter/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion getCurrencyConversion(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable BigDecimal amount) {

        log.info("e - getCurrencyConversion");

        CurrencyConversion currencyConversion = exchangeServiceProxy.getExchangeRate(from, to);
        BigDecimal result = amount.multiply(currencyConversion.getConversionRate());
        return new CurrencyConversion(from, to, amount, currencyConversion.getConversionRate(), result,
                currencyConversion.getPort());
    }
}
