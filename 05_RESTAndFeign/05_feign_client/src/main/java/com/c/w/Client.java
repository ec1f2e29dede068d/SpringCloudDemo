package com.c.w;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public interface Client {

    @RequestLine("GET /stu/sum")
    String stringData();

    @RequestLine("POST /stu/{sid}")
    @Headers("Content-Type: application/json")
    Student jsonData(@Param("sid") Integer sid);

    @RequestLine("POST /stu/createstu")
    @Headers("Content-Type: application/xml")
    Result xmlData();

    @Data
    class Student {
        Integer sid;
        String sname;
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
