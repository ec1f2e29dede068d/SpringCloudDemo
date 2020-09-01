package com.c.w;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author C
 */
@Component
public class PersonService {

    @Resource
    private RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(fallbackMethod = "getPersonFallback")
    public Person getPerson(Integer id) {
        return restTemplate.getForObject("http://spring-hystrix-provider/person/{personId}"
                , Person.class, id);
    }

    public Person getPersonFallback(Integer id) {
        Person person = new Person(0, "回退", -1);
        person.setMessage("request error");
        return person;
    }

}
