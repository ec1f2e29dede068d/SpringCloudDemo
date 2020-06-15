package com.c.w.thirteen;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProducerController {

    @Resource
    SendService sendService;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String sendRequest(){
        Message message = MessageBuilder.withPayload("Hello RabbitMQ".getBytes()).build();
        sendService.sendOrder().send(message);
        return "SUCCESS";
    }

}
