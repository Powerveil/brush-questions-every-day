package com.power._2023.study_2023_6.test04;

import java.io.IOException;
import java.util.*;

public class StudentInfo {
    public StudentInfo() {

    }

    public void Inputstu(Student a[]) throws IOException {
        String tmp;
        boolean flat = false;
        Scanner scanner = new Scanner(System.in);
        if (Student.sumstu == 0) {
//            System.out.println("请输入学生的学号");
//            String id=scanner.next();
//            System.out.println("请输入学生的姓名");
//            String name=scanner.next();
//            System.out.println("请输入学生的成绩");
//            int score=scanner.nextInt();
            //  Student student=new Student(id,name,score);
            Student student = new Student("1", "sss", 78);
            a[Student.sumstu++] = student;
        }
        do                      //检查学号的唯一性，如果重复，提示用户重新输入
        {
            System.out.print("  请输入学生的学号:");
            tmp = scanner.next();
            for (int i = 0; i < Student.sumstu; i++) {
                if (a[i].id.equals(tmp)) {
                    System.out.println("学号已经存在");
                    flat = false;
                } else {
                    break;
                }
            }
        } while (flat);
        if (Student.sumstu < a.length) {
            System.out.println("请输入学生的学号");
            String id = scanner.next();
            System.out.println("请输入学生的姓名");
            String name = scanner.next();
            System.out.println("请输入学生的成绩");
            int score = scanner.nextInt();
            Student student = new Student(id, name, score);
            a[Student.sumstu++] = student;
        } else System.out.println("学生数组已满，要扩容！");

    }


    public Student[] Topchengji(Student a[]) {      //查找成绩最高的学生

        Student[] students = new Student[10];
        int num = 0;
        int i = 0;
        int max = a[0].chengji;
        for (i = 0; i < Student.sumstu; i++) {
            if (a[i].chengji > max) {
                max = a[i].chengji;
            }
        }
        for (int j = 0; j < Student.sumstu; j++) {
            if (a[j].chengji == max) {
                students[num++] = a[j];
            }
        }
        for (int j = 0; j < num; j++) {
            System.out.println(students[j]);
        }
        return students;
    }


    public Student search(Student a[]) {        //查找学生

        String tmpname;
        int searchid = -1;
        Scanner sc = new Scanner(System.in);
        tmpname = sc.next();                     //按输入的姓名去查找
        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i].name.equals(tmpname)) {
                searchid = i;
                System.out.println("找到了");
                System.out.println(a[searchid]);
            }
        }
        if (searchid == -1) {

            System.out.println("没有符合条件的学生");
            return null;
        } else return a[searchid];

    }

    public void test(Student a[]) { //将成绩分段输出
        int num9_10 = 0;
        int num8_9 = 0;
        int num7_8 = 0;
        int num6_7 = 0;
        int num0_6 = 0;
        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i].chengji >= 0 && a[i].chengji < 60) {
                num0_6++;
                System.out.println("成绩小于60");
                a[i].print();
            } else if (a[i].chengji >= 60 && a[i].chengji < 70) {
                num6_7++;
                System.out.println("成绩在60——70");
                a[i].print();
            } else if (a[i].chengji >= 70 && a[i].chengji < 80) {
                num7_8++;
                System.out.println("成绩在70——80");
                a[i].print();
            } else if (a[i].chengji >= 80 && a[i].chengji < 90) {
                num8_9++;
                System.out.println("成绩在80——90");
                a[i].print();
            } else {
                num9_10++;
                System.out.println("成绩在90——100");
                a[i].print();
            }
        }
        System.out.println("成绩在0-60的有" + num0_6 + "个人");
        System.out.println("成绩在60-70的有" + num6_7 + "个人");
        System.out.println("成绩在70-80的有" + num7_8 + "个人");
        System.out.println("成绩在80-90的有" + num8_9 + "个人");
        System.out.println("成绩在90-100的有" + num9_10 + "个人");
    }

    public Student change(String name, Student a[]) { //修改给定名字的学生成绩
        Student stu1 = null;
        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i].name.equals(name))
                stu1 = a[i];
        }
        stu1.chengji = 12;
        return stu1;
    }

    double Pingfen(Student a[]) {        //求所有学生的成绩平均分
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < Student.sumstu; i++) {
            sum += a[i].chengji;
        }
        avg = sum / a.length;
        System.out.println("平均成绩是：" + avg);
        return avg;
    }

    public Student[] sortcj(Student[] stu1) {                         //按成绩排序，放到新的数组中
        Student[] student = new Student[10];
        for (int i = 0; i < Student.sumstu; i++) {
            student[i] = stu1[i];
        }
        Comparator<Student> cmp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.chengji - o2.chengji;
            }
        };
        Arrays.sort(student, cmp);
        for (int i = 0; i < Student.sumstu; i++)
            student[i].print();
        return student;
    }

    public class idcom implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id.compareTo(o2.id);
        }
    }

    public Student[] sortxh(Student[] stu1) {                         //按学号id排序，放到新的数组中

        Student[] sortstu = new Student[Student.sumstu];         //声明新数组
        int i, j, k;
        Student temp = new Student();
        for (i = 0; i < Student.sumstu; i++) {                   //将要排序的数组拷贝到新数组，创建对象时调用不带参数的构造函数，学生人数不增加
            sortstu[i] = stu1[i];
        }
        Comparator cmp = new idcom();
        Arrays.sort(sortstu, cmp);
        for (i = 0; i < Student.sumstu; i++)
            sortstu[i].print();        //输出打印
        return sortstu;
    }

    public class namecom implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public Student[] sortname(Student[] stu1) {                         //按姓名排序，放到新的数组中
        Student[] sortstu = new Student[Student.sumstu];         //声明新数组
        int i, j, k;
        Student temp = new Student();
        for (i = 0; i < Student.sumstu; i++) {                   //将要排序的数组拷贝到新数组，创建对象时调用不带参数的构造函数，学生人数不增加
            sortstu[i] = stu1[i];
        }
        Comparator cmp = new namecom();
        Arrays.sort(sortstu, cmp);
        for (i = 0; i < Student.sumstu; i++)
            sortstu[i].print();        //输出打印
        return sortstu;

    }

    public Student[] kuorong(Student[] stu1) {
//扩容，增加20人
//声明新数组
//将原数组拷贝到新数组，创建对象时调用不带参数的构造函数，学生人数不增加
        Student[] studentnew = new Student[30];
        for (int i = 0; i < Student.sumstu; i++) {
            studentnew[i] = stu1[i];
        }
        System.out.println("扩容正在进行中");
        System.out.println("扩容完成");
        return studentnew;
    }


    void print(Student a[]) {        //输出学生数组中每个学生的信息
        for (int i = 0; i < Student.sumstu; i++)
            a[i].print();
    }

}
