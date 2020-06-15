package com.c.w;

public class Student {

    private Integer sid;
    private String sname;
    private int chinese;
    private int math;
    private int english;

    public Student(Integer sid, String sname, int chinese, int math, int english) {
        this.sid = sid;
        this.sname = sname;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    @Override
    public String toString() {
        return getSid() + "\n" + getSname() + "\n" + getEnglish()
                + "\n" + getMath() + "\n" + getChinese();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
}
