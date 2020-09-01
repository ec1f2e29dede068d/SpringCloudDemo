package com.c.w.fourteen;

import com.google.gson.Gson;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProducerController {

    @Resource
    SendService sendService;
    @Resource
    private PersonClient personClient;
    @Resource
    private ConsumerClient consumerClient;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendRequest() {
        Message message = MessageBuilder.withPayload("Hello RabbitMQ".getBytes()).build();
        sendService.sendOrder().send(message);
        return "SUCCESS";
    }

    /*@RequestMapping(value = "/send/{uid}", method = RequestMethod.GET)
    public String sendRequest(@PathVariable(value = "uid") String uid) {
        User user = personClient.getPerson(uid);
        String info = user.getUid() + "  " + user.getUsername();
        Message message = MessageBuilder.withPayload(info.getBytes()).build();
        sendService.sendOrder().send(message);
        return "SUCCESS";
    }*/

    @RequestMapping(value = "/send/{cid}", method = RequestMethod.GET)
    public String sendCid(@PathVariable(value = "cid") Integer cid) {
        List<User> users = personClient.getAllStuByCid(cid);
        Gson gson = new Gson();
        String info = gson.toJson(users);
        Message message = MessageBuilder.withPayload(info.getBytes()).build();
        sendService.sendOrder().send(message);
        return "SUCCESS";
    }

    @RequestMapping(value = "/person/send/{sid}", method = RequestMethod.GET)
    public String personSendRequest(@PathVariable(value = "sid") String sid) {
        User user = personClient.getPerson(sid);
        return consumerClient.sendPerson(user);
    }

}
