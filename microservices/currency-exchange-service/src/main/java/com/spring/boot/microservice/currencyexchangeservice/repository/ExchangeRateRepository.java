package com.spring.boot.microservice.currencyexchangeservice.repository;

import com.spring.boot.microservice.currencyexchangeservice.domain.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sharifahmed
 * @since 2019-08-20
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    ExchangeRate findByFromAndTo(String from, String to);
}
