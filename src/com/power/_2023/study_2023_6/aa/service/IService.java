package com.power._2023.study_2023_6.aa.service;

public interface IService {
    void addSuperAdmin(String adminId, String name);
    void deleteSuperAdmin(String adminId);
    void addStudent(String studentId, String name, int age, String gender, String admissionDate, String campus, String college, String major, String className, boolean hasPublishPermission);
    void deleteStudent(String studentId);
    void modifyStudent(String studentId, boolean hasPublishPermission);
    void queryStudent(String studentId);
    void queryOtherStudent(String studentId);
    void addCommodity(String commodityId, String name, String description, String image, int quantity, double price, String studentId, String contact);
    void deleteCommodity(String commodityId);
    void modifyCommodity(String commodityId, String name, String description, String image, int quantity, double price, String contact);
    void queryCommodity(String commodityId);
    void addRequest(String commodityId, String name, int quantity, double unitPrice, String studentId, String contact);
    void deleteRequest(String commodityId);
    void modifyRequest(String commodityId, int quantity, double unitPrice, String contact);
    void queryRequest(String studentId);
    // 定义其他业务逻辑层和数据访问层之间的方法接口
}
