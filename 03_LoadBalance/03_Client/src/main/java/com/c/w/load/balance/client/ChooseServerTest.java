package com.c.w.load.balance.client;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author C
 */
public class ChooseServerTest {

    public static void main(String[] args) {
        ILoadBalancer loadBalancer = new BaseLoadBalancer();

        /*BaseLoadBalancer loadBalancer = new BaseLoadBalancer();
        loadBalancer.setRule(new MyRule(loadBalancer));*/

        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8081));
        servers.add(new Server("localhost", 8085));
        loadBalancer.addServers(servers);
        int loopNum = 6;
        for (int i = 0; i < loopNum; i++) {
            Server server = loadBalancer.chooseServer(null);
            System.out.println(server);
        }
    }

}
