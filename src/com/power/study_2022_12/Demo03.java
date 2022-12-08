package com.power.study_2022_12;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
//        int[] a = {6, 3, 2, 10, 8};
//        Arrays.sort(a);


//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/students";
//        String user = "root";
//        String password = "root";
//        Connection connection = DriverManager.getConnection(url, user, password);
//        String sql = "delete from stu where id = 5";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.executeUpdate();
//        if (connection != null) {
//            connection.close();
//        }
//        if (preparedStatement != null) {
//            preparedStatement.close();
//        }


//
//        StringBuffer bf = new StringBuffer("zhang,wang,zhao,li");
//        String[] split = bf.toString().split(",");
//        Random random = new Random();
//        System.out.println(split[random.nextInt(4)]);

        // 使用 Scanner 读文本文件
        InputStream inputStream = new FileInputStream("D:\\source\\src.txt");

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        inputStream.close();

    }
}
