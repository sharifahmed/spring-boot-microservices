package com.spring.boot.microservice.currencyconversionservice.proxy;

import com.spring.boot.microservice.currencyconversionservice.domain.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sharifahmed
 * @since 2019-08-20
 */
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getExchangeRate(@PathVariable(value = "from") String from,
                                       @PathVariable(value = "to") String to);
}
