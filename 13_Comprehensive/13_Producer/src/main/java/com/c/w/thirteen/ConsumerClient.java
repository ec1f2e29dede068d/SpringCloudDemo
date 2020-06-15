package com.c.w.thirteen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuul-gateway")
public interface ConsumerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/person/send", consumes = "application/json")
    String sendPerson(@RequestBody User user);

}
