package com.c.w.four;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author C
 */
public class MyRule implements IRule {

    private ILoadBalancer iLoadBalancer;

    public MyRule() {

    }

    public MyRule(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer = iLoadBalancer;
    }

    @Override
    public Server choose(Object key) {
        List<Server> servers = iLoadBalancer.getAllServers();
        System.out.println("这是自定义服务器规则，输出服务器信息：");
        for (Server server : servers) {
            System.out.println("    " + server.getHostPort());
        }
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.iLoadBalancer = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.iLoadBalancer;
    }
}
