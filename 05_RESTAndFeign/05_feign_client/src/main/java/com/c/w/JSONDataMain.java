package com.c.w;

import feign.Feign;
import feign.gson.GsonDecoder;

public class JSONDataMain {

    public static void main(String[] args) {
        Client client = Feign.builder().decoder(new GsonDecoder())
                .target(Client.class,"http://localhost:8080");
        Client.Student student = client.jsonData(1);
        System.out.println(student.sid);
        System.out.println(student.sname);
        System.out.println(student.chinese);
        System.out.println(student.math);
        System.out.println(student.english);
    }

}
