package com.c.w.provider;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping("/person/{name}")
    public String findName(@PathVariable("name") String name) {
        return name;
    }

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
    public String findName(@PathVariable("personId") Integer personId) {
        Person person = new Person(personId, "TOM", 23);
        return new Gson().toJson(person);
    }

}
