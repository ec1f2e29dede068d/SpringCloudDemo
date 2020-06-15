package com.c.w.load_balance_client;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;
import java.util.List;

public class TestPingUrl {

    public static void main(String[] args) {
        /*BaseLoadBalancer loadBalancer = new BaseLoadBalancer();
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8081));
        servers.add(new Server("localhost", 8888));
        loadBalancer.addServers(servers);
        loadBalancer.setPing(new PingUrl());
        loadBalancer.setPingInterval(2);
        servers = loadBalancer.getAllServers();*/

        try {
            ConfigurationManager.loadPropertiesFromResources("application.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestClient restClient = (RestClient) ClientFactory.getNamedClient("my-client");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Server> servers = restClient.getLoadBalancer().getAllServers();
        System.out.println(servers.size());
        for (Server server : servers) {
            System.out.println(server.getHostPort() + " State:" + server.isAlive());
        }
    }

}
