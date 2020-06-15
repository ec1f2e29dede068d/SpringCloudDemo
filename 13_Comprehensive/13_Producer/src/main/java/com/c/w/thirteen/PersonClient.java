package com.c.w.thirteen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "dbService", fallback = PersonClient.PersonClientFallback.class)
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/stuinfo/{uid}")
    User getPerson(@PathVariable("uid") String uid);

    @Component
    class PersonClientFallback implements PersonClient {

        @Override
        public User getPerson(String uid) {
            return new User("zero", "none", "none");
        }

    }

}
