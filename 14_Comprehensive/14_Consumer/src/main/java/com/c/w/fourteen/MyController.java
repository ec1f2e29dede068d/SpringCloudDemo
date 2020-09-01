package com.c.w.fourteen;

import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/send")
    public String sendPerson(@RequestBody Student user) {
        System.out.println("******************通过Zuul网关转发接收过来的学生信息******************");
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(user));
        return "SUCCESS";
    }

}
