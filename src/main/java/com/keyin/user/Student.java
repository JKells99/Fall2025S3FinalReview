package com.keyin.user;

public class Student extends User{


    public Student(String userName, String password, String email, String phone, String major, int year,int campusId) {
        super(userName, password, email, phone,campusId, "STUDENT");

    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
