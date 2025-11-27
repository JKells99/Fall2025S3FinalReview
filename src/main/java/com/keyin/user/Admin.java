package com.keyin.user;

public class Admin extends User{

    public Admin(String userName, String password, String email,int campusId ,String phone) {
        super(userName, password, email, phone, campusId,"ADMIN");
    }

    public Admin() {
    }


    @Override
    public String toString() {
        return "Admin: " + super.toString();
    }
}
