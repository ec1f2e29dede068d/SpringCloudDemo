package com.c.w.six;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author C
 */
@FeignClient("spring-feign-provider")
public interface PersonClient {

    /**
     * 返回字符串
     * @return A string
     */
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();

    /**
     * 根据personId返回Person对象
     * @param personId PersonId
     * @return Person对象
     */
    @RequestMapping(method = RequestMethod.GET, value = "/person/{personId}")
    Person getPerson(@PathVariable("personId") Integer personId);

    /**
     * 测试自定义注解
     * @return A string
     */
    @MyUrl(method = "GET", url = "/hello")
    String myHello();

}
