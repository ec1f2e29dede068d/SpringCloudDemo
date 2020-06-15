package com.c.w.eureka_colony_target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaColonyTargetApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaColonyTargetApplication.class, args);
    }

}
