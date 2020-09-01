package com.c.w.four;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author C
 */
@SpringBootApplication
@EnableEurekaServer
public class LoadBalanceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceServerApplication.class, args);
    }

}
