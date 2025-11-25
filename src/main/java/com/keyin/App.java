package com.keyin;

import com.keyin.user.Admin;
import com.keyin.user.User;
import com.keyin.user.UserService;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();

        Admin admin = new Admin("admin1", "password123", "admin@school.com", "123-123-1233", 100000, true);
//        userService.saveNewUser(admin);
        User searchedUser = userService.getUserByUserName("admin1");

        System.out.println(searchedUser);
    }
}
