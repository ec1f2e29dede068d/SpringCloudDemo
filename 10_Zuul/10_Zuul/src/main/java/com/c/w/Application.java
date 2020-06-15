package com.c.w;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).properties("server.port=8085").run(args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

}
