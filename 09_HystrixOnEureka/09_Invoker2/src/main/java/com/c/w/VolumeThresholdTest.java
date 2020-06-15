package com.c.w;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class VolumeThresholdTest {

    public static void main(String[] args) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger("root");
        logger.setLevel(Level.toLevel("INFO"));
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        for (int i = 0; i < 6; i++) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    // 创建Get请求
                    HttpGet httpGet = new HttpGet("http://localhost:9001/hello");
                    // 响应模型
                    HttpResponse response = null;
                    try {
                        // 由客户端执行(发送)Get请求
                        response = httpClient.execute(httpGet);
                        // 从响应模型中获取响应实体
                        HttpEntity responseEntity = response.getEntity();
                        if (responseEntity != null) {
                            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
                        }
                    } catch (IOException | ParseException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(5000);
            // 释放资源
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
