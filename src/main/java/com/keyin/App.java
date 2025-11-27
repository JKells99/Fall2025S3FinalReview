package com.keyin;

import com.keyin.campus.Campus;
import com.keyin.campus.CampusDAO;
import com.keyin.campus.CampusService;
import com.keyin.user.Admin;
import com.keyin.user.Student;
import com.keyin.user.User;
import com.keyin.user.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    static UserService userService = new UserService();
    static CampusService campusService = new CampusService();
    public static void main(String[] args) throws Exception {

//        Campus campus = new Campus("Keyin Campus Bay Roberts", "123 Main St", "123-456-7890");
//        campusService.saveNewCampus(campus);
//        campusService.getAllCampuses();
//        System.out.println();
//        campusService.deleteCampus(4);
//        System.out.println("After deletion:");
//        campusService.getAllCampuses();
//        campusService.updateCampus(11,"Keyin Carbonear","12 Lemarchant Street","123-456-7890");
//        System.out.println("After update:");
//        campusService.getAllCampuses();
//        userService.getNumberOfStudentsForCampusByCampusId(2);
//        userService.getNumberOfStudentsForEachCampus();

//        Student student = new Student("John", "Doe", "student@student.com", "1234567890", 1);
//        userService.saveNewUser(student);
        User user = null;
        Scanner scanner = new Scanner(System.in);

        displayWelcomeMenu(scanner,user);


    }

    private static void displayWelcomeMenu(Scanner scanner,User user) throws SQLException {
        System.out.println("Welcome to the Campus Management System");
        System.out.println("Please Select an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                loginMenu(scanner,user);
                break;
            case 2:
                registerMenu(scanner);
                break;
        }
    }

    private static void registerMenu(Scanner scanner) {
        System.out.println("Register Menu....");
        System.out.println("--------------------");
        System.out.println("Enter your username:");
        String userName = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();
        System.out.println("Enter your email:");
        String email = scanner.next();
        System.out.println("Enter your phone number:");
        String phone = scanner.next();
        System.out.println("Enter your role (STUDENT/ADMIN):");
        String role = scanner.next();
        System.out.println("Enter your campus id:");
        int campusId = scanner.nextInt();


        if(role.equalsIgnoreCase("STUDENT")){
            Student student = new Student(userName,password,email,phone,campusId);
            userService.saveNewUser(student);
            System.out.println("Registration Successful");
        }

        if (role.equalsIgnoreCase("ADMIN")){
            Admin admin = new Admin(userName,password,email,phone,campusId);
            userService.saveNewUser(admin);
            System.out.println("Registration Successful");
        }
    }

    private static void loginMenu(Scanner scanner,User user) throws SQLException {
        System.out.println("Login Menu....");
        System.out.println("--------------------");
        System.out.println("Enter your username:");
        String userName = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();
        user = userService.logInToSystem(userName,password);

        if(user != null && user.getRole().equalsIgnoreCase("ADMIN")){
           adminMenu(scanner);
        } else if(user != null && user.getRole().equalsIgnoreCase("STUDENT")){
            studentMenu(scanner);
        }

    }

    private static void studentMenu(Scanner scanner) {
        System.out.println("Student Menu....");
    }

    private static void adminMenu(Scanner scanner) throws SQLException {
        System.out.println("Admin Menu....");
        System.out.println("--------------------");
        System.out.println("Please select an option:");
        System.out.println("1. Number of students for each campus");
        System.out.println("2. Number of students for a specific campus");

        int choice = scanner.nextInt();
        if (choice== 1){
            userService.getNumberOfStudentsForEachCampus();
        } else if (choice == 2){
            System.out.println("Enter the campus id:");
            int campusId = scanner.nextInt();
            userService.getNumberOfStudentsForCampusByCampusId(campusId);
        }

    }

}
