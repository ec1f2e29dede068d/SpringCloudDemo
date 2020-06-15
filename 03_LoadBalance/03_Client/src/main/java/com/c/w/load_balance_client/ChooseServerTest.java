package com.c.w.load_balance_client;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

public class ChooseServerTest {

    public static void main(String[] args) {
//        ILoadBalancer loadBalancer = new BaseLoadBalancer();
        BaseLoadBalancer loadBalancer = new BaseLoadBalancer();
        loadBalancer.setRule(new MyRule(loadBalancer));

        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8081));
        servers.add(new Server("localhost", 8085));
        loadBalancer.addServers(servers);
        for (int i = 0; i < 6; i++) {
            Server server = loadBalancer.chooseServer(null);
            System.out.println(server);
        }
    }

}
