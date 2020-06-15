package com.c.w.eureka_colony_invoker;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class EurekaColonyInvokerController {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("router")
    public String router() {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://first-service-provider/person/9001", String.class);
    }

}
