package com.c.w.fourteen;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stu")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String uid;
    String username;
    String password;
    Integer chinese;
    Integer math;
    Integer english;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StuClass.class)
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    StuClass stuClass;

    public User() {
        super();
    }

    public User(String uid, String username, String password) {
        super();
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User(String uid, String username, String password, Integer cid, Integer chinese, Integer math, Integer english) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer rchinese) {
        this.chinese = rchinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer rmath) {
        this.math = rmath;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer renglish) {
        this.english = renglish;
    }
}
