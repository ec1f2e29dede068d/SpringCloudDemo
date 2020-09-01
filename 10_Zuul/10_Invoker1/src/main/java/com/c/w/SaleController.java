package com.c.w;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SaleController {

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
    public String saleBook(@PathVariable Integer personId) {
        Person person = personService.getPerson(personId);
        System.out.println("人物：" + person.getId() + "，人名：" + person.getName());
        return "SUCCESS";
    }

}
