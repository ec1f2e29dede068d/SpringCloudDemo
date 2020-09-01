package com.c.w;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author C
 */
@RestController
public class FirstController {

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request) {
        Person person = new Person(personId, "TOM", 23);
        person.setMessage(request.getRequestURL().toString());
        return person;
    }

}
