package com.keyin;

import com.keyin.campus.Campus;
import com.keyin.campus.CampusService;
import com.keyin.course.CourseService;
import com.keyin.enrollment.Enrollment;
import com.keyin.enrollment.EnrollmentService;
import com.keyin.logger.Logger;
import com.keyin.user.Admin;
import com.keyin.user.Student;
import com.keyin.user.User;
import com.keyin.user.UserService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static UserService userService = new UserService();
    static CampusService campusService = new CampusService();
   static CourseService courseService = new CourseService();
   static EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) throws Exception {

        // THIS IS TEST STUFF IN CASE YOU NEED IT!


//        Campus campus = new Campus("Keyin Campus Carbonear 4", "123 Main St", "123-456-7890");
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

//        Enrollment enrollment = new Enrollment(5,1,"ACTIVE");
//        enrollmentService.addNewEnrollment(enrollment);

//        courseService.getStudentInCourseByCourseName("CS101");
//        Course course = new Course("Java S3","How to write code in Java",3);
//        courseService.saveNewCourse(course);
//
//        Student student = new Student("stu1","123456","","1234567890",3);
//        userService.saveNewUser(student);



        User user = null;
        Scanner scanner = new Scanner(System.in);

        displayWelcomeMenu(scanner);


    }

    private static void displayWelcomeMenu(Scanner scanner) throws SQLException {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Campus Management System");
            System.out.println("Please Select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    loginMenu(scanner);
                    break;
                case 2:
                    registerMenu(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
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

    private static void loginMenu(Scanner scanner) throws SQLException {
        System.out.println("Login Menu....");
        Logger.traceLog("User attempting to login");
        System.out.println("--------------------");
        System.out.println("Enter your username:");
        String userName = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();
        User user = userService.logInToSystem(userName,password);
        loginRoleCheck(user,scanner);
    }


    // THIS IS THE MOST IMPORTANT METHOD IN THE APPLICATION FOR RBAC ( Role Based Access Control )
    private static void loginRoleCheck(User user, Scanner scanner) throws SQLException {
        if(user != null && user.getRole().equalsIgnoreCase("ADMIN")){
            adminMenu(scanner);
        } else if(user != null && user.getRole().equalsIgnoreCase("STUDENT")){
            studentMenu(scanner,user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void studentMenu(Scanner scanner,User user) throws SQLException {
        boolean inStudentMenu = true;
        while (inStudentMenu) {
            System.out.println("Student Menu....");
            System.out.println("--------------------");
            System.out.println("1. Enroll in a course");
            System.out.println("2. Logout to main menu");
            System.out.println("3. Exit application");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            if (choice == 1) {
                enrollmentMenu(scanner,user);
            } else if (choice == 2) {
                System.out.println("Logging out to main menu...");
                inStudentMenu = false;
            } else if (choice == 3) {
                System.out.println("Exiting application...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void enrollmentMenu(Scanner scanner, User user) throws SQLException {
        System.out.println("Enrollment Menu....");
        courseService.printAllCourses();
        System.out.println("--------------------");
        System.out.println("Enter the course id to enroll:");
        int courseId = scanner.nextInt();
        Enrollment enrollment = new Enrollment(user.getUserId(),courseId,"ACTIVE");
        enrollmentService.addNewEnrollment(enrollment);

    }

    private static void adminMenu(Scanner scanner) throws SQLException {
        boolean inAdminMenu = true;
        while (inAdminMenu) {
            System.out.println("....Admin Menu....");
            System.out.println("--------------------");
            System.out.println("Please select an option:");
            System.out.println("1. Number of students for each campus");
            System.out.println("2. Number of students for a specific campus");
            System.out.println("3. Add new campus");
            System.out.println("4: Get All Student Info From Specific Course");
            System.out.println("5. Logout to main menu");
            System.out.println("6. Exit application");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            if (choice== 1){
                userService.getNumberOfStudentsForEachCampus();
            } else if (choice == 2){
                getStudentNumberByCampusId(scanner);
            } else if (choice == 3){
                createCampusMenu(scanner);
            } else if (choice == 4) {
                findStudentInfoByCourseNameMenu(scanner);
            } else if (choice == 5) {
                System.out.println("Logging out to main menu...");
                inAdminMenu = false;
            } else if (choice == 6) {
                System.out.println("Exiting application...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void findStudentInfoByCourseNameMenu(Scanner scanner) throws SQLException {
        System.out.println("Enter the course name:");
        String courseName = scanner.next();
        courseService.getStudentInCourseByCourseName(courseName);
    }

    private static void createCampusMenu(Scanner scanner) {
        System.out.println("Enter the campus name:");
        String campusName = scanner.next();
        System.out.println("Enter the address:");
        String address = scanner.next();
        System.out.println("Enter the phone number:");
        String phone = scanner.next();
        Campus campus = new Campus(campusName,address,phone);
        campusService.saveNewCampus(campus);
    }

    private static void getStudentNumberByCampusId(Scanner scanner) throws SQLException {
        System.out.println("Enter the campus id:");
        int campusId = scanner.nextInt();
        userService.getNumberOfStudentsForCampusByCampusId(campusId);
    }

}
