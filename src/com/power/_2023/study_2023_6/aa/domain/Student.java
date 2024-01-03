package com.power._2023.study_2023_6.aa.domain;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String gender;
    private String admissionDate;
    private String campus;
    private String college;
    private String major;
    private String className;
    private boolean hasPublishPermission;

    public Student(String studentId, String name, int age, String gender, String admissionDate, String campus, String college, String major, String className, boolean hasPublishPermission) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.admissionDate = admissionDate;
        this.campus = campus;
        this.college = college;
        this.major = major;
        this.className = className;
        this.hasPublishPermission = hasPublishPermission;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isHasPublishPermission() {
        return hasPublishPermission;
    }

    public void setHasPublishPermission(boolean hasPublishPermission) {
        this.hasPublishPermission = hasPublishPermission;
    }
}
