package com.power._2022.study_2022_12;


import java.util.ArrayList;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Test {
    private Test() {
    }

    private static class SingletonHelp {
        static Test instance = new Test();
        static ArrayList<Integer> list = new ArrayList<>();
    }

    public static Test getInstance() {
        return SingletonHelp.instance;
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}



