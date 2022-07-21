package com.challenge.app.coupon.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clientItems")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
