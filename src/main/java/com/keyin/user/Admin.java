package com.keyin.user;

public class Admin extends User{

    public Admin(String userName, String password, String email, String phone, double salary, boolean isProfessor) {
        super(userName, password, email, phone, "ADMIN");
    }

    public Admin() {
    }


    @Override
    public String toString() {
        return "Admin: " + super.toString();
    }
}
