package com.c.w.a04_load_balance_invoker;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("This is my Ping class: " + server.getHostPort());
        return true;
    }
}
