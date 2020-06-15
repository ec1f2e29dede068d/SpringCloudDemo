package com.c.w;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Configuration
public class InvokerController {

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/router/{personId}", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Person router(@PathVariable Integer personId) {
        return personService.getPerson(personId);
    }

}
