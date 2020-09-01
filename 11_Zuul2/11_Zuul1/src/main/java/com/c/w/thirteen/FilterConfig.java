package com.c.w.thirteen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public ExceptionFilter exceptionFilter() {
        return new ExceptionFilter();
    }

}
