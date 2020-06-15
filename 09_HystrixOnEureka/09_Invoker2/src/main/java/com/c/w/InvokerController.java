package com.c.w;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InvokerController {

    @Resource
    HelloClient helloClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        String helloResult = helloClient.hello();
        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory
                .asKey("HelloClient#hello()"));
        System.out.println("断路器状态：" + breaker.isOpen());
        return helloResult;
    }

}
