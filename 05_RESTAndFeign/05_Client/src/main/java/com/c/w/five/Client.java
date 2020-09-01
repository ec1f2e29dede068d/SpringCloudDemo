package com.c.w.five;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author C
 */
public interface Client {

    /**
     *
     * @return
     */
    @RequestLine("GET /stu/sum")
    String stringData();

    /**
     * 根据id获取学生信息
     * @param sid 学生id
     * @return 学生对象
     */
    @RequestLine("POST /stu/{sid}")
    @Headers("Content-Type: application/json")
    Student jsonData(@Param("sid") Integer sid);

    @RequestLine("POST /stu/createstu")
    @Headers("Content-Type: application/xml")
    Result xmlData();

    @Data
    class Student {
        Integer sid;
        String sName;
        int chinese;
        int math;
        int english;
    }

    @Data
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    class Result{
        @XmlElement
        String average;
    }

}
