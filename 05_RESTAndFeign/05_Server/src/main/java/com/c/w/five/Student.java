package com.c.w.five;

/**
 * @author C
 */
public class Student {

    private Integer sid;
    private String sName;
    private int chinese;
    private int math;
    private int english;

    public Student() {

    }

    public Student(Integer sid, String sName, int chinese, int math, int english) {
        this.sid = sid;
        this.sName = sName;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    @Override
    public String toString() {
        return getSid() + "\n" + getsName() + "\n" + getEnglish()
                + "\n" + getMath() + "\n" + getChinese();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
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
