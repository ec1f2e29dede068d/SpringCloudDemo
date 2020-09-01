package com.c.w.four;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author C
 */
@Configuration
public class MyAutoConfiguration {

    @Resource
    private final List<RestTemplate> myTemplates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton myLoadBalanceRestTemplateInitializer() {
        System.out.println("==========这个Bean将在容器初始化时创建==========");
        return () -> {
            for (RestTemplate restTemplate : myTemplates) {
                //自定义拦截器
                MyInterceptor myInterceptor = new MyInterceptor();
                //获取原来拦截器
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
                //添加自定义拦截器
                list.add(myInterceptor);
                //将新的拦截器集合设置到RestTemplate
                restTemplate.setInterceptors(list);
            }
        };
    }
}
