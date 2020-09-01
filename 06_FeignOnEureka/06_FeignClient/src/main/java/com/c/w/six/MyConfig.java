package com.c.w.six;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author C
 */
@Configuration
public class MyConfig {

    @Bean
    public Contract feignContract() {
        return new MyContract();
    }

}
