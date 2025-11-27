package com.keyin;

import com.keyin.campus.Campus;
import com.keyin.campus.CampusService;
import com.keyin.user.Admin;
import com.keyin.user.Student;
import com.keyin.user.User;
import com.keyin.user.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    static CampusService campusService = new CampusService();
    static UserService userService = new UserService();
    public static void main(String[] args) throws SQLException {


        User user;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Campus Management System!");
        System.out.println("Please select an option:");
        System.out.println("1: Login");
        System.out.println("2: Register");
        int option = scanner.nextInt();

        if(option == 1){
            System.out.println("Please enter your username:");
            String username = scanner.next();
            System.out.println("Please enter your password:");
            String password = scanner.next();
            user = userService.logInToSystem(username, password);
            if(user.getRole().equals("ADMIN")){
                adminMenu(user,scanner);
            }
            else if(user.getRole().equals("STUDENT")){
                studentMenu(user ,scanner);
            }
            else{
                System.out.println("Invalid role");
            }

        } else if (option == 2){
            System.out.println("Please enter your username:");
            String username = scanner.next();
            System.out.println("Please enter your password:");
            String password = scanner.next();
            System.out.println("Please enter your email:");
            String email = scanner.next();
            System.out.println("Please enter your phone number:");
            String phone = scanner.next();
            System.out.println("Please enter your campus ID:");
            int campusId = scanner.nextInt();
            System.out.println("Please enter your role (STUDENT or ADMIN):");
            String role = scanner.next();
            if(role.equals("STUDENT")){
                Student student = new Student(username, password, email, phone, campusId);
                userService.saveNewUser(student);
            }
            else if (role.equals("ADMIN")){
                Admin admin = new Admin(username,password,email,campusId,phone);
            }

        }

    }
    private static void studentMenu(User user, Scanner scanner) {
        System.out.println("Student Menu");
    }

    private static void adminMenu(User user, Scanner scanner) throws SQLException {
        System.out.println("Admin Menu");
        campusService.getNumberOfStudentsInCampus(2);
        campusService.getNumberOfSchoolCampusesInSystem();

    }
}
