package com.power._2023.study_2023_6;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LabManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lab_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
// 示例：添加实验室
            addLab(connection, "10", "Chemistry", 30, 0);

            // 示例：查询实验室
            queryLab(connection, "10");

            // 示例：删除实验室
            deleteLab(connection, "10");

            // 示例：修改实验室
            updateLab(connection, "11", "Physics", 40, 1);

            // 示例：添加教师
            addTeacher(connection, "12", "张三", "副教授");

            // 示例：查询教师
            queryTeacher(connection, "12");

            // 示例：查询仪器
            queryInstrument(connection, "12");

            // 示例：添加仪器
            addInstrument(connection, "12", "电子天平", "电子仪器", 5, 0);

            // 示例：修改仪器状态
            updateInstrumentStatus(connection, "12", 1);

            // 示例：实验室申请
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date startTime = (Date) dateFormat.parse("2023-06-08 09:00:00");
            Date endTime = (Date) dateFormat.parse("2023-06-08 12:00:00");
            applyForLab(connection, "11", "12", startTime, endTime);

            // 示例：仪器故障登记
            registerInstrumentFault(connection, 1, "12", new Date(System.currentTimeMillis()));

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void addLab(Connection connection, String labId, String labName, int labCapacity, int labStatus) throws SQLException {
        String sql = "INSERT INTO lab (lab_id, lab_name, lab_type, lab_capacity, lab_status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, labId);
            preparedStatement.setString(2, labName);
            preparedStatement.setString(3, "chemistry");
            preparedStatement.setInt(4, labCapacity);
            preparedStatement.setInt(5, labStatus);
            preparedStatement.executeUpdate();
            System.out.println("实验室添加成功");
        }
    }

    private static void queryLab(Connection connection, String labId) throws SQLException {
        String sql = "SELECT * FROM lab WHERE lab_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, labId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("实验室编号：" + resultSet.getString("lab_id"));
                System.out.println("实验室名称：" + resultSet.getString("lab_name"));
                System.out.println("实验室类型：" + resultSet.getString("lab_type"));
                System.out.println("实验室容量：" + resultSet.getInt("lab_capacity"));
                System.out.println("实验室状态：" + resultSet.getInt("lab_status"));
            } else {
                System.out.println("未查询到对应的实验室");
            }
            resultSet.close();
        }
    }


    // 1.实验室删除功能
    private static void deleteLab(Connection connection, String labId) throws SQLException {
        String sql = "DELETE FROM lab WHERE lab_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, labId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("实验室删除成功");
            } else {
                System.out.println("未查询到对应的实验室");
            }
        }
    }

    // 2.实验室修改功能
    private static void updateLab(Connection connection, String labId, String labName, int labCapacity, int labStatus) throws SQLException {
        String sql = "UPDATE lab SET lab_name = ?, lab_capacity = ?, lab_status = ? WHERE lab_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, labName);
            preparedStatement.setInt(2, labCapacity);
            preparedStatement.setInt(3, labStatus);
            preparedStatement.setString(4, labId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("实验室修改成功");
            } else {
                System.out.println("未查询到对应的实验室");
            }
        }
    }

    // 3.添加教师功能
    private static void addTeacher(Connection connection, String teacherId, String teacherName, String teacherTitle) throws SQLException {
        String sql = "INSERT INTO teacher (teacher_id, teacher_name, teacher_title) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, teacherId);
            preparedStatement.setString(2, teacherName);
            preparedStatement.setString(3, teacherTitle);
            preparedStatement.executeUpdate();
            System.out.println("教师添加成功");
        }
    }

    // 4.查询教师功能
    private static void queryTeacher(Connection connection, String teacherId) throws SQLException {
        String sql = "SELECT * FROM teacher WHERE teacher_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, teacherId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("教师编号：" + resultSet.getString("teacher_id"));
                System.out.println("教师姓名：" + resultSet.getString("teacher_name"));
                System.out.println("教师职称：" + resultSet.getString("teacher_title"));
            } else {
                System.out.println("未查询到对应的教师");
            }
            resultSet.close();
        }
    }

    // 5.查询仪器功能
    private static void queryInstrument(Connection connection, String instrumentId) throws SQLException {
        String sql = "SELECT * FROM instrument WHERE instrument_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, instrumentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("仪器编号：" + resultSet.getString("instrument_id"));
                System.out.println("仪器名称：" + resultSet.getString("instrument_name"));
                System.out.println("仪器类型：" + resultSet.getString("instrument_type"));
                System.out.println("仪器数量：" + resultSet.getInt("instrument_quantity"));
                System.out.println("仪器状态：" + resultSet.getInt("instrument_status"));
            } else {
                System.out.println("未查询到对应的仪器");
            }
            resultSet.close();
        }
    }


    // 6.添加仪器功能
    private static void addInstrument(Connection connection, String instrumentId, String instrumentName, String instrumentType, int instrumentQuantity, int instrumentStatus) throws SQLException {
        String sql = "INSERT INTO instrument (instrument_id, instrument_name, instrument_type, instrument_quantity, instrument_status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, instrumentId);
            preparedStatement.setString(2, instrumentName);
            preparedStatement.setString(3, instrumentType);
            preparedStatement.setInt(4, instrumentQuantity);
            preparedStatement.setInt(5, instrumentStatus);
            preparedStatement.executeUpdate();
            System.out.println("仪器添加成功");
        }
    }


    // 7.修改仪器状态功能
    private static void updateInstrumentStatus(Connection connection, String instrumentId, int instrumentStatus) throws SQLException {
        String sql = "UPDATE instrument SET instrument_status = ? WHERE instrument_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, instrumentStatus);
            preparedStatement.setString(2, instrumentId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("仪器状态修改成功");
            } else {
                System.out.println("未查询到对应的仪器");
            }
        }
    }

    // 8.实验室申请功能
    private static void applyForLab(Connection connection, String labId, String teacherId, Date startTime, Date endTime) throws SQLException {
        // 首先检查实验室状态是否可用
        String checkLabStatusSql = "SELECT lab_status FROM lab WHERE lab_id = ?";
        try (PreparedStatement checkLabStatusStatement = connection.prepareStatement(checkLabStatusSql)) {
            checkLabStatusStatement.setString(1, labId);
            ResultSet labStatusResultSet = checkLabStatusStatement.executeQuery();
            if (!labStatusResultSet.next() || labStatusResultSet.getInt("lab_status") != 0) {
                System.out.println("实验室不可用");
                return;
            }
        }

        // 然后检查所需仪器状态是否可用
        String checkInstrumentStatusSql = "SELECT instrument_status FROM instrument WHERE instrument_id IN (SELECT instrument_id FROM application_instrument WHERE application_id = ?)";
        try (PreparedStatement checkInstrumentStatusStatement = connection.prepareStatement(checkInstrumentStatusSql)) {
            // 先创建一个新的申请记录
            String createApplicationSql = "INSERT INTO application (lab_id, teacher_id, application_date, start_time, end_time, application_status) VALUES (?, ?, NOW(), ?, ?, 0)";
            try (PreparedStatement createApplicationStatement = connection.prepareStatement(createApplicationSql, Statement.RETURN_GENERATED_KEYS)) {
                createApplicationStatement.setString(1, labId);
                createApplicationStatement.setString(2, teacherId);
                createApplicationStatement.setTimestamp(3, new Timestamp(startTime.getTime()));
                createApplicationStatement.setTimestamp(4, new Timestamp(endTime.getTime()));
                createApplicationStatement.executeUpdate();

                // 获取新创建的申请记录的ID
                ResultSet generatedKeys = createApplicationStatement.getGeneratedKeys();
                generatedKeys.next();
                int applicationId = generatedKeys.getInt(1);

                // 检查所需仪器状态是否可用
                checkInstrumentStatusStatement.setInt(1, applicationId);
                ResultSet instrumentStatusResultSet = checkInstrumentStatusStatement.executeQuery();
                while (instrumentStatusResultSet.next()) {
                    if (instrumentStatusResultSet.getInt("instrument_status") != 0) {
                        System.out.println("仪器不可用");
                        return;
                    }
                }

                // 如果实验室和所需仪器都可用，则将实验室状态设置为已占用
                String updateLabStatusSql = "UPDATE lab SET lab_status = 1 WHERE lab_id = ?";
                try (PreparedStatement updateLabStatusStatement = connection.prepareStatement(updateLabStatusSql)) {
                    updateLabStatusStatement.setString(1, labId);
                    updateLabStatusStatement.executeUpdate();
                    System.out.println("申请成功，申请编号为：" + applicationId);
                }
            }
        }
    }

    // 9.仪器故障登记功能
    private static void registerInstrumentFault(Connection connection, int applicationId, String instrumentId, Date useTime) throws SQLException {
        // 首先检查该申请记录是否存在
        String checkApplicationSql = "SELECT * FROM application WHERE application_id = ?";
        try (PreparedStatement checkApplicationStatement = connection.prepareStatement(checkApplicationSql)) {
            checkApplicationStatement.setInt(1, applicationId);
            ResultSet applicationResultSet = checkApplicationStatement.executeQuery();
            if (!applicationResultSet.next()) {
                System.out.println("申请记录不存在");
                return;
            }
        }

        // 然后检查该仪器是否存在
        String checkInstrumentSql = "SELECT * FROM instrument WHERE instrument_id = ?";
        try (PreparedStatement checkInstrumentStatement = connection.prepareStatement(checkInstrumentSql)) {
            checkInstrumentStatement.setString(1, instrumentId);
            ResultSet instrumentResultSet = checkInstrumentStatement.executeQuery();
            if (!instrumentResultSet.next()) {
                System.out.println("仪器不存在");
                return;
            }
        }

        // 最后创建一条新的仪器使用记录，表示该仪器出现故障
        String sql = "INSERT INTO instrument_record (application_id, instrument_id, use_time, record_status) VALUES (?, ?, ?, 1)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, applicationId);
            preparedStatement.setString(2, instrumentId);
            preparedStatement.setTimestamp(3, new Timestamp(useTime.getTime()));
            preparedStatement.executeUpdate();
            System.out.println("仪器故障登记成功");
        }
    }
}