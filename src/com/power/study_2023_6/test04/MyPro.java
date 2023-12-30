package com.power.study_2023_6.test04;


import java.io.IOException;
import java.util.*;

public class MyPro {
    public static void main(String[] args) throws IOException { //异常处理
//        Student[] students = new Student[3];
//        StudentInfo studentInfo = new StudentInfo();
//        Scanner scanner = new Scanner(System.in);
//        int select = 0;
//        do {
//            System.out.println("1）录入学生成绩信息");
//            System.out.println("2）显示学生成绩信息");
//            System.out.println("3）计算平均成绩");
//            System.out.println("4）显示最高成绩");
//            System.out.println("5）按姓名查找学生信息");
//            System.out.println("6）修改学生成绩信息");
//            System.out.println("7）按成绩排序学生信息");
//            System.out.println("8）按学号排序学生信息");
//            System.out.println("9）按姓名排序学生信息");
//            System.out.println("10）学生对象数组扩容");
//            System.out.println("11）学生成绩分段输出");
//            System.out.println("请输入您要选择的功能：");
//            select = scanner.nextInt();
//            switch (select) {
//                case 1:
//                    studentInfo.Inputstu(students);
//                    break;
//                case 2:
//                    studentInfo.print(students);
//                    break;
//                case 3:
//                    studentInfo.Pingfen(students);
//                    break;
//                case 4:
//                    studentInfo.Topchengji(students);
//                    break;
//                case 5:
//                    studentInfo.search(students);
//                    break;
//                case 6:
//                    studentInfo.change("zhangsan", students);
//                    break;
//                case 7:
//                    studentInfo.sortcj(students);
//                    break;
//                case 8:
//                    studentInfo.sortxh(students);
//                    break;
//                case 9:
//                    studentInfo.sortname(students);
//                    break;
//                case 10:
//                    studentInfo.kuorong(students);
//                    break;
//                case 11:
//                    studentInfo.test(students);
//                    break;
//            }
//        } while (select != 0);

//        ArrayList<Integer> objects = new ArrayList<>();
//        Collections.sort(objects, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.intValue() - o2.intValue();
//            }
//        });

        Student[] student = new Student[10];
        Comparator<Student> cmp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.chengji - o2.chengji;
            }
        };
        Arrays.sort(student, cmp);
    }
}
