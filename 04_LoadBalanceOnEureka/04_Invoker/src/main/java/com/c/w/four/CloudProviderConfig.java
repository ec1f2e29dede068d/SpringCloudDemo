package com.c.w.four;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author C
 * 使用注解设置Ribbon
 */
@RibbonClient(name = "first-service-provider", configuration = MyConfig.class)
public class CloudProviderConfig {

}
