package com.power._2022.study_2022_12.test;

import java.io.*;
import java.util.Objects;

/**
 * @author power
 * @Date 2022/12/26 22:47
 */
public class Test02 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {// Try-with-resources
// do something
        } catch (IOException e) {// Multiple catch
            e.printStackTrace();
// Handle it
        }

    }

//    public void readPreferences(String filename) {
//        Objects.requireNonNull(filename);
////...perform other operations...
//        InputStream in = new FileInputStream(filename);
////...read the preferences file...
//    }
}
