package com.power._2023.study_2023_6;

import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            System.out.println("成功连接到数据库！");

            createTableIfNotExists(conn);

            while (true) {
                System.out.println("学生信息管理系统");
                System.out.println("1. 显示所有学生信息");
                System.out.println("2. 添加学生信息");
                System.out.println("3. 删除学生信息");
                System.out.println("4. 修改学生信息");
                System.out.println("5. 查找学生信息");
                System.out.println("6. 按成绩排序显示学生信息");
                System.out.println("7. 统计学生人数");
                System.out.println("0. 退出系统");

                int choice = getIntegerInput("请选择功能：");

                switch (choice) {
                    case 1:
                        showAllStudents(conn);
                        break;
                    case 2:
                        addStudent(conn);
                        break;
                    case 3:
                        deleteStudent(conn);
                        break;
                    case 4:
                        updateStudent(conn);
                        break;
                    case 5:
                        searchStudent(conn);
                        break;
                    case 6:
                        showStudentsByScore(conn);
                        break;
                    case 7:
                        countStudents(conn);
                        break;
                    case 0:
                        System.out.println("感谢使用学生信息管理系统！");
                        return;
                    default:
                        System.out.println("无效的选择！");
                }

                System.out.println("------------------");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接错误：" + e.getMessage());
        }
    }

    private static void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "student_id INT," +
                "name VARCHAR(50)," +
                "gender VARCHAR(10)," +
                "birthdate DATE," +
                "class VARCHAR(50)," +
                "total_score INT" +
                ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    private static void addStudent(Connection conn) throws SQLException {
        int studentId = getIntegerInput("学生学号: ");
        String name = getStringInput("学生姓名: ");
        String gender = getStringInput("学生性别: ");
        String birthdate = getStringInput("学生出生年月(YYYY-MM-DD): ");
        String className = getStringInput("学生所在班级: ");
        int totalScore = getIntegerInput("学生总成绩: ");

        String sql = "INSERT INTO students (student_id, name, gender, birthdate, class, total_score) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, birthdate);
            pstmt.setString(5, className);
            pstmt.setInt(6, totalScore);
            pstmt.executeUpdate();
        }

        System.out.println("学生信息添加成功！");
    }

    private static void deleteStudent(Connection conn) throws SQLException {
        int studentId = getIntegerInput("请输入要删除的学生学号: ");

        String sql = "DELETE FROM students WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
        }

        System.out.println("学生信息删除成功！");
    }

    private static void updateStudent(Connection conn) throws SQLException {
        int studentId = getIntegerInput("请输入要修改的学生学号: ");
        int newTotalScore = getIntegerInput("请输入学生新的总成绩: ");

        String sql = "UPDATE students SET total_score = ? WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newTotalScore);
            pstmt.setInt(2, studentId);
            pstmt.executeUpdate();
        }

        System.out.println("学生信息修改成功！");
    }

    private static void searchStudent(Connection conn) throws SQLException {
        int studentId = getIntegerInput("请输入要查找的学生学号: ");

        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("学号: " + rs.getInt("student_id"));
                    System.out.println("姓名: " + rs.getString("name"));
                    System.out.println("性别: " + rs.getString("gender"));
                    System.out.println("出生年月: " + rs.getDate("birthdate"));
                    System.out.println("所在班级: " + rs.getString("class"));
                    System.out.println("总成绩: " + rs.getInt("total_score"));
                } else {
                    System.out.println("未找到该学生的信息！");
                }
            }
        }
    }

    private static void showStudentsByScore(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students ORDER BY total_score DESC";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                do {
                    System.out.println("学号: " + rs.getInt("student_id"));
                    System.out.println("姓名: " + rs.getString("name"));
                    System.out.println("性别: " + rs.getString("gender"));
                    System.out.println("出生年月: " + rs.getDate("birthdate"));
                    System.out.println("所在班级: " + rs.getString("class"));
                    System.out.println("总成绩: " + rs.getInt("total_score"));
                    System.out.println("------------------");
                } while (rs.next());
            } else {
                System.out.println("没有学生信息可显示！");
            }
        }
    }

    private static int getIntegerInput(String message) {
        int value = 0;
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValid) {
            try {
                System.out.print(message);
                value = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("请输入一个有效的整数！");
            }
        }

        return value;
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }

    // 显示所有学生信息
    private static void showAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("学号: " + rs.getInt("student_id"));
                System.out.println("姓名: " + rs.getString("name"));
                System.out.println("性别: " + rs.getString("gender"));
                System.out.println("出生年月: " + rs.getDate("birthdate"));
                System.out.println("所在班级: " + rs.getString("class"));
                System.out.println("总成绩: " + rs.getInt("total_score"));
                System.out.println("------------------");
            }
        }
    }

    // 统计学生人数
    private static void countStudents(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                int count = rs.getInt("count");
                System.out.println("学生总人数: " + count);
            }
        }
    }
}