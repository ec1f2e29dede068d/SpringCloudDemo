package com.c.w.thirteen;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/send")
    public String sendPerson(@RequestBody User user) {
        System.out.println("通过Zuul网关转发接收过来的消息:" + user.getUid() + "  " + user.getUsername());
        return "SUCCESS";
    }

}
