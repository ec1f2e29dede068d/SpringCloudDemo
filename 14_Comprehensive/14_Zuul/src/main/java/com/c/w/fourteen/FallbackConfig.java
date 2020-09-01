package com.c.w.fourteen;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig {

    @Bean
    public FallbackProvider consumerFallbackProvider() {
        return new MyFallbackProvider();
    }

}
