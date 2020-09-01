package com.c.w.six;

import feign.MethodMetadata;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author C
 */
public class MyContract extends SpringMvcContract {

    /**
     * 处理方法注解
     * @param data
     * @param methodAnnotation
     * @param method
     */
    @Override
    protected void processAnnotationOnMethod(MethodMetadata data, Annotation methodAnnotation, Method method) {
        super.processAnnotationOnMethod(data, methodAnnotation, method);
        if (methodAnnotation instanceof MyUrl) {
            MyUrl myUrl = method.getAnnotation(MyUrl.class);
            String httpMethod = myUrl.method();
            String url = myUrl.url();
            data.template().method(httpMethod);
            data.template().append(url);
        }
    }

}
