package com.power.study_2023_6.aa.domain;

public class SuperAdmin {
    private String adminId;
    private String name;

    public SuperAdmin(String adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
