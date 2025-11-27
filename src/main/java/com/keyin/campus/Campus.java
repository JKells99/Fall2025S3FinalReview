package com.keyin.campus;

public class Campus {
    private int campusId;
    private String campusName;
    private String address;
    private String phone;

    public Campus(String campusName, String address, String phone) {
        this.campusName = campusName;
        this.address = address;
        this.phone = phone;
    }
    public Campus() {
    }
    public int getCampusId() {
        return campusId;
    }
    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }
    public String getCampusName() {
        return campusName;
    }
    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "campusId=" + campusId +
                ", campusName='" + campusName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
