package com.c.w.a04_load_balance_invoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoadBalanceInvokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceInvokerApplication.class, args);
    }

}
