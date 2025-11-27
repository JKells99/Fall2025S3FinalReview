package com.keyin.user;

public class Admin extends User{

    public Admin(String userName, String password, String email,String phone ,int campusId) {
        super(userName, password, email, phone, campusId,"ADMIN");
    }

    public Admin() {
    }


    @Override
    public String toString() {
        return "Admin: " + super.toString();
    }
}