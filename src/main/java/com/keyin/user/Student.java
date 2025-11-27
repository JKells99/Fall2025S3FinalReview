package com.keyin.user;

public class Student extends User{


    public Student(String userName, String password, String email, String phone ,int campusId) {
        super(userName, password, email, phone,campusId, "STUDENT");

    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
