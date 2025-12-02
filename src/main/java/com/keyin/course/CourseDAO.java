package com.keyin.course;

import com.keyin.database.DBConnection;
import com.keyin.logger.Logger;
import com.keyin.user.User;

import java.sql.Connection;
import java.sql.SQLException;

public class CourseDAO {

    public void saveNewCourseToDb(Course course) {
        String sql = "INSERT INTO course(coursename,description,credits) VALUES (?,?,?)";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, course.getDescription());
            preparedStatement.setInt(3, course.getCredits());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error saving course to database In DAO");
            Logger.errorLog(e.getMessage());
        }
    }

    public void getListOfStudentsForCourseByName(String courseName) throws SQLException {
        String sql = "SELECT \n" +
                "    u.user_id AS student_id,\n" +
                "    u.username,\n" +
                "    u.email,\n" +
                "    e.enrolled_at,\n" +
                "    c.coursename AS coursename\n" +
                "FROM enrollment e\n" +
                "JOIN users u ON e.student_id = u.user_id\n" +
                "JOIN course c ON e.course_id = c.courseid\n" +
                "WHERE c.coursename = ?\n" +
                "  AND u.role = 'STUDENT';";
        try (Connection connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, courseName);
            var resultSet = preparedStatement.executeQuery();
            System.out.println("Students enrolled in course: " + courseName);
            while (resultSet.next()) {
                System.out.println("===================================");
                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Enrolled At: " + resultSet.getString("enrolled_at"));
                System.out.println("===================================");

            }
        }
    }

    public void printAllCourses() throws SQLException {
        String sql = "SELECT * FROM course";
        try (Connection connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Course ID: " + resultSet.getInt("courseid") + " Course Name: " + resultSet.getString("coursename"));
            }
        }
    }
}
