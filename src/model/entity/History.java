package model.entity;

import java.util.Date;

public class History {
    public Integer id;
    public String status;
    public String productName;
    public String category;
    public Integer quantity;
    public String staff;
    public String phoneNumber;
    public Date date;

    public History(Integer id, String status, String productName, String category, Integer quantity, String staff, String phoneNumber, Date date) {
        this.id = id;
        this.status = status;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.staff = staff;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
