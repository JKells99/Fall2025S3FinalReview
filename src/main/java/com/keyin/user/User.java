package com.keyin.user;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private int campusId;
    private String role;

    public User(String userName, String password, String email, String phone, int campusId, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.campusId = campusId;
        this.role = role;
    }

    public User(int userId, String userName, String password, String email, String phone, int campusId, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.campusId = campusId;
        this.role = role;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", campusId=" + campusId +
                ", role='" + role + '\'' +
                '}';
    }
}
