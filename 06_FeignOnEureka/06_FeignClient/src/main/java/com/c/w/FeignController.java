package com.c.w;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private PersonClient personClient;

    @RequestMapping(value = "/invokeHello", method = RequestMethod.GET)
    public String invokeHello() {
        return personClient.hello();
    }

    @RequestMapping(value = "/router", method = RequestMethod.GET)
    @ResponseBody
    public String router() {
        Person person = personClient.getPerson(2);
        return person.getMessage();
    }

    @RequestMapping(value = "/testContract", method = RequestMethod.GET)
    @ResponseBody
    public String testContract() {
        String springResult = personClient.hello();
        System.out.println("使用@RequestMapping注解的接口返回的结果：" + springResult);
        String myResult = personClient.myHello();
        System.out.println("使用@MyUrl注解的接口返回的结果：" + myResult);
        return "请看控制台输出";
    }

}
