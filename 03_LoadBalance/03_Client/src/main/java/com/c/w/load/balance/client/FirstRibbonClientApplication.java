package com.c.w.load.balance.client;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;

/**
 * @author C
 */
public class FirstRibbonClientApplication {

    public static void main(String[] args) {
        //两种加载配置信息的方法，第一种为动态加载，第二种为从application.properties读取加载
        //dynamicSetConfiguration();
        readConfigurationFromFile();

        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
        int requestNum = 6;
        for (int i = 0; i < requestNum; i++) {
            System.out.println("****************************************************************************************************************************************************************************");
            try {
                HttpResponse response = client.executeWithLoadBalancer(request);
                String result = response.getEntity(String.class);
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件加载配置
     */
    private static void readConfigurationFromFile() {
        try {
            ConfigurationManager.loadPropertiesFromResources("application.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态加载配置
     */
    private static void dynamicSetConfiguration() {
        ConfigurationManager.getConfigInstance().setProperty("my-client.ribbon.listOfServers"
                , "localhost:8081,localhost:8085");
    }

}
