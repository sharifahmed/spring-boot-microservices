package com.spring.boot.microservices.limitservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sharifahmed
 * @since 2019-08-18
 */
@ConfigurationProperties(value = "limits.service")
public class AppPropLimitsConfig {

    private int min;
    private int max;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
