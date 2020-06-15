package com.c.w.a04_load_balance_annotation_test;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MyAutoConfiguration {

    @Autowired(required = false)
    private List<RestTemplate> myTemplates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton myLoadBalanceRestTemplateInitializer() {
        System.out.println("==========这个Bean将在容器初始化时创建");
        return () -> {
            for (RestTemplate restTemplate : myTemplates) {
                MyInterceptor myInterceptor = new MyInterceptor();
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
                list.add(myInterceptor);
                restTemplate.setInterceptors(list);
            }
        };
    }
}
