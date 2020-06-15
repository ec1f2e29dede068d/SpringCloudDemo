package com.c.w.a04_load_balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoadBalanceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceServerApplication.class, args);
    }

}
