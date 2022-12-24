package com.power.study_2022_12.test;

import java.io.*;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        Rectangle rectangle = new Rectangle(10, 5);
//        rectangle.showAll();
//        FileInputStream fileInputStream = new FileInputStream("d:\\stop_words.txt");
//        byte[] data = new byte[1024];
//        int len = 0;
//        while ((len = fileInputStream.read(data)) != 0) {
//            System.out.println(data.toString());
//        }
//
//        fileInputStream.close();


//        BufferedInputStream buf = new BufferedInputStream(new FileInputStream("d:\\stop_words.txt"));
//        byte[] data = new byte[1024];
//        int len = 0;
//        while ((len = buf.read(data)) != -1) {
//            System.out.println(data.toString());
//        }
//
//        buf.close();


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/stop_words.txt")));
        String content;
        while ((content = br.readLine()) != null) {
            System.out.println(content);
        }

        br.close();


    }
}
