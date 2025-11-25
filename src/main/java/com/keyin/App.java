package com.keyin;

import com.keyin.user.Admin;
import com.keyin.user.User;
import com.keyin.user.UserService;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();

        Admin admin = new Admin("admin2", "password123", "admin2@school.com", "123-123-1233", 100000, true);
//        userService.saveNewUser(admin);
        User userToLogIn = userService.logInToSystem("admin2", "password123");

        if(userToLogIn.getRole().equals("ADMIN")){
            System.out.println("Logged in as admin");
        }
        if(userToLogIn.getRole().equals("STUDENT")){
            System.out.println("Logged in as student");
        }


    }
}
