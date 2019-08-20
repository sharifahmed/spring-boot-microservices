package com.spring.boot.microservice.currencyexchangeservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author sharifahmed
 * @since 2019-08-19
 */
@Entity
public class ExchangeRate {

    @Id
    private long id;

    @Column(name = "cur_from")
    private String from;

    @Column(name = "cur_to")
    private String to;

    @Column(precision = 5, scale = 3)
    private BigDecimal conversionRate;

    private String port; //shouldn't do in production

    protected ExchangeRate() {
    }

    public ExchangeRate(long id, String from, String to, BigDecimal conversionRate) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionRate = conversionRate;
    }

    public long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
