package com.c.w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TargetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TargetApplication.class, args);
    }

}
