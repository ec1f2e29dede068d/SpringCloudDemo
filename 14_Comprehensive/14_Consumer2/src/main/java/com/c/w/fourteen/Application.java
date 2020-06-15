package com.c.w.fourteen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
@EnableBinding(ReceiveService.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @StreamListener("myInput")
    public void receive(byte[] msg) {
        String json = new String(msg);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> userList = gson.fromJson(json, new TypeToken<ArrayList<User>>() {
        }.getType());
        userList.sort(Comparator.comparing(User::getTotal).reversed());
        System.out.println("******************Consumer2******************");
        System.out.println("按照成绩总分从多到少排序输出班级学生信息如下：");
        System.out.println(gson.toJson(userList));
    }

}
