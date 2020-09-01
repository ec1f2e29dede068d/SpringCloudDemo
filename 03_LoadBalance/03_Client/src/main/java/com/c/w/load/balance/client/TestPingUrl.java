package com.c.w.load.balance.client;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author C
 */
public class TestPingUrl {

    public static void main(String[] args) {
        try {
            List<Server> servers = getServersByDynamicConfigure();
            Thread.sleep(6000);
            System.out.println("Servers size : " + servers.size());
            for (Server server : servers) {
                System.out.println(server.getHostPort() + " State:" + server.isAlive());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Server> getServersByConfigurationFile() throws IOException {
        ConfigurationManager.loadPropertiesFromResources("application.properties");
        RestClient restClient = (RestClient) ClientFactory.getNamedClient("my-client");
        return restClient.getLoadBalancer().getAllServers();
    }

    private static List<Server> getServersByDynamicConfigure() {
        BaseLoadBalancer loadBalancer = new BaseLoadBalancer();
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8081));
        servers.add(new Server("localhost", 8888));
        loadBalancer.addServers(servers);
        loadBalancer.setPing(new PingUrl());
        loadBalancer.setPingInterval(2);
        return loadBalancer.getAllServers();
    }

}
