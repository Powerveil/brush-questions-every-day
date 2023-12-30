package com.power.study_2023_6.aa.service.impl;

import com.power.study_2023_6.aa.domain.Commodity;
import com.power.study_2023_6.aa.domain.Request;
import com.power.study_2023_6.aa.domain.Student;
import com.power.study_2023_6.aa.domain.SuperAdmin;
import com.power.study_2023_6.aa.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Powerveil
 * @Date 2023/6/11 19:00
 */
public class IServiceImpl implements IService {

    private List<SuperAdmin> superAdmins;
    private List<Student> students;
    private List<Commodity> commodities;
    private List<Request> requests;

    public IServiceImpl() {
        superAdmins = new ArrayList<>();
        students = new ArrayList<>();
        commodities = new ArrayList<>();
        requests = new ArrayList<>();
    }

    @Override
    // 增加超级管理员信息
    public void addSuperAdmin(String adminId, String name) {
        // 实现增加超级管理员信息的功能
        SuperAdmin superAdmin = new SuperAdmin(adminId, name);
        superAdmins.add(superAdmin);
        System.out.println("SuperAdmin added successfully.");
    }

    @Override
    // 删除超级管理员信息
    public void deleteSuperAdmin(String adminId) {
        // 实现删除超级管理员信息的功能
        for (SuperAdmin superAdmin : superAdmins) {
            if (superAdmin.getAdminId().equals(adminId)) {
                superAdmins.remove(superAdmin);
                System.out.println("SuperAdmin deleted successfully.");
                return;
            }
        }
        System.out.println("SuperAdmin not found.");
    }

    @Override
    // 增加学生信息
    public void addStudent(String studentId, String name, int age, String gender, String admissionDate, String campus, String college, String major, String className, boolean hasPublishPermission) {
        // 实现增加学生信息的功能
        Student student = new Student(studentId, name, age, gender, admissionDate, campus, college, major, className, hasPublishPermission);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    @Override
    // 删除学生信息
    public void deleteStudent(String studentId) {
        // 实现删除学生信息的功能
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @Override
    // 修改学生信息
    public void modifyStudent(String studentId, boolean hasPublishPermission) {
        // 实现修改学生信息的功能
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setHasPublishPermission(hasPublishPermission);
                System.out.println("Student modified successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @Override
    // 查询学生信息
    public void queryStudent(String studentId) {
        // 实现查询学生信息的功能
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @Override
    // 查询其他学生的姓名、性别、入学年月、所在校区、所在学院和所在专业信息
    public void queryOtherStudent(String studentId) {
        // 实现查询其他学生信息的功能
        for (Student student : students) {
            if (!student.getStudentId().equals(studentId)) {
                System.out.println(student.getName() + " " + student.getGender() + " " + student.getAdmissionDate() + " " + student.getCampus() + " " + student.getCollege() + " " + student.getMajor());
            }
        }
    }

    @Override
    // 增加二手商品信息
    public void addCommodity(String commodityId, String name, String description, String image, int quantity, double price, String studentId, String contact) {
        // 实现增加二手商品信息的功能
        Commodity commodity = new Commodity(commodityId, name, description, image, quantity, price, studentId, contact);
        commodities.add(commodity);
        System.out.println("Commodity added successfully.");
    }

    @Override
    // 删除二手商品信息
    public void deleteCommodity(String commodityId) {
        // 实现删除二手商品信息的功能
        for (Commodity commodity : commodities) {
            if (commodity.getCommodityId().equals(commodityId)) {
                commodities.remove(commodity);
                System.out.println("Commodity deleted successfully.");
                return;
            }
        }
        System.out.println("Commodity not found.");

    }

    @Override
    // 修改二手商品信息
    public void modifyCommodity(String commodityId, String name, String description, String image, int quantity, double price, String contact) {
        // 实现修改二手商品信息的功能
        for (Commodity commodity : commodities) {
            if (commodity.getCommodityId().equals(commodityId)) {
                commodity.setName(name);
                commodity.setDescription(description);
                commodity.setImage(image);
                commodity.setQuantity(quantity);
                commodity.setPrice(price);
                commodity.setContact(contact);
                System.out.println("Commodity modified successfully.");
                return;
            }
        }
        System.out.println("Commodity not found.");
    }

    @Override
    // 查询二手商品信息
    public void queryCommodity(String commodityId) {
        // 实现查询二手商品信息的功能
        for (Commodity commodity : commodities) {
            if (commodity.getCommodityId().equals(commodityId)) {
                System.out.println(commodity.toString());
                return;
            }
        }
        System.out.println("Commodity not found.");
    }

    @Override
    // 增加商品交易请求信息
    public void addRequest(String commodityId, String name, int quantity, double unitPrice, String studentId, String contact) {
        // 实现增加商品交易请求信息的功能
        Request request = new Request(commodityId, name, quantity, unitPrice, studentId, contact);
        requests.add(request);
        System.out.println("Request added successfully.");
    }

    @Override
    // 删除商品交易请求信息
    public void deleteRequest(String commodityId) {
        // 实现删除商品交易请求信息的功能
        for (Request request : requests) {
            if (request.getCommodityId().equals(commodityId)) {
                requests.remove(request);
                System.out.println("Request deleted successfully.");
                return;
            }
        }
        System.out.println("Request not found.");
    }

    @Override
    // 修改商品交易请求信息
    public void modifyRequest(String commodityId, int quantity, double unitPrice, String contact) {
        // 实现修改商品交易请求信息的功能
        for (Request request : requests) {
            if (request.getCommodityId().equals(commodityId)) {
                request.setQuantity(quantity);
                request.setUnitPrice(unitPrice);
                request.setContact(contact);
                System.out.println("Request modified successfully.");
                return;
            }
        }
        System.out.println("Request not found.");
    }

    @Override
    // 查询商品交易请求信息
    public void queryRequest(String studentId) {
        // 实现查询商品交易请求信息的功能
    }
}
