package com.c.w.load_balance_client;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;

public class LoadBalanceClientApplication {

    public static void main(String[] args) {
        /*ConfigurationManager.getConfigInstance().setProperty("my-client.ribbon.listOfServers"
                , "localhost:8081,localhost:8085");*/
        try {
            ConfigurationManager.loadPropertiesFromResources("application.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
        for (int i = 0; i < 6; i++) {
            try {
                HttpResponse response = client.executeWithLoadBalancer(request);
                String result = response.getEntity(String.class);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
