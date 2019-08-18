package com.spring.boot.microservices.limitservices.domain;

/**
 * @author sharifahmed
 * @since 2019-08-16
 */
public class LimitsConfiguration {

    private int min;
    private int max;

    protected LimitsConfiguration() {
    }

    public LimitsConfiguration(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
