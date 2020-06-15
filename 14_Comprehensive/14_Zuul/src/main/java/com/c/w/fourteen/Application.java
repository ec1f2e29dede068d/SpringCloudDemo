package com.c.w.fourteen;

import com.netflix.config.ConfigurationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.metrics.rollingStats.timeInMilliseconds", 10000);
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.requestVolumeThreshold", 3);
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.errorThresholdPercentage", 50);
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds", 1000);
    }

}
