package com.power.study_2023_6.aa.domain;

public class Request {
    private String commodityId;
    private String name;
    private int quantity;
    private double unitPrice;
    private String studentId;
    private String contact;

    public Request(String commodityId, String name, int quantity, double unitPrice, String studentId, String contact) {
        this.commodityId = commodityId;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.studentId = studentId;
        this.contact = contact;
    }


    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
