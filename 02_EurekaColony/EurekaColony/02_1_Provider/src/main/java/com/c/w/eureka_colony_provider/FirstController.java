package com.c.w.eureka_colony_provider;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FirstController {

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
    public String findName(@PathVariable("personId") Integer personId, HttpServletRequest request) {
        Person person = new Person(personId, "TOM", 23);
        person.setMessage(request.getRequestURL().toString());
        return new Gson().toJson(person);
    }

}
