package com.c.w.four;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author C
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LoadBalanceInvokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceInvokerApplication.class, args);
    }

}
