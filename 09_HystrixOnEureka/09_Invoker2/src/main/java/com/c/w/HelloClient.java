package com.c.w;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "spring-hystrix-provider2", fallback = HelloClient.HelloClientFallback.class)
public interface HelloClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();

    @Component
    class HelloClientFallback implements HelloClient {

        public String hello() {
            return "error hello";
        }

    }

}
