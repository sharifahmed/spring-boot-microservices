package com.spring.boot.microservice.currencyconversionservice.domain;

import java.math.BigDecimal;

/**
 * @author sharifahmed
 * @since 2019-08-20
 */
public class CurrencyConversion {

    private String from;
    private String to;
    private BigDecimal amount;
    private BigDecimal conversionRate;
    private BigDecimal result;
    private int port;

    protected CurrencyConversion() {
    }

    public CurrencyConversion(String from,
                              String to,
                              BigDecimal amount,
                              BigDecimal conversionRate,
                              BigDecimal result,
                              int port) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.conversionRate = conversionRate;
        this.result = result;
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public BigDecimal getResult() {
        return result;
    }

    public int getPort() {
        return port;
    }
}
