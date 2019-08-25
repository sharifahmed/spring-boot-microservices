package com.spring.boot.microservice.currencyconversionservice.proxy;

import com.spring.boot.microservice.currencyconversionservice.domain.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sharifahmed
 * @since 2019-08-20
 */
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    //@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    @GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getExchangeRate(@PathVariable(value = "from") String from,
                                       @PathVariable(value = "to") String to);
}
