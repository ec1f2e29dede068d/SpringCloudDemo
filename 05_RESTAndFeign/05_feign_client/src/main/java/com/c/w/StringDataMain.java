package com.c.w;

import feign.Feign;

public class StringDataMain {

    public static void main(String[] args) {
        Client client = Feign.builder().target(Client.class, "http://localhost:8080");
        System.out.println(client.stringData());
    }

}
