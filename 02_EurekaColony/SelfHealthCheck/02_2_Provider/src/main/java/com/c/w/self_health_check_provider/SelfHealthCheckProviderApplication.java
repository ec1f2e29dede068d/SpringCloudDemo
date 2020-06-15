package com.c.w.self_health_check_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SelfHealthCheckProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfHealthCheckProviderApplication.class, args);
    }

}
