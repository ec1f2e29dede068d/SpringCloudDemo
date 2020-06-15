package com.c.w.self_health_check_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SelfHealthCheckServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfHealthCheckServerApplication.class, args);
    }

}
