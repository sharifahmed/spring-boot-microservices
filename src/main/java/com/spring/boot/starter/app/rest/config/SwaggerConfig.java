package com.spring.boot.starter.app.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sharif.ahmed
 * @since 4/28/19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("Sharif Ahmed",
            "https://bd.linkedin.com/in/sharifahmed001", "sharifducse@gmail.com");

    private static final ApiInfo API_INFO = new ApiInfo("API Documentation",
            "Sprint Boot Starter Repo API Documentation", "1.0", "", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

    private static final Set<String> MEDIA_TYPE;

    static {
        MEDIA_TYPE = new HashSet<>();
        MEDIA_TYPE.add("application/json");
        MEDIA_TYPE.add("application/xml");
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .produces(MEDIA_TYPE)
                .consumes(MEDIA_TYPE);
    }
}
