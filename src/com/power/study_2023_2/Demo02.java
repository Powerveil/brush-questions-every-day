package com.power.study_2023_2;

import com.power.study_2022_12.test.Demo;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author power
 * @Date 2023/2/26 22:29
 */
public class Demo02 {
    int a = 10;

    public static void main(String[] args) throws IOException {
        int[] nums = new int[10];
        File file = new File("D:/HelloWorld.txt");
        file.createNewFile();


        File dir = new File("D:/10Test");
        dir.mkdirs();


        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }


        StringBuffer stringBuilder = new StringBuffer();
        StringBuffer stringBuilder1 = new StringBuffer();
//        stringBuilder + stringBuilder1

//        Statement statement = new Statement();
//        statement.executeUpdate();
//        statement.executeQuery();


    }


}

abstract class A {
    int aaa;
}
