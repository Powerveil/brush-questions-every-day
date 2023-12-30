package com.power.study_2023_6.test04;

public class Student {
    String id;            //学号
    String name;            //姓名
    int chengji;            //成绩
    public static int sumstu = 0;   //类变量,统计学生的数量

    public Student() {
    }

    public Student(String number) {
        this.id = number;
    }

    public Student(String id, String name, int chengji) {
        this.id = id;
        this.name = name;
        this.chengji = chengji;
    }

    void SetChengji(int n) {    //设置成绩
        this.chengji = n;
    }

    String Getname() {    //获取学生姓名
        return this.name;
    }

    int Getchengji() {    //获取学生成绩
        return this.chengji;
    }

    void print() {                   //输出一个学生的信息的方法.
        System.out.println("Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chengji=" + chengji +
                '}');
    }
}
