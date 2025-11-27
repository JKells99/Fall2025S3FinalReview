package com.keyin;

import com.keyin.campus.Campus;
import com.keyin.campus.CampusService;
import com.keyin.user.Admin;
import com.keyin.user.Student;
import com.keyin.user.User;
import com.keyin.user.UserService;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        CampusService campusService = new CampusService();
        UserService userService = new UserService();


//        Admin admin = new Admin("admin3", "admin", "admin2@admin.com",1,"0123456789", 10000, true);
//        userService.saveNewUser(admin);
//
//        Admin admin2 = new Admin("admin4", "admin2", "Admin4@admin.com",2,"0123456789", 10000, true);
//        userService.saveNewUser(admin2);

        Student student = new Student("student3", "student", "student@school.com","123-123123","Comp Sci",1,2);
        userService.saveNewUser(student);
        campusService.getAllCampuses();

        userService.getAllUsersByCampusId(1);





    }
}
