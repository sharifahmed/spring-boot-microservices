package com.spring.boot.microservices.limitservices.controller;

import com.spring.boot.microservices.limitservices.config.AppPropLimitsConfig;
import com.spring.boot.microservices.limitservices.domain.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sharifahmed
 * @since 2019-08-16
 */
@RestController
public class LimitsConfigurationController {

    @Autowired
    private AppPropLimitsConfig appPropLimitsConfig;

    @GetMapping(value = "/limits")
    public LimitsConfiguration getLimitsConfiguration() {
        return new LimitsConfiguration(appPropLimitsConfig.getMin(), appPropLimitsConfig.getMax());
    }
}
