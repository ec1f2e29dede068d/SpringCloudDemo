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
        System.out.println("******************Consumer3******************");
        System.out.println("语文最高分学生信息：");
        userList.sort(Comparator.comparing(User::getChinese).reversed());
        User maxChineseStu = userList.get(0);
        System.out.println(gson.toJson(maxChineseStu));
        System.out.println("数学最高分学生信息：");
        userList.sort(Comparator.comparing(User::getMath).reversed());
        User maxMathStu = userList.get(0);
        System.out.println(gson.toJson(maxMathStu));
        System.out.println("英语最高分学生信息：");
        userList.sort(Comparator.comparing(User::getEnglish).reversed());
        User maxEnglishStu = userList.get(0);
        System.out.println(gson.toJson(maxEnglishStu));
    }

}
